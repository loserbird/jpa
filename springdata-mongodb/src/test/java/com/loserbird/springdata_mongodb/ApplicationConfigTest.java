package com.loserbird.springdata_mongodb;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationConfigTest {
	
	@Test
	public void bootstrapAppFromJavaConfig() {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}

	@Test
	public void bootstrapAppFromXml() {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
}
