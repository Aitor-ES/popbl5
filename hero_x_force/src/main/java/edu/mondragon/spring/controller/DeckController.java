package edu.mondragon.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.card.Card;
import edu.mondragon.deck.Deck;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;
import edu.mondragon.usercardmap.UserCardMap;

@Controller
@RequestMapping("/")
public class DeckController {
	/**
	 * @brief The user service
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);

	/**
	 * @brief Method to redirect to decks view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/deck/list" }, method = RequestMethod.GET)
	public String decksPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<Deck> deckList = userService.getUserDecks(((User) session.getAttribute("user")).getUser_id());
			model.addAttribute("deckList", deckList);
			
			view = "deck/list";
		}
		return view;
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/deck/form" }, method = RequestMethod.GET)
	public String deckFormPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<UserCardMap> cardMapList = userService.getUserCards(((User) session.getAttribute("user")).getUser_id());
			
			List<Card> cardList = new ArrayList<>();
			for (UserCardMap userCardMap : cardMapList) {
				cardList.add(userCardMap.getCard());
			}
			model.addAttribute("cardList", cardList);
			
			view = "deck/form";
		}
		return view;
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param model implementation of Map for use when building data model
	 * @return String
	 */
	@RequestMapping(value = { "/deck/data" }, method = RequestMethod.GET)
	public String deckDataPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return checkIfUserIsLogged(request, model) ? "deck/data" : "home";
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
