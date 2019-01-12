package edu.mondragon.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 * @brief Method to redirect to tournaments view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/tournaments" }, method = RequestMethod.GET)
	public String tournamentsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		if (checkIfUserIsLogged(request, model)) {
			List<Tournament> availableTournamentList = tournamentService.listTournaments();
			model.addAttribute("availableTournamentList", availableTournamentList);
			for (Tournament t : availableTournamentList) {
				System.out.println(t.getName());
			}
			view = "tournaments";
		}
		return view;
	}
	
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
