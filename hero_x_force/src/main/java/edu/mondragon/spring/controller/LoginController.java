/**
 * @file LoginController.java
 * @brief Login controller class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.spring.controller
 */

package edu.mondragon.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.email.EmailService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

	/**
	 * @brief Hibernate services
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	EmailService emailService = ApplicationContextProvider.getContext().getBean(EmailService.class);

	/**
	 * @brief Method that redirects to the login view
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
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
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
	 * @return String
	 */
	@RequestMapping(value = "/login/form", method = RequestMethod.POST)
	public String loginFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "login";

		User user = userService.getUserByName(request.getParameter("username"));
		if (user == null) {
			user = userService.getUserByEmail(request.getParameter("username"));
		}

		if (user == null) {
			model.addAttribute("error", "user.login.fail.user");
			view = "login";
		} else if (user.getPassword().equals(request.getParameter("password"))) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			model.addAttribute("message", "user.login.success");
			view = "redirect:/profile/data";
		} else {
			model.addAttribute("error", "user.login.fail.password");
			view = "login";
		}

		return view;
	}

	/**
	 * @brief Method that redirects to the register view
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
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
	 * @brief Method that manages the register form
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
	 * @return String
	 */
	@RequestMapping(value = "/register/form", method = RequestMethod.POST)
	public String registerFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "register";

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		User user = userService.getUserByName(username);

		if (Validators.validateUserData(model, user, email, password, confirmPassword)) {
			model.addAttribute("message", "user.new.success");
			userService.addUser(new User(username, email, password));
			sendEmail(email, username, password);
			view = "login";
		}

		return view;
	}

	/**
	 * @brief Method to send an email to the user and to the HXF team
	 * @param email    Email account string
	 * @param username Username string
	 * @param password Password string
	 */
	public void sendEmail(String email, String username, String password) {
		emailService.sendSimpleMessage(email, "Hero X-Force Account Registration", "Your account has been registered."
				+ "\n\nUsername: " + username + "\n\nBest Regards, \nHero X-Force Team");

		emailService.sendSimpleMessage("popbl5.heroxforce@gmail.com", "Hero X-Force Account Registration",
				"This account has been registered." + "\n\nUsername: " + username + "\n\nEmail: " + email
						+ "\n\nTotal users: " + userService.getUserByName(username).getUserId());
	}

	/**
	 * @brief Method that redirects to the forgot view
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
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
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
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
			emailService.sendSimpleMessage(email, "Hero X-Force Password Recovery",
					"This account has requested password recovery." + "\n\nUsername: " + user.getUsername()
							+ "\nPassword: " + user.getPassword() + "\n\nBest Regards, \nHero X-Force Team");
			view = "login";
		}

		return view;
	}

	/**
	 * @brief Method that performs the logout
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
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