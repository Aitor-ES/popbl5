/**
 * @file RankingController.java
 * @brief Ranking controller class
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class RankingController {

	/**
	 * @brief Hibernate services
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);

	/**
	 * @brief Method to redirect to ranking view
	 * @param model    Defines a holder for model attributes. Primarily designed for adding attributes to the model
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
	 * @return String
	 */
	@RequestMapping(value = { "/ranking" }, method = RequestMethod.GET)
	public String rankingPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		if (Validators.checkIfUserIsLogged(request, model)) {
			List<User> ranking = userService.listUsers();
			model.addAttribute("ranking", ranking);
			
			view = "ranking";
		}
		return view;
	}

}
