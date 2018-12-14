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

package edu.mondragon.controllers;

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

import edu.mondragon.configuration.HibernateApplicationConfiguration;
import edu.mondragon.model.User;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class TilesController {
	
	/**
	 * @brief The application context
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
			HibernateApplicationConfiguration.class);

	/**
	 * @brief The user service
	 */
	UserService userService = context.getBean(UserService.class);

	/**
	 * @brief The application context
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	/**
	 * @brief Method that manages the login
	 * @param request
	 * @param reponse
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "";
		User user = userService.getUserByName(request.getParameter("username"));

		if (user == null) {
			model.addAttribute("msg", "User not found");
			view = "home";
		} else if (user.getPassword().equals(request.getParameter("password"))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			view = "profile";
		} else {
			model.addAttribute("msg", "Incorrect password");
			view = "home";
		}

		return view;
	}

	/**
	 * @brief Method to redirect to duels view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/duels" }, method = RequestMethod.GET)
	public String duelsPage(ModelMap model) {
		return "duels";
	}

	/**
	 * @brief Method to redirect to heroes view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/heroes" }, method = RequestMethod.GET)
	public String heroesPage(ModelMap model) {
		return "heroes";
	}
	
	/**
	 * @brief Method that shows the user
	 * @param id Users id
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showUser(Model model) {
		return "profile";
	}
	
	/**
	 * @brief Method that shows the user
	 * @param id Users id
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
	 * @brief Method to redirect to ranking view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/ranking" }, method = RequestMethod.GET)
	public String rankingPage(ModelMap model) {
		return "ranking";
	}
	/**
	 * @brief Method to redirect to torunaments view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/tournaments" }, method = RequestMethod.GET)
	public String tournamentsPage(ModelMap model) {
		return "tournaments";
	}
}