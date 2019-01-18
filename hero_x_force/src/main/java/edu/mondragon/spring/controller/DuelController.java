/**
 * @file DuelController.java
 * @brief Duel controller class
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

import edu.mondragon.achievement.Achievement;
import edu.mondragon.achievement.AchievementService;
import edu.mondragon.card.Card;
import edu.mondragon.deck.Deck;
import edu.mondragon.deck.DeckService;
import edu.mondragon.deckcardmap.DeckCardMap;
import edu.mondragon.match.Match;
import edu.mondragon.match.MatchService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.userachievementmap.UserAchievementMapService;

@Controller
@RequestMapping("/")
public class DuelController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	UserAchievementMapService userAchievementMapService = ApplicationContextProvider.getContext()
			.getBean(UserAchievementMapService.class);
	AchievementService achievementService = ApplicationContextProvider.getContext().getBean(AchievementService.class);
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
			Set<Match> matchesAsUser2 = userService
					.getMatchesAsUser2(((User) session.getAttribute("user")).getUserId());

			/*
			 * Iterator<Match> it = matchesAsUser2.iterator(); while (it.hasNext()) { Match
			 * match = it.next(); if (match.getWinner() != null) { it.remove(); } }
			 */
			model.addAttribute("matchesAsUser2", matchesAsUser2);

			Set<Deck> deckList = userService.getUserDecks(((User) session.getAttribute("user")).getUserId());
			model.addAttribute("deckList", deckList);

			view = "duel/list";
		}

		return view;
	}

	/**
	 * @brief Method to refuse and delete a duel
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model    A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/duel/{id}/delete" }, method = RequestMethod.GET)
	public String deleteDuel(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			Match match = matchService.getMatchById(id);
			matchService.removeMatch(match);

			view = "redirect:/duel/list";
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
				if (iterator.next().getUserId() == sessionUser.getUserId()) {
					iterator.remove();
				}
			}
			// Add user list to create page
			model.addAttribute("userList", userList);

			// Add deck list to create page
			Set<Deck> deckList = userService.getUserDecks(sessionUser.getUserId());
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

		Integer opponentId = Integer.valueOf(request.getParameter("opponentId"));
		Integer myDeckId = Integer.valueOf(request.getParameter("myDeckId"));

		Match match = new Match();
		// Creator
		HttpSession session = request.getSession(true);
		match.setUser1(userService.getUserById(((User) session.getAttribute("user")).getUserId()));
		match.setDeck1(deckService.getDeckById(myDeckId));

		// Opponent
		match.setUser2(userService.getUserById(opponentId));

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
	@RequestMapping(value = { "/duel/{id}/battle" }, method = RequestMethod.POST)
	public String loadBattlePage(@PathVariable("id") int id, HttpServletRequest request, Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			Match match = matchService.getMatchById(id);

			if (match.getWinner() == null) {
				HttpSession session = request.getSession(true);

				Deck deck2 = deckService.getDeckById(Integer.valueOf(request.getParameter("deck-picker-" + id)));
				match.setDeck2(deck2);

				this.battleLog = new ArrayList<>();

				if (this.startBattle(match)) {
					match.setWinner(match.getUser1());

					User user1 = userService.getUserById(match.getUser1().getUserId());
					User user2 = userService.getUserById(match.getUser2().getUserId());

					user1.setWins(user1.getWins() + 1);
					user2.setLoses(user2.getLoses() + 1);
					checkWinAchievements(user1);

					userService.updateUser(user1);
					userService.updateUser(user2);

					if (user1.getUserId() == ((User) session.getAttribute("user")).getUserId()) {
						session.setAttribute("user", user1);
					} else if (user2.getUserId() == ((User) session.getAttribute("user")).getUserId()) {
						session.setAttribute("user", user2);
					}
				} else {
					match.setWinner(match.getUser2());

					User user1 = userService.getUserById(match.getUser1().getUserId());
					User user2 = userService.getUserById(match.getUser2().getUserId());

					user1.setLoses(user1.getLoses() + 1);
					user2.setWins(user2.getWins() + 1);
					checkWinAchievements(user2);

					userService.updateUser(user1);
					userService.updateUser(user2);

					if (user1.getUserId() == ((User) session.getAttribute("user")).getUserId()) {
						session.setAttribute("user", user1);
					} else if (user2.getUserId() == ((User) session.getAttribute("user")).getUserId()) {
						session.setAttribute("user", user2);
					}
				}
				matchService.updateMatch(match);
				model.addAttribute("match", match);

				view = "duel/battle";
			}
		}
		return view;
	}

	private void checkWinAchievements(User winner) {
		Achievement achievement = null;
		switch (winner.getWins()) {
		case 5: {
			achievement = achievementService.getAchievementById(1);
			break;
		}
		case 10: {
			achievement = achievementService.getAchievementById(2);
			break;
		}
		case 20: {
			achievement = achievementService.getAchievementById(3);
			break;
		}
		case 50: {
			achievement = achievementService.getAchievementById(4);
			break;
		}
		case 100: {
			achievement = achievementService.getAchievementById(5);
			break;
		}
		case 150: {
			achievement = achievementService.getAchievementById(6);
			break;
		}
		case 200: {
			achievement = achievementService.getAchievementById(7);
			break;
		}
		default: {
			break;
		}
		}
		if (achievement != null) {
			UserAchievementMap userAchievementMap = new UserAchievementMap(winner, achievement);
			userAchievementMapService.addUserAchievementMap(userAchievementMap);
		}
	}

	/**
	 * @brief
	 * @param deck_1
	 * @param deck_2
	 * @return
	 */
	public boolean startBattle(Match match) {
		Deck deck1 = match.getDeck1();
		Deck deck2 = match.getDeck2();

		Card hero1;
		Card hero2;

		int player1Points = 0;
		int player2Points = 0;

		Iterator<DeckCardMap> it1 = deck1.getDeckCardMaps().iterator();
		Iterator<DeckCardMap> it2 = deck2.getDeckCardMaps().iterator();

		int i = 1;

		while (it1.hasNext() && it2.hasNext()) {
			this.battleLog.add("ROUND " + i);

			hero1 = it1.next().getCard();
			hero2 = it2.next().getCard();

			if (startRound(hero1, hero2)) {
				player1Points++;
				this.battleLog.add("PLAYER 1 WON ROUND " + i);
			} else {
				player2Points++;
				this.battleLog.add("PLAYER 2 WON ROUND " + i);
			}
			i++;
		}
		this.battleLog.add("ROUNDS WON BY PLAYER 1: " + player1Points);
		this.battleLog.add("ROUNDS WON BY PLAYER 2: " + player2Points);
		this.battleLog.add("PLAYER " + ((player1Points > player2Points) ? "1" : "2") + " WINS!");

		return (player1Points > player2Points);
	}

	/**
	 * @brief
	 * @param hero_1
	 * @param hero_2
	 * @return
	 */
	private boolean startRound(Card hero1, Card hero2) {
		boolean isHero1Winner;

		this.battleLog.add("Hero 1: " + hero1.getName());
		this.battleLog.add("Hero 2: " + hero2.getName());
		int i = 1;

		do {
			this.battleLog.add("TURN " + i);

			startTurn(hero1, hero2);

			i++;
		} while (hero1.getHp() > 0 && hero2.getHp() > 0);

		if (hero1.getHp() > 0) {
			isHero1Winner = true;
		} else {
			isHero1Winner = false;
		}

		return isHero1Winner;
	}

	/**
	 * @brief
	 * @param hero1
	 * @param hero2
	 */
	private void startTurn(Card hero1, Card hero2) {
		double speedComparison = hero1.getSpd() / hero2.getSpd();

		if (Math.random() < ((speedComparison >= 1) ? (0.5 * speedComparison) : (0.5 / speedComparison))) {
			this.battleLog.add(hero1.getName() + " moves first");
			move(hero1, hero2);

			if (hero2.getHp() > 0) {
				this.battleLog.add("Now moves " + hero2.getName());
				move(hero2, hero1);
			}
		} else {
			this.battleLog.add(hero2.getName() + " moves first");
			move(hero2, hero1);

			if (hero1.getHp() > 0) {
				this.battleLog.add("Now moves " + hero1.getName());
				move(hero1, hero2);
			}
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
		double magicalRelation = ((double) attacker.getMagAtk()) / defender.getMagDef();
		double physicalMagicalRelation = physicalRelation / magicalRelation;
		double hero2tankiness;

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

		if (defender.getAbility().getAbilityId() == 15) { // Bad Time Ability (Sans)
			this.battleLog.add(defender.getName() + " will try to dodge the attack");

			if (Math.random() < 0.1) { // 90% chance of dodging
				fail = false;
			} else {
				fail = true;
			}
		} else { // Everybody else: Around 12.5% chance of dodging/blocking
			hero2tankiness = ((defender.getHp() + ((physicalOrMagical) ? defender.getDef() : defender.getMagDef()))
					/ 2);

			if (defender.getSpd() > hero2tankiness) {
				dodgeOrBlock = true;
			} else if (defender.getSpd() < hero2tankiness) {
				dodgeOrBlock = false;
			} else {
				dodgeOrBlock = (Math.random() < 0.5) ? true : false;
			}

			this.battleLog
					.add(defender.getName() + " will try to " + (dodgeOrBlock ? "dodge" : "block") + " the attack");

			if (Math.random() < (0.125 / ((dodgeOrBlock) ? defender.getSpd()
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

}
