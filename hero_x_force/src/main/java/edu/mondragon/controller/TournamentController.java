/**
 * @file RankingController.java
 * @brief This class manages the tournaments view mapping
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

import edu.mondragon.configuration.EmailConfig;
import edu.mondragon.configuration.HibernateConfig;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class TournamentController {

	/**
	 * @brief The application context
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class, EmailConfig.class);

	/**
	 * @brief The user service
	 */
	UserService userService = context.getBean(UserService.class);

	/**
	 * @brief Method to redirect to tournaments view
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/tournaments" }, method = RequestMethod.GET)
	public String tournamentsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "tournaments" : "home";
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
