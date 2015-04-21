package com.hogan.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextUtil {

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		T t = null;
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("config/applicationContext.xml");
		t = (T) ctx.getBean(beanName);
		
		return t;
	}
}
