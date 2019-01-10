/**
 * @file WebInitializer.java
 * @brief This class loads the application configuration
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.configuration
 */

package edu.mondragon.configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
	/**
	 * @brief AnnotationConfigApplicationContext
	 */
	private static AnnotationConfigApplicationContext context;
	
	/**
	 * @brief This method loads the configuration
	 * @param container The servlet context
	 * @return void
	 */
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

		ctx.register(ApplicationConfig.class);

		container.addListener(new ContextLoaderListener(ctx));

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

		// UTF-8 Character Filter.
		FilterRegistration.Dynamic fr = container.addFilter("encodingFilter", CharacterEncodingFilter.class);

		fr.setInitParameter("encoding", "UTF-8");
		fr.setInitParameter("forceEncoding", "true");
		fr.addMappingForUrlPatterns(null, true, "/*");
		
		context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		
		// Inserts
	}
	
	/**
	 * Static class to get the context of the application
	 * @return
	 */
	public static AnnotationConfigApplicationContext getContext() {
		return context;
	}
	
}