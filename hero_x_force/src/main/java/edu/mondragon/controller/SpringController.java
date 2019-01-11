/**
 * @file SpringController.java
 * @brief This class manages the home view mapping
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.controllers
 */

package edu.mondragon.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.configuration.EmailConfig;
import edu.mondragon.configuration.HibernateConfig;

@Controller
@RequestMapping("/")
public class SpringController {

	/**
	 * @brief The application context
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class, EmailConfig.class);

	/**
	 * @brief Method that manages the default page
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap model) {
		return "home";
	}
	
}