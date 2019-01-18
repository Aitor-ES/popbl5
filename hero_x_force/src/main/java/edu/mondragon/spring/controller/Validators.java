package edu.mondragon.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import edu.mondragon.user.User;

public class Validators {
	
	/**
	 * @brief Method that checks if users is logged
	 * @param request Provides request information for the servlets
	 * @param model A holder for model attributes
	 * @return boolean
	 */
	public static boolean checkIfUserIsLogged(HttpServletRequest request, Model model) {
		boolean isUserLogged = false;		
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("user") != null) {
			isUserLogged = true;
		} else {
			model.addAttribute("error", "general.notLogged");
		}
		return isUserLogged;
	}

	/**
	 * @brief Method to validate the data inserted by the user
	 * @param model
	 * @param user
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @return
	 */
	public static boolean validateUserData(ModelMap model, User user, String email, String password, String confirmPassword) {
		boolean correct = true;
		
		if (user != null) {
			model.addAttribute("error", "register.user.fail");
			correct = false;
		} else if (!EmailValidator.getInstance(true).isValid(email)) {
			model.addAttribute("error", "register.email.fail");
			correct = false;
		} else if (passwordStrength(password) < 10) {
			model.addAttribute("error", "register.password.length.fail");
			correct = false;
		} else if (!password.equals(confirmPassword)) {
			model.addAttribute("error", "register.password.fail");
			correct = false;
		}
		
		return correct;
	}

	/**
	 * @brief Method to validate the data inserted by the user
	 * @param model
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @return
	 */
	public static boolean validateUserData(ModelMap model, String email, String password, String confirmPassword) {
		boolean correct = true;

		if (!EmailValidator.getInstance(true).isValid(email)) {
			model.addAttribute("error", "register.email.fail");
			correct = false;
		} else if (passwordStrength(password) < 10) {
			model.addAttribute("error", "register.password.length.fail");
			correct = false;
		} else if (!password.equals(confirmPassword)) {
			model.addAttribute("error", "register.password.fail");
			correct = false;
		}

		return correct;
	}

	/**
	 * @brief Checks the strength of the password for 0 to 10
	 * @param password
	 * @return
	 */
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
}
