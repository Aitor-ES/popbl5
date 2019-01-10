package edu.mondragon.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextProvider {

	private static AnnotationConfigApplicationContext context;
	
	/**
	 * Static class to get the context of the application
	 * @return
	 */
	public static AnnotationConfigApplicationContext getContext() {
		return context;
	}
	
	public void setContext(AnnotationConfigApplicationContext context) {
		ApplicationContextProvider.context = context;
	}
}