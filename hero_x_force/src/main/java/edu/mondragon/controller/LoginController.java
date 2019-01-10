/**
 * @file LoginController.java
 * @brief This class loads the application configuration
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

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.configuration.WebInitializer;
import edu.mondragon.model.User;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	/**
	 * @brief Hibernate service variables
	 */
	UserService userService = WebInitializer.getContext().getBean(UserService.class);

	/**
	 * @brief Method that manages the login
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") == null) {
			view = "login";
		} else {
			model.addAttribute("error", "general.alreadyLogged");
		}

		return view;
	}

	/**
	 * @brief Method that manages the login form
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/login/form", method = RequestMethod.POST)
	public String loginFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "login";
		User user = userService.getUserByName(request.getParameter("username"));

		if (user == null) {
			model.addAttribute("error", "user.login.fail.user");
			view = "login";
		} else if (user.getPassword().equals(request.getParameter("password"))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			model.addAttribute("message", "user.login.success");
			view = "profile/data";
		} else {
			model.addAttribute("error", "user.login.fail.password");
			view = "login";
		}

		return view;
	}

	/**
	 * @brief Method that manages the register
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") == null) {
			view = "register";
		} else {
			model.addAttribute("error", "general.alreadyLogged");
		}

		return view;
	}

	/**
	 * @brief Method that manages the login form
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/register/form", method = RequestMethod.POST)
	public String registerFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "register";

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean correct = true;

		User user = userService.getUserByName(username);

		if (user != null) {
			model.addAttribute("error", "register.user.fail");
			correct = false;
		} else if (!EmailValidator.getInstance(true).isValid(email) && correct) {
			model.addAttribute("error", "register.email.fail");
			correct = false;
		} else if (passwordStrength(password) < 10 && correct) {
			model.addAttribute("error", "register.password.length.fail");
			correct = false;
		} else if (!password.equals(confirmPassword) && correct) {
			model.addAttribute("error", "register.password.fail");
			correct = false;
		} else if (correct) {
			model.addAttribute("message", "user.new.success");
			userService.addUser(new User(username, email, password));
			view = "login";
		}

		return view;
	}

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
	 * @brief Method that manages the register
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgotPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") == null) {
			view = "forgot";
		} else {
			model.addAttribute("error", "general.alreadyLogged");
		}

		return view;
	}

	/**
	 * @brief Method that manages the forgot form
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/forgot/form", method = RequestMethod.GET)
	public String forgotFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "forgot";

		String email = request.getParameter("email");

		User user = userService.getUserByEmail(email);

		if (user == null) {
			model.addAttribute("error", "forgot.email.fail");
		} else {
			model.addAttribute("message", "forgot.email.success");
			// Send mail
			view = "login";
		}

		return view;
	}

	/**
	 * @brief Method that manages the logout
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession(true);
		session.setAttribute("user", null);
		request.setAttribute("message", "user.logout.success");

		return "home";
	}
}