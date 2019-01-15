package edu.mondragon.spring.controller;
/**
 * @file RankingController.java
 * @brief This class manages the tournaments view mapping
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.controllers
 */

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.tournament.Tournament;
import edu.mondragon.tournament.TournamentService;

@Controller
@RequestMapping("/")
public class TournamentController {
	/**
	 * @brief The user service
	 */
	TournamentService tournamentService = ApplicationContextProvider.getContext().getBean(TournamentService.class);

	/**
	 * @brief Method to redirect to tournament list view
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model    A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/tournament/list" }, method = RequestMethod.GET)
	public String tournamentListPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		if (checkIfUserIsLogged(request, model)) {
			List<Tournament> availableTournamentList = tournamentService.listTournaments();
			model.addAttribute("availableTournamentList", availableTournamentList);
			for (Tournament t : availableTournamentList) {
				System.out.println(t.getName());
			}
			view = "tournament/list";
		}
		return view;
	}

	/**
	 * @brief Method to redirect to tournament create view
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/tournament/create" }, method = RequestMethod.GET)
	public String tournamentCreatePage(HttpServletRequest request, Model model) {
		String view = "home";
		if (checkIfUserIsLogged(request, model)) {
			view = "tournament/create";
		}
		return view;
	}
	
	/**
	 * @brief Method that manages the tournament creation form
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/tournament/form", method = RequestMethod.POST)
	public String registerFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "tournament/create";
		
		String name = request.getParameter("name");
		int participants = Integer.valueOf(request.getParameter("participants"));
		
		if (validateData(model, participants))
		{
			Tournament tournament = new Tournament(name,participants);
			tournamentService.addTournament(tournament);
			model.addAttribute("message", "tournament.participants.success");
			view = "redirect:/tournament/list";
		}
		
		return view;
	}

	/**
	 * @brief Function to validate tournament data
	 * @param model
	 * @param participants
	 * @return
	 */
	public boolean validateData(ModelMap model, int participants) {
		boolean correct = true;
		
		if (!IsPowerOfTwo(participants) || participants < 4) {
			model.addAttribute("error", "tournament.participants.fail");
			correct = false;
		}
		
		return correct;
	}
	
	/**
	 * @brief checks if a number is a power of two
	 * @param participants
	 * @return
	 */
	public Boolean IsPowerOfTwo(int participants)
	{
	    return (participants != 0) && ((participants & (participants - 1)) == 0);
	}
	
	/**
	 * @brief Method that checks if users is logged
	 * @param request Provides request information for the servlets
	 * @param model   A holder for model attributes
	 * @return boolean
	 */
	public boolean checkIfUserIsLogged(HttpServletRequest request, Model model) {
		boolean isUserLogged = false;
		HttpSession session = request.getSession(true);

		if (session.getAttribute("user") != null) {
			isUserLogged = true;
		} else {
			model.addAttribute("error", "general.notLogged");
		}
		return isUserLogged;
	}

}
