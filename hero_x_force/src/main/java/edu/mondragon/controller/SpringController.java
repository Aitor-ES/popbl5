/**
 * @file SpringController.java
 * @brief This class loads the application configuration
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


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.configuration.WebInitializer;
import edu.mondragon.service.TournamentService;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class SpringController {
	/**
	 * @brief The user service
	 */
	UserService userService = WebInitializer.getContext().getBean(UserService.class);
	
	/**
	 * @brief The tournament service
	 */
	TournamentService tournamentService = WebInitializer.getContext().getBean(TournamentService.class);

	/**
	 * @brief Method that manages the default page
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap model) {
		return "home";
	}

	/**
	 * @brief Method that manages the home page
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}
}