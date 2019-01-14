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

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mondragon.card.Card;
import edu.mondragon.deck.Deck;
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
	
	/**
	 * @brief Method that checks if users is logged
	 * @param request Provides request information for the servlets
	 * @param model A holder for model attributes
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
	 * @param request Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/duel/list" }, method = RequestMethod.GET)
	public String duelsPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<Match> matchesAsUser_2 = userService.getMatchesAsUser_2(((User) session.getAttribute("user")).getUser_id());
			
			model.addAttribute("matchesAsUser_2", matchesAsUser_2);
			
			view = "duel/list";
		}
		return view;
	}
	
	/**
	 * @brief Method to redirect to duels battle
	 * @param model implementation of Map for use when building data model
	 * @param request Provides request information for the servlets
	 * @param id The duel id contained in the mapping link
	 * @param model A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/duel/{id}/loadBattle" }, method = RequestMethod.GET)
	public String loadBattlePage(@PathVariable("id") int id, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		String view = "home";
		
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Match match = matchService.getMatchById(id);
			
			if (match.getWinner() == null) {
				session.setAttribute("match", match);
				view = "duel/battle";
			}
		}
		return view;
	}
	
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

	public boolean startBattle(Deck deck_1, Deck deck_2) {
		Card hero_1;
		Card hero_2;
		
		int player_1_points = 0;
		int player_2_points = 0;
		
		Iterator<DeckCardMap> it_1 = deck_1.getDeckCardMaps().iterator();
		Iterator<DeckCardMap> it_2 = deck_2.getDeckCardMaps().iterator();
		
		while (it_1.hasNext() && it_2.hasNext()) {
			hero_1 = it_1.next().getCard();
			hero_2 = it_2.next().getCard();
			
			if (startRound(hero_1, hero_2)) {
				player_1_points++;
			} else {
				player_2_points++;
			}
		}
		System.out.println(player_1_points);
		System.out.println(player_2_points);
		
		return (player_1_points > player_2_points);
	}

	private boolean startRound(Card hero_1, Card hero_2) {
		boolean is_hero_1_winner;
		
		System.out.println(hero_1.getName());
		System.out.println(hero_2.getName());
		int i = 1;

		do {
			System.out.println("Turn " + i);
			
			startTurn(hero_1, hero_2);
			
			i++;
		} while (hero_1.getHp() > 0 && hero_2.getHp() > 0);

		if (hero_1.getHp() > 0) {
			is_hero_1_winner = true;
		} else {
			is_hero_1_winner = false;
		}
		return is_hero_1_winner;
	}

	private void startTurn(Card hero_1, Card hero_2) {
		double speedComparison = hero_1.getSpd() / hero_2.getSpd();
		System.out.println(speedComparison);
		
		if (Math.random() < ((speedComparison >= 1) ? (0.5 * speedComparison) : (0.5 / speedComparison))) {
			System.out.println("Hero 1 moves first");
			
			move(hero_1, hero_2);
			if (hero_2.getHp() > 0) {
				move(hero_2, hero_1);
			}
		} else {
			System.out.println("Hero 2 moves first");
			
			move(hero_2, hero_1);
			if (hero_1.getHp() > 0) {
				move(hero_1, hero_2);
			}
		}
	}

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

		if (Math.random() < ((physicalMagicalRelation >= 1) ? (0.5 * physicalMagicalRelation) : (0.5 / physicalMagicalRelation))) {
			physicalOrMagical = true;
		} else {
			physicalOrMagical = false;
		}
		
		System.out.println("physicalOrMagical: " + physicalOrMagical);
		
		if (defender.getCard_id() == 16) {	// Sans: 90% chance of dodging
			dodgeOrBlock = true;
			if (Math.random() < 0.1) {
				fail = true;
			} else {
				fail = false;
			}
		} else {	// Everybody else: Around 12.5% chance of dodging/blocking
			hero_2_tankiness = ((defender.getHp() + ((physicalOrMagical) ? defender.getDef() : defender.getMag_def())) / 2);

			if (defender.getSpd() > hero_2_tankiness) {
				dodgeOrBlock = true;
			} else if (defender.getSpd() < hero_2_tankiness) {
				dodgeOrBlock = false;
			} else {
				dodgeOrBlock = (Math.random() < 0.5) ? true : false;
			}
			
			System.out.println("dodgeOrBlock: " + dodgeOrBlock);

			if (Math.random() < (0.125 / ((dodgeOrBlock == true) ? defender.getSpd() : ((physicalOrMagical) ? physicalRelation : magicalRelation)))) {
				fail = true;
			} else {
				fail = false;
			}
		}
		
		System.out.println("fail: " + fail);

		if (fail == false) {
			int dmg = (int) Math.round(25 * ((physicalOrMagical) ? physicalRelation : magicalRelation) * type * ability);
			defender.setHp(defender.getHp() - dmg);
			
			System.out.println(attacker.getName() + " dealt " + dmg + " damage to " + defender.getName());
			System.out.println(defender.getHp());
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
