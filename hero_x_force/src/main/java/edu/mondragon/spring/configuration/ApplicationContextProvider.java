/**
 * @file ApplicationContextProvider.java
 * @brief Provides the application context in a static way
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.spring.configuration
 */
package edu.mondragon.spring.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextProvider {

	/**
	 * @brief context Standalone application context
	 */
	private static AnnotationConfigApplicationContext context;
	
	/**
	 * @brief Static method to get the context of the application
	 * @return AnnotationConfigApplicationContext object
	 */
	public static AnnotationConfigApplicationContext getContext() {
		return context;
	}
	
	/**
	 * @brief Static method to set the context of the application
	 * @param context AnnotationConfigApplicationContext object
	 * @return void
	 */
	public void setContext(AnnotationConfigApplicationContext context) {
		ApplicationContextProvider.context = context;
	}
}