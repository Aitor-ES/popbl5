/**
 * @file ErrorController.java
 * @brief Error controller class
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ErrorController {
	
	/**
	 * @brief Method which redirects to the error page
	 * @param model    Defines a holder for model attributes. Primarily designed for adding attributes to the model
	 * @param request  Defines an object to provide client request information to a servlet
	 * @return String
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(HttpServletRequest request, Model model) {
		String view = "error";

		int errorCode = getErrorCode(request);

		model.addAttribute("errorCode", errorCode);
		return view;
	}

	/**
	 * @bried Method to get the error code
	 * @param request  Defines an object to provide client request information to a servlet
	 * @return int
	 */
	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}

}