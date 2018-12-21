/**
 * @file TilesController.java
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

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.configuration.HibernateConfig;
import edu.mondragon.model.User;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class SpringController {

	/**
	 * @brief The application context
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

	/**
	 * @brief The user service
	 */
	UserService userService = context.getBean(UserService.class);

	/**
	 * @brief Method that manages the default page
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap model) {
		return "home";
	}

	/**
	 * @brief Method that manages the home page
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	/**
	 * @brief Method that manages the login
	 * @param request
	 * @param reponse
	 * @param model   implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "login";
		User user = userService.getUserByName(request.getParameter("username"));

		if (user == null) {
			view = "login";
		} else if (user.getPassword().equals(request.getParameter("password"))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			model.addAttribute("message", "user.login.success");
			view = "profile";
		} else {
			model.addAttribute("error", "user.login.fail.password");
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

	/**
	 * @brief Method that shows the profile
	 * @param id    Users id
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showUser(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null) {
			view = "profile";
		} else {
			model.addAttribute("error", "general.notLogged");
		}

		return view;
	}

	/**
	 * @brief Method that shows the profile with ID
	 * @param id    Users id
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {

		User user = userService.getUserById(id);

		if (user == null) {
			// model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}

		model.addAttribute("user", user);

		return "profile";
	}

	/**
	 * @brief Method to redirect to decks view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/decks" }, method = RequestMethod.GET)
	public String decksPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null) {
			view = "decks";
		} else {
			model.addAttribute("error", "general.notLogged");
		}

		return view;
	}

	/**
	 * @brief Method to redirect to heroes view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/heroes" }, method = RequestMethod.GET)
	public String heroesPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null) {
			view = "heroes";
		} else {
			model.addAttribute("error", "general.notLogged");
		}

		return view;
	}

	/**
	 * @brief Method to redirect to duels view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/duels" }, method = RequestMethod.GET)
	public String duelsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null) {
			view = "duels";
		} else {
			model.addAttribute("error", "general.notLogged");
		}

		return view;
	}

	/**
	 * @brief Method to redirect to tournaments view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/tournaments" }, method = RequestMethod.GET)
	public String tournamentsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null) {
			view = "tournaments";
		} else {
			model.addAttribute("error", "general.notLogged");
		}

		return view;
	}

	/**
	 * @brief Method to redirect to ranking view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/ranking" }, method = RequestMethod.GET)
	public String rankingPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null) {
			view = "ranking";
		} else {
			model.addAttribute("error", "general.notLogged");
		}

		return view;
	}
}