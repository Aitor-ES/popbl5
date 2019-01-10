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
public class CardController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);

	/**
	 * @brief Method to redirect to heroes view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/card/list" }, method = RequestMethod.GET)
	public String heroesPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "card/list" : "home";
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/card/data" }, method = RequestMethod.GET)
	public String cardDataPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "card/data" : "home";
	}

	/**
	 * @brief Method that shows the edit create card view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/card/form", method = RequestMethod.GET)
	public String showAdminTools(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "card/form" : "home";
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
