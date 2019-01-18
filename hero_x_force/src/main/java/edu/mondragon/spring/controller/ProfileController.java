/**
 * @file ProfileController.java
 * @brief Profile controller class
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mondragon.achievement.AchievementService;
import edu.mondragon.email.EmailService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;
import edu.mondragon.userachievementmap.UserAchievementMap;

@Controller
@RequestMapping("/")
public class ProfileController {

	/**
	 * @brief Hibernate services
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	EmailService emailService = ApplicationContextProvider.getContext().getBean(EmailService.class);
	AchievementService achievementService = ApplicationContextProvider.getContext().getBean(AchievementService.class);
	/**
	 * @brief Method that redirects to the profile data view
	 * @param model    Defines a holder for model attributes. Primarily designed for adding attributes to the model
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
	 * @return String
	 */
	@RequestMapping(value = "/profile/data", method = RequestMethod.GET)
	public String showUser(HttpServletRequest request, HttpServletResponse response, Model model) {

		String view = "home";
		if (Validators.checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userService.getUserById(((User) session.getAttribute("user")).getUserId()));
			
			Set<UserAchievementMap> achievementMapSet = userService
					.getUserAchievements(((User) session.getAttribute("user")).getUserId());
			
			List<UserAchievementMap> userAchievementMapList = new ArrayList<>();
			for(UserAchievementMap userAchievementMap: achievementMapSet) {
				userAchievementMapList.add(userAchievementMap);
			}
			
			model.addAttribute("userAchievementMapList", userAchievementMapList);
			
			Integer achievementPercentage = achievementMapSet.size() * 100 / achievementService.listAchievements().size();
			model.addAttribute("achievementPercentage", achievementPercentage);

			view = "profile/data";
		}
		return view;
	}

	/**
	 * @brief Method that redirects to the profile edit view
	 * @param model    Defines a holder for model attributes. Primarily designed for adding attributes to the model
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
	 * @return String
	 */
	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String showUserData(HttpServletRequest request, HttpServletResponse response, Model model) {
		return Validators.checkIfUserIsLogged(request, model) ? "profile/edit" : "home";
	}

	/**
	 * @brief Method that manages the login form
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
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

		if (Validators.validateUserData(model, email, password, confirmPassword)) {
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
	 * @brief Method to send an email to the user and to the HXF team
	 * @param email    Email account string
	 * @param username Username string
	 * @param password Password string
	 */
	public void sendEmail(String email, String username, String password) {
		emailService.sendSimpleMessage(email, "Hero X-Force Account Modification",
				"Your account has been modified." + "\n\nUsername: " + username + "\n\nEmail: " + email
						+ "\n\nPassword: " + password + "\n\nBest Regards, \nHero X-Force Team");
	}

}