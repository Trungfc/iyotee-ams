package com.iyotee.ams.service.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages="com.iyotee.ams.service")
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
//@Import(PersistenceConfig.class)
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/*@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}*/

	/*@Bean
	public JavaMailSenderImpl mailSender() {
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

		return mailSenderImpl;
	}*/

}
