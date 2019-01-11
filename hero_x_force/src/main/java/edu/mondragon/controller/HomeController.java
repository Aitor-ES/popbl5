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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mondragon.configuration.EmailConfig;
import edu.mondragon.configuration.HibernateConfig;
import edu.mondragon.model.User;
import edu.mondragon.service.EmailService;
import edu.mondragon.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

	/**
	 * @brief The application context
	 */
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class, EmailConfig.class);
	
	/**
	 * @brief Spring Services
	 */
	public UserService userService = context.getBean(UserService.class);
	public EmailService emailService = context.getBean(EmailService.class);
	
	
	/**
	 * @brief Method that manages the home page
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/home/form" }, method = RequestMethod.POST)
	public String homePage(HttpServletRequest request, ModelMap model) {
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