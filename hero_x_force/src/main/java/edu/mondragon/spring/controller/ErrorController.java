package edu.mondragon.spring.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mondragon.email.EmailService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class ErrorController {
	/**
	 * @brief Spring Services
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	EmailService emailService = ApplicationContextProvider.getContext().getBean(EmailService.class);
	
	/**
	 * @brief error controller
	 * @param httpRequest
	 * @return
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(HttpServletRequest request, Model model) {
		String view = "error";

		int errorCode = getErrorCode(request);

		model.addAttribute("errorCode", errorCode);
		return view;
	}

	/**
	 * @bried Function to get the error code
	 * @param httpRequest
	 * @return
	 */
	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}

}