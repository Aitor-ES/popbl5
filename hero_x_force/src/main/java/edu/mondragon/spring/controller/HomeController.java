/**
 * @file HomeController.java
 * @brief Home controller class
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
public class HomeController {

	/**
	 * @brief Hibernate services
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	EmailService emailService = ApplicationContextProvider.getContext().getBean(EmailService.class);

	/**
	 * @brief Method that redirects to the default page
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @return String
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String defaultPage(ModelMap model) {
		return "home";
	}
	
	/**
	 * @brief Method that redirects to the home view
	 * @return String
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	/**
	 * @brief Method sends a mail to another user
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a servlet
	 * @return String
	 */
	@RequestMapping(value = { "/home/form" }, method = RequestMethod.POST)
	public String homeForm(HttpServletRequest request, ModelMap model) {
		String view = "home";
		
		String username = request.getParameter("username");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		User user = userService.getUserByName(username);
		
		if (user != null) {
			emailService.sendSimpleMessage("popbl5.heroxforce@gmail.com", "CONTACT US - " + subject, 
				  "Message received from:" +
				  "\n\nUsername: " + user.getUsername() + 
				  "\nEmail: " + user.getEmail() +
				  "\n\n[...] " + message + " [...]");
			
			model.addAttribute("message", "contact.email.success");
		} else {
			model.addAttribute("error", "contact.email.fail");
		}
		
		return view;
	}
}