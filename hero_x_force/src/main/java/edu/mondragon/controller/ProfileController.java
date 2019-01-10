package edu.mondragon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.configuration.WebInitializer;
import edu.mondragon.model.User;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class ProfileController {
	/**
	 * @brief The user service
	 */
	UserService userService = WebInitializer.getContext().getBean(UserService.class);

	/**
	 * @brief Method that shows the profile
	 * @param id    Users id
	 * @param model implementation of Map for use when building data model
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
	 * @return String
	 */
	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String showUserData(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "profile/edit" : "home";
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
