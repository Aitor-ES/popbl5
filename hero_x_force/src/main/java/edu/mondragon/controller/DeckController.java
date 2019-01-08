/**
 * @file DeckController.java
 * @brief This class loads the controls the deck views mapping
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.configuration.HibernateConfig;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class DeckController {

	/**
	 * @brief The application context
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

	/**
	 * @brief The user service
	 */
	UserService userService = context.getBean(UserService.class);

	/**
	 * @brief Method to redirect to decks view
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/deck/list" }, method = RequestMethod.GET)
	public String decksPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "deck/list" : "home";
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/deck/form" }, method = RequestMethod.GET)
	public String deckFormPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "deck/form" : "home";
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/deck/data" }, method = RequestMethod.GET)
	public String deckDataPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "deck/data" : "home";
	}
	
	/**
	 * @brief Method that checks if users is logged
	 * @param request Provides request information for the servlets
	 * @param model A holder for model attributes
	 * @return boolean
	 */
	public boolean checkIfUserIsLogged(HttpServletRequest request, Model model) {
		boolean isUserLogged = false;		
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("user") != null) {
			isUserLogged = true;
		} else {
			model.addAttribute("error", "general.notLogged");
		}
		return isUserLogged;
	}

}
