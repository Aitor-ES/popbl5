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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mondragon.achievement.Achievement;
import edu.mondragon.email.EmailService;
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
	EmailService emailService = ApplicationContextProvider.getContext().getBean(EmailService.class);

	/**
	 * @brief Method that shows the profile
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model    A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = "/profile/data", method = RequestMethod.GET)
	public String showUser(HttpServletRequest request, HttpServletResponse response, Model model) {

		String view = "home";
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<UserAchievementMap> achievementMapList = userService
					.getUserAchievements(((User) session.getAttribute("user")).getUser_id());

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
	 * @brief Method that shows the view to edit the user data
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model    A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String showUserData(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "profile/edit" : "home";
	}

	/**
	 * @brief Method that manages the login form
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/profile/form", method = RequestMethod.POST)
	public String registerFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "profile/edit";

		HttpSession session = request.getSession(true);

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		User sessionUser = (User) session.getAttribute("user");

		if (validateData(model, email, password, confirmPassword)) {
			if (username.equals(sessionUser.getUsername())) {
				sessionUser.setEmail(email);
				sessionUser.setPassword(password);

				userService.updateUser(sessionUser);
				model.addAttribute("message", "user.modified.success");
				sendEmail(username, email, password);
				view = "profile/data";
			} else {
				User user = userService.getUserByName(username);

				if (user == null) {
					sessionUser.setUsername(username);
					sessionUser.setEmail(email);
					sessionUser.setPassword(password);

					userService.updateUser(sessionUser);
					model.addAttribute("message", "user.modified.success");
					sendEmail(email, username, password);
					view = "profile/data";
				} else {
					model.addAttribute("error", "register.user.fail");
				}
			}
		}

		return view;
	}

	/**
	 * @brief Method to send an email to the user and to the hero-x-force team
	 * @param email
	 * @param username
	 * @param password
	 */
	public void sendEmail(String email, String username, String password) {
		emailService.sendSimpleMessage(email, "Hero X-Force Account Modification",
				"Your account has been modified." + "\n\nUsername: " + username + "\n\nEmail: " + email
						+ "\n\nPassword: " + password + "\n\nBest Regards, \nHero X-Force Team");
	}

	/**
	 * @brief Method to validate the data inserted by the user
	 * @param model
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @return
	 */
	public boolean validateData(ModelMap model, String email, String password, String confirmPassword) {
		boolean correct = true;

		if (!EmailValidator.getInstance(true).isValid(email) && correct) {
			model.addAttribute("error", "register.email.fail");
			correct = false;
		} else if (passwordStrength(password) < 10 && correct) {
			model.addAttribute("error", "register.password.length.fail");
			correct = false;
		} else if (!password.equals(confirmPassword) && correct) {
			model.addAttribute("error", "register.password.fail");
			correct = false;
		}

		return correct;
	}

	/**
	 * @brief Checks the strength of the password for 0 to 10
	 * @param password
	 * @return
	 */
	private static int passwordStrength(String password) {
		// total score of password
		int passwordScore = 0;

		if (password.length() >= 8) {
			passwordScore += 2;

			// if it contains one digit, add 2 to total score
			if (password.matches("(?=.*[0-9]).*")) {
				passwordScore += 2;
			}

			// if it contains one lower case letter, add 2 to total score
			if (password.matches("(?=.*[a-z]).*")) {
				passwordScore += 2;
			}

			// if it contains one upper case letter, add 2 to total score
			if (password.matches("(?=.*[A-Z]).*")) {
				passwordScore += 2;
			}

			// if it contains one special character, add 2 to total score
			if (password.matches("(?=.*[~!@#$%^&*()_-]).*")) {
				passwordScore += 2;
			}
		}

		return passwordScore;
	}

	/**
	 * @brief Method that checks if users is logged
	 * @param request Provides request information for the servlets
	 * @param model   A holder for model attributes
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