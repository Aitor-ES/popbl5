package edu.mondragon.spring.controller;
/**
 * @file ProfileController.java
 * @brief This class manages the profile view mapping
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
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

import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class ProfileController {
	/**
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);

	/**
	 * @brief Method that shows the profile
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = "/profile/data", method = RequestMethod.GET)
	public String showUser(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "profile/data" : "home";
	}

	/**
	 * @brief Method that shows the profile with ID
	 * @param id    Users id
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = "/profile/{id}/data", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {

		User user = userService.getUserById(id);

		if (user == null) {
			// model.addAttribute("css", "danger");
			model.addAttribute("message", "User not found");
		}

		model.addAttribute("user", user);

		return "profile/data";
	}

	/**
	 * @brief Method that shows the view to edit the user data
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String showUserData(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "profile/edit" : "home";
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
