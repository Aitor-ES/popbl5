package edu.mondragon.spring.controller;

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
	 * @return String
	 */
	@RequestMapping(value = { "/duels" }, method = RequestMethod.GET)
	public String duelsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<UserMatchMap> user_2_matchMapList = userService.getUser_2_matches(((User) session.getAttribute("user")).getUser_id());
			
			model.addAttribute("user_2_matchMapList", user_2_matchMapList);
			
			view = "duels";
		}
		return view;
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
