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
public class TournamentController {

	/**
	 * @brief The application context
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

	/**
	 * @brief The user service
	 */
	UserService userService = context.getBean(UserService.class);

	/**
	 * @brief Method to redirect to tournaments view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/tournaments" }, method = RequestMethod.GET)
	public String tournamentsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "tournaments" : "home";
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
