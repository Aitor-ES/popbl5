/**
 * @file TournamentController.java
 * @brief Tournament controller class
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
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.tournament.Tournament;
import edu.mondragon.tournament.TournamentService;
import edu.mondragon.user.User;
import edu.mondragon.usertournamentmap.UserTournamentMap;
import edu.mondragon.usertournamentmap.UserTournamentMapService;

@Controller
@RequestMapping("/")
public class TournamentController {

	/**
	 * @brief Hibernate services
	 */
	TournamentService tournamentService = ApplicationContextProvider.getContext().getBean(TournamentService.class);
	UserTournamentMapService userTournamentMapService = ApplicationContextProvider.getContext()
			.getBean(UserTournamentMapService.class);

	/**
	 * @brief Method to redirect to tournament list view
	 * @param model    Defines a holder for model attributes. Primarily designed for
	 *                 adding attributes to the model
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
	 * @return String
	 */
	@RequestMapping(value = { "/tournament/list" }, method = RequestMethod.GET)
	public String tournamentListPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		if (Validators.checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);

			List<Tournament> availableTournamentList = tournamentService.listTournaments();
			List<Tournament> joinedTournamentList = new ArrayList<>();

			ListIterator<Tournament> it = availableTournamentList.listIterator();
			while (it.hasNext()) {
				Tournament tournament = it.next();
				for (UserTournamentMap userTournamentMap : tournament.getUserTournamentMaps()) {
					if (userTournamentMap.getUser().getUserId() == ((User) session.getAttribute("user")).getUserId()) {
						joinedTournamentList.add(tournament);
						it.remove();
					}
				}
			}
			model.addAttribute("availableTournamentList", availableTournamentList);
			model.addAttribute("joinedTournamentList", joinedTournamentList);

			System.out.println(availableTournamentList);
			System.out.println(joinedTournamentList);

			view = "tournament/list";
		}

		return view;
	}

	/**
	 * @brief Method to redirect to tournament create view
	 * @param model   Defines a holder for model attributes. Primarily designed for
	 *                adding attributes to the model
	 * @param request Defines an object to provide client request information to a
	 *                servlet
	 * @return
	 */
	@RequestMapping(value = { "/tournament/create" }, method = RequestMethod.GET)
	public String tournamentCreatePage(HttpServletRequest request, Model model) {
		String view = "home";
		if (Validators.checkIfUserIsLogged(request, model)) {
			view = "tournament/create";
		}
		return view;
	}

	/**
	 * @brief Method that manages the tournament creation form
	 * @param model    This class serves as generic model holder for Servlet MVC
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
	 * @return
	 */
	@RequestMapping(value = "/tournament/form", method = RequestMethod.POST)
	public String tournamentForm(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "tournament/create";

		String name = request.getParameter("name");
		int participants = Integer.valueOf(request.getParameter("participants"));

		if (Validators.validateParticipantNumber(model, participants)) {
			Tournament tournament = new Tournament(name, participants);
			tournamentService.addTournament(tournament);
			model.addAttribute("message", "tournament.create.success");
			view = "redirect:/tournament/list";
		}

		return view;
	}

	/**
	 * @brief Method that lets the user join a tournament
	 * @param model    Defines a holder for model attributes. Primarily designed for
	 *                 adding attributes to the model
	 * @param request  Defines an object to provide client request information to a
	 *                 servlet
	 * @param response Defines an object to assist a servlet in sending a response
	 *                 to the client
	 * @param id       To know which tournament we are joining
	 * @return
	 */
	@RequestMapping(value = "/tournament/{id}/join", method = RequestMethod.GET)
	public String tournamentJoin(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String view = "redirect:/tournament/list";

		if (Validators.checkIfUserIsLogged(request, model)) {
			Tournament tournament = tournamentService.getTournamentById(id);
			if (tournament.getUserTournamentMaps().size() < tournament.getNumParticipants()) {
				HttpSession session = request.getSession(true);

				UserTournamentMap userTournamentMap = new UserTournamentMap((User) session.getAttribute("user"),
						tournament);
				userTournamentMapService.addUserTournamentMap(userTournamentMap);
			}
		}
		return view;
	}

}
