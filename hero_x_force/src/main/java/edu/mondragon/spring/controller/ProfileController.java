package edu.mondragon.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.achievement.Achievement;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;
import edu.mondragon.userachievementmap.UserAchievementMap;

@Controller
@RequestMapping("/")
public class ProfileController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);

	/**
	 * @brief Method that shows the profile
	 * @param id    Users id
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/profile/data", method = RequestMethod.GET)
	public String showUser(HttpServletRequest request, HttpServletResponse response, Model model) {

		String view = "home";
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<UserAchievementMap> achievementMapList = userService.getUserAchievements(((User) session.getAttribute("user")).getUser_id());
			
			List<Achievement> achievementList = new ArrayList<>();
			for (UserAchievementMap userAchievementMap : achievementMapList) {
				achievementList.add(userAchievementMap.getAchievement());
			}
			model.addAttribute("achievementList", achievementList);
			
			view = "profile/data";
		}
		return view;
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
