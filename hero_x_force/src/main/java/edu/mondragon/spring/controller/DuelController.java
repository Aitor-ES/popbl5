package edu.mondragon.spring.controller;
/**
 * @file DuelController.java
 * @brief This class manages the duel view mapping
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.controllers
 */

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;
import edu.mondragon.usermatchmap.UserMatchMap;

@Controller
@RequestMapping("/")
public class DuelController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);

	/**
	 * @brief Method to redirect to duels view
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/duel/list" }, method = RequestMethod.GET)
	public String duelsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<UserMatchMap> user_2_matchMapList = userService.getUser_2_matches(((User) session.getAttribute("user")).getUser_id());
			
			model.addAttribute("user_2_matchMapList", user_2_matchMapList);
			
			view = "duel/list";
		}
		return view;
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
