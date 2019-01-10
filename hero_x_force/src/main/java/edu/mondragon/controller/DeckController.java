package edu.mondragon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.configuration.ApplicationContextProvider;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class DeckController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);

	/**
	 * @brief Method to redirect to decks view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/deck/list" }, method = RequestMethod.GET)
	public String decksPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "deck/list" : "home";
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/deck/form" }, method = RequestMethod.GET)
	public String deckFormPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "deck/form" : "home";
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/deck/data" }, method = RequestMethod.GET)
	public String deckDataPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "deck/data" : "home";
	}
	
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
