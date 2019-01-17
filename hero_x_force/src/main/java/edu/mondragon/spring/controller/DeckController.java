/**
 * @file DeckController.java
 * @brief Deck controller class
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
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mondragon.card.Card;
import edu.mondragon.card.CardService;
import edu.mondragon.deck.Deck;
import edu.mondragon.deck.DeckService;
import edu.mondragon.deckcardmap.DeckCardMap;
import edu.mondragon.deckcardmap.DeckCardMapService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class DeckController {
	/**
	 * @brief Model services
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	DeckService deckService = ApplicationContextProvider.getContext().getBean(DeckService.class);
	CardService cardService = ApplicationContextProvider.getContext().getBean(CardService.class);
	DeckCardMapService deckCardMapService = ApplicationContextProvider.getContext().getBean(DeckCardMapService.class);

	/**
	 * @brief Method to redirect to decks view
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model    A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/deck/list" }, method = RequestMethod.GET)
	public String decksPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			Set<Deck> deckList = userService.getUserDecks(((User) session.getAttribute("user")).getUserId());
			model.addAttribute("deckList", deckList);

			view = "deck/list";
		}
		return view;
	}

	/**
	 * @brief Method to redirect to deck-form view
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param model    A holder for model attributes
	 * @return String
	 */
	@RequestMapping(value = { "/deck/form" }, method = RequestMethod.GET)
	public String deckFormPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			/**
			 * @brief TODO: future lines
			 *        HttpSession session = request.getSession(true);
			 *        Set<UserCardMap> cardMapList = userService.getUserCards(((User) session.getAttribute("user")).getUser_id());
			 * 
			 *        List<Card> cardList = new ArrayList<>();
			 *        for (UserCardMap userCardMap : cardMapList) {
			 *            cardList.add(userCardMap.getCard());
			 *        }
			 */
			List<Card> cardList = cardService.listCards();
			model.addAttribute("cardList", cardList);

			view = "deck/form";
		}
		return view;
	}

	/**
	 * @brief Method to redirect to deck-form view using id parameter
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param id       To know which deck we are editing
	 * @return String
	 */
	@RequestMapping(value = { "/deck/{id}/form" }, method = RequestMethod.GET)
	public String deckIdFormPage(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		if (checkIfUserIsLogged(request, model)) {
			Deck deck = deckService.getDeckById(id);
			model.addAttribute("deck", deck);
			
			List<Card> cardList = cardService.listCards();
			model.addAttribute("cardList", cardList);

			view = "deck/form";
		}
		return view;
	}

	@RequestMapping(value = { "/deck/form/save" }, method = RequestMethod.POST)
	public String deckSave(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		
		if (checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);
			
			String deckIdAsString = request.getParameter("deck_id");
			
			if (deckIdAsString == null) {
				String deckName = request.getParameter("deckName");
				Deck deck = new Deck(deckName, (User) session.getAttribute("user"));
				deckService.addDeck(deck);
				
				String cardId1 = request.getParameter("selected-card-id-1").split("#")[1];
				String cardId2 = request.getParameter("selected-card-id-2").split("#")[1];
				String cardId3 = request.getParameter("selected-card-id-3").split("#")[1];
				String cardId4 = request.getParameter("selected-card-id-4").split("#")[1];
				String cardId5 = request.getParameter("selected-card-id-5").split("#")[1];
				
				DeckCardMap deckCardMap1 = new DeckCardMap(1, deck, cardService.getCardById(Integer.parseInt(cardId1)));
				DeckCardMap deckCardMap2 = new DeckCardMap(2, deck, cardService.getCardById(Integer.parseInt(cardId2)));
				DeckCardMap deckCardMap3 = new DeckCardMap(3, deck, cardService.getCardById(Integer.parseInt(cardId3)));
				DeckCardMap deckCardMap4 = new DeckCardMap(4, deck, cardService.getCardById(Integer.parseInt(cardId4)));
				DeckCardMap deckCardMap5 = new DeckCardMap(5, deck, cardService.getCardById(Integer.parseInt(cardId5)));
				
				deckCardMapService.addDeckCardMap(deckCardMap1);
				deckCardMapService.addDeckCardMap(deckCardMap2);
				deckCardMapService.addDeckCardMap(deckCardMap3);
				deckCardMapService.addDeckCardMap(deckCardMap4);
				deckCardMapService.addDeckCardMap(deckCardMap5);
			} else {
				int deckId = Integer.parseInt(deckIdAsString);
				
				Deck deck = deckService.getDeckById(deckId);
				deck.setName(request.getParameter("deckName"));
				deckService.updateDeck(deck);
				
				List<DeckCardMap> listAllMaps = deckCardMapService.listDeckCardMaps();
				List<DeckCardMap> listOurMaps = new ArrayList<>();
				
				for (DeckCardMap map : listAllMaps) {
					if (map.getDeck().getDeckId() == deckId) {
						listOurMaps.add(map);
					}
				}
				
				String cardId1 = request.getParameter("selected-card-id-1").split("#")[1];
				String cardId2 = request.getParameter("selected-card-id-2").split("#")[1];
				String cardId3 = request.getParameter("selected-card-id-3").split("#")[1];
				String cardId4 = request.getParameter("selected-card-id-4").split("#")[1];
				String cardId5 = request.getParameter("selected-card-id-5").split("#")[1];
				
				for (DeckCardMap map : listOurMaps) {
					if (map.getPosition() == 1) {
						map.setCard(cardService.getCardById(Integer.parseInt(cardId1)));
						deckCardMapService.updateDeckCardMap(map);
					}
					if (map.getPosition() == 2) {
						map.setCard(cardService.getCardById(Integer.parseInt(cardId2)));
						deckCardMapService.updateDeckCardMap(map);
					}
					if (map.getPosition() == 3) {
						map.setCard(cardService.getCardById(Integer.parseInt(cardId3)));
						deckCardMapService.updateDeckCardMap(map);
					}
					if (map.getPosition() == 4) {
						map.setCard(cardService.getCardById(Integer.parseInt(cardId4)));
						deckCardMapService.updateDeckCardMap(map);
					}
					if (map.getPosition() == 5) {
						map.setCard(cardService.getCardById(Integer.parseInt(cardId5)));
						deckCardMapService.updateDeckCardMap(map);
					}
				}
			}

			view = "redirect:/deck/list";
		}
		return view;
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
