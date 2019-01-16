package edu.mondragon.spring.controller;
/**
 * @file DuelController.java
 * @brief This class manages the duel view mapping
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.controllers
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.mondragon.card.Card;
import edu.mondragon.deck.Deck;
import edu.mondragon.deck.DeckService;
import edu.mondragon.deckcardmap.DeckCardMap;
import edu.mondragon.match.Match;
import edu.mondragon.match.MatchService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class DuelController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	MatchService matchService = ApplicationContextProvider.getContext().getBean(MatchService.class);
	DeckService deckService = ApplicationContextProvider.getContext().getBean(DeckService.class);

	private List<String> battleLog = new ArrayList<>();

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

	/**
	 * @brief Method to redirect to duels view
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model    A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/duel/list" }, method = RequestMethod.GET)
	public String duelsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<Match> matchesAsUser_2 = userService
					.getMatchesAsUser_2(((User) session.getAttribute("user")).getUser_id());
			model.addAttribute("matchesAsUser_2", matchesAsUser_2);

			Set<Deck> deckList = userService.getUserDecks(((User) session.getAttribute("user")).getUser_id());
			model.addAttribute("deckList", deckList);

			view = "duel/list";
		}

		return view;
	}

	/**
	 * @brief Method to redirect to duel create view
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/duel/create" }, method = RequestMethod.GET)
	public String duelCreatePage(HttpServletRequest request, Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			User sessionUser = (User) session.getAttribute("user");

			// Remove currentUser from the list
			List<User> userList = userService.listUsers();
			ListIterator<User> iterator = userList.listIterator();
			while (iterator.hasNext()) {
				if (iterator.next().getUser_id() == sessionUser.getUser_id()) {
					iterator.remove();
				}
			}
			// Add user list to create page
			model.addAttribute("userList", userList);

			// Add deck list to create page
			Set<Deck> deckList = userService.getUserDecks(sessionUser.getUser_id());
			model.addAttribute("deckList", deckList);

			view = "duel/create";
		}

		return view;
	}

	/**
	 * @brief Method that manages the duel creation form
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/duel/create/save", method = RequestMethod.POST)
	public String registerFormPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String view = "redirect:/duel/list";

		Integer opponent_id = Integer.valueOf(request.getParameter("opponent_id"));
		Integer myDeck_id = Integer.valueOf(request.getParameter("myDeck_id"));

		Match match = new Match();
		// Creator
		HttpSession session = request.getSession(true);
		match.setUser_1(userService.getUserById(((User) session.getAttribute("user")).getUser_id()));
		match.setDeck_1(deckService.getDeckById(myDeck_id));

		// Opponent
		match.setUser_2(userService.getUserById(opponent_id));

		matchService.addMatch(match);
		model.addAttribute("message", "duel.create.success");

		return view;
	}

	/**
	 * @brief Method to redirect to duels battle
	 * @param model   implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param id      The duel id contained in the mapping link
	 * @param model   A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/duel/{id}/loadBattle" }, method = RequestMethod.POST)
	public String loadBattlePage(@PathVariable("id") int id, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			if (request.getParameter("action").equals("accept")) {
				HttpSession session = request.getSession(true);
				Match match = matchService.getMatchById(id);

				Integer myDeck_id = Integer.valueOf(request.getParameter("deck-picker-" + id));
				match.setDeck_2(deckService.getDeckById(myDeck_id));

				if (match.getWinner() == null) {
					session.setAttribute("match", match);
					this.battleLog = new ArrayList<>();

					view = "duel/battle";
				}
			} else {
				// Remove match
				Match match = matchService.getMatchById(id);
				matchService.removeMatch(match);
				view = "redirect:/duel/list";
			}
		}
		return view;
	}

	/**
	 * @brief
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/duel/battle" }, method = RequestMethod.GET)
	public String battlePage(HttpServletRequest request, Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Match match = (Match) session.getAttribute("match");
			if (match != null) {
				Deck deck_1 = match.getDeck_1();
				Deck deck_2 = match.getDeck_2();

				this.startBattle(deck_1, deck_2);

				session.setAttribute("match", null);
				view = "profile/data";
			}
		}
		return view;
	}

	/**
	 * @brief
	 * @return
	 */
	@RequestMapping(value = "/duel/battle/update", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxUpdateBattleLog(/* @RequestParam("id")String id */) {
		JSONArray jsonArray = new JSONArray();

		for (String string : battleLog) {
			// Generate String JSON Object
			JSONObject jsonString = new JSONObject();

			// Put the string inside the JSON Object
			jsonString.put("battleLogLine", string);

			// Put the JSON Object in the JSON Array
			jsonArray.put(jsonString);
		}
		/*
		 * It's important to call toString() so that it returns a char string. So it
		 * transforms the JSON Object/Array to a normal string. Then the client will
		 * transform back to JSON
		 */
		return jsonArray.toString();
	}

	/**
	 * @brief
	 * @param deck_1
	 * @param deck_2
	 * @return
	 */
	public boolean startBattle(Deck deck_1, Deck deck_2) {
		Card hero_1;
		Card hero_2;

		int player_1_points = 0;
		int player_2_points = 0;

		Iterator<DeckCardMap> it_1 = deck_1.getDeckCardMaps().iterator();
		Iterator<DeckCardMap> it_2 = deck_2.getDeckCardMaps().iterator();

		int i = 1;

		while (it_1.hasNext() && it_2.hasNext()) {
			this.battleLog.add("ROUND " + i);

			hero_1 = it_1.next().getCard();
			hero_2 = it_2.next().getCard();

			if (startRound(hero_1, hero_2)) {
				player_1_points++;
				this.battleLog.add("PLAYER 1 WON ROUND " + i);
			} else {
				player_2_points++;
				this.battleLog.add("PLAYER 2 WON ROUND " + i);
			}
			i++;
		}
		this.battleLog.add("ROUNDS WON BY PLAYER 1: " + player_1_points);
		this.battleLog.add("ROUNDS WON BY PLAYER 2: " + player_2_points);
		this.battleLog.add("PLAYER " + ((player_1_points > player_2_points) ? "1" : "2") + " WINS!");

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return (player_1_points > player_2_points);
	}

	/**
	 * @brief
	 * @param hero_1
	 * @param hero_2
	 * @return
	 */
	private boolean startRound(Card hero_1, Card hero_2) {
		boolean is_hero_1_winner;

		this.battleLog.add("Hero 1: " + hero_1.getName());
		this.battleLog.add("Hero 2: " + hero_2.getName());
		int i = 1;

		do {
			this.battleLog.add("TURN " + i);

			startTurn(hero_1, hero_2);

			i++;
		} while (hero_1.getHp() > 0 && hero_2.getHp() > 0);

		if (hero_1.getHp() > 0) {
			is_hero_1_winner = true;
		} else {
			is_hero_1_winner = false;
		}

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return is_hero_1_winner;
	}

	/**
	 * @brief
	 * @param hero_1
	 * @param hero_2
	 */
	private void startTurn(Card hero_1, Card hero_2) {
		double speedComparison = hero_1.getSpd() / hero_2.getSpd();

		if (Math.random() < ((speedComparison >= 1) ? (0.5 * speedComparison) : (0.5 / speedComparison))) {
			this.battleLog.add(hero_1.getName() + " moves first");
			move(hero_1, hero_2);

			if (hero_2.getHp() > 0) {
				this.battleLog.add("Now moves " + hero_2.getName());
				move(hero_2, hero_1);
			}
		} else {
			this.battleLog.add(hero_2.getName() + " moves first");
			move(hero_2, hero_1);

			if (hero_1.getHp() > 0) {
				this.battleLog.add("Now moves " + hero_1.getName());
				move(hero_1, hero_2);
			}
		}

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @brief
	 * @param attacker
	 * @param defender
	 */
	private void move(Card attacker, Card defender) {
		boolean physicalOrMagical;
		boolean dodgeOrBlock;
		boolean fail;

		double physicalRelation = ((double) attacker.getAtk()) / defender.getDef();
		double magicalRelation = ((double) attacker.getMag_atk()) / defender.getMag_def();
		double physicalMagicalRelation = physicalRelation / magicalRelation;
		double hero_2_tankiness;

		double type = 1;
		double ability = 1;

		if (Math.random() < ((physicalMagicalRelation >= 1) ? (0.5 * physicalMagicalRelation)
				: (0.5 / physicalMagicalRelation))) {
			physicalOrMagical = true;
		} else {
			physicalOrMagical = false;
		}

		this.battleLog
				.add(attacker.getName() + " will use a " + (physicalOrMagical ? "physical" : "magic") + " attack");

		if (defender.getAbility().getAbility_id() == 15) { // Bad Time Ability (Sans)
			dodgeOrBlock = true;
			this.battleLog.add(defender.getName() + " will try to dodge the attack");

			if (Math.random() < 0.1) { // 90% chance of dodging
				fail = false;
			} else {
				fail = true;
			}
		} else { // Everybody else: Around 12.5% chance of dodging/blocking
			hero_2_tankiness = ((defender.getHp() + ((physicalOrMagical) ? defender.getDef() : defender.getMag_def()))
					/ 2);

			if (defender.getSpd() > hero_2_tankiness) {
				dodgeOrBlock = true;
			} else if (defender.getSpd() < hero_2_tankiness) {
				dodgeOrBlock = false;
			} else {
				dodgeOrBlock = (Math.random() < 0.5) ? true : false;
			}

			this.battleLog
					.add(defender.getName() + " will try to " + (dodgeOrBlock ? "dodge" : "block") + " the attack");

			if (Math.random() < (0.125 / ((dodgeOrBlock == true) ? defender.getSpd()
					: ((physicalOrMagical) ? physicalRelation : magicalRelation)))) {
				fail = true;
			} else {
				fail = false;
			}
		}

		if (fail) {
			this.battleLog.add("The attack missed!");
		}

		if (fail == false) {
			int dmg = (int) Math
					.round(25 * ((physicalOrMagical) ? physicalRelation : magicalRelation) * type * ability);
			int newHp = defender.getHp() - dmg;
			defender.setHp((newHp > 0) ? newHp : 0);

			this.battleLog.add(attacker.getName() + " dealt " + dmg + " damage to " + defender.getName());
			this.battleLog.add(defender.getName() + " has " + defender.getHp() + " HP remaining");
		}
	}

}
