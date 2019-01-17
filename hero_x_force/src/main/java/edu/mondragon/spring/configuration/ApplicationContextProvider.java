/**
 * @file ApplicationContextProvider.java
 * @brief Provides the application context
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
	 * @brief application context
	 */
	private static AnnotationConfigApplicationContext context;
	
	/**
	 * @brief Static class to get the context of the application
	 * @return AnnotationConfigApplicationContext
	 */
	public static AnnotationConfigApplicationContext getContext() {
		return context;
	}
	
	/**
	 * @brief Static class to set the context of the application
	 * @return void
	 */
	public void setContext(AnnotationConfigApplicationContext context) {
		ApplicationContextProvider.context = context;
	}
}