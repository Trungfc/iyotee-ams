package com.iyotee.ams.service.config;

import com.iyotee.ams.data.config.PersistenceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "com.iyotee.ams.service")
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@Import(PersistenceConfig.class)
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * EhCache library setup.
	 */
	@Bean
	@Autowired
	public CacheManager cacheManager(net.sf.ehcache.CacheManager ehCache) {
		return new org.springframework.cache.ehcache.EhCacheCacheManager(ehCache);
	}

	// TODO: JSR-107 cache manager setup.
	@Bean
	public org.springframework.cache.ehcache.EhCacheManagerFactoryBean ehCache() {
		return new org.springframework.cache.ehcache.EhCacheManagerFactoryBean();
	}

	/*@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(env.getProperty("smtp.host"));
		mailSender.setPort(env.getProperty("smtp.port", Integer.class));
		mailSender.setProtocol(env.getProperty("smtp.protocol"));
		mailSender.setUsername(env.getProperty("smtp.username"));
		mailSender.setPassword(env.getProperty("smtp.password"));

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		mailSender.setJavaMailProperties(props);

		return mailSender;
	}*/

}
