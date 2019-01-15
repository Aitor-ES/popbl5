package edu.mondragon.spring.controller;
/**
 * @file CardController.java
 * @brief This class manages the card views mapping
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.controllers
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.card.Card;
import edu.mondragon.card.CardService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class CardController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	CardService cardService= ApplicationContextProvider.getContext().getBean(CardService.class);

	/**
	 * @brief Method to redirect to heroes view
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/card/list" }, method = RequestMethod.GET)
	public String heroesPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "card/list" : "home";
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/card/{id}/data" }, method = RequestMethod.GET)
	public String cardDataPage(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable("id") int id) {

		Card card = cardService.getCardById(id);
		
		model.addAttribute("card", card);
		return checkIfUserIsLogged(request, model) ? "card/data" : "home";
	}

	/**
	 * @brief Method that shows the edit create card view
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = "/card/form", method = RequestMethod.GET)
	public String showAdminTools(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "card/form" : "home";
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
