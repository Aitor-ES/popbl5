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

		if (Validators.checkIfUserIsLogged(request, model)) {
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

		if (Validators.checkIfUserIsLogged(request, model)) {
			/**
			 * @brief TODO: future lines HttpSession session = request.getSession(true);
			 *        Set<UserCardMap> cardMapList = userService.getUserCards(((User)
			 *        session.getAttribute("user")).getUser_id());
			 * 
			 *        List<Card> cardList = new ArrayList<>(); for (UserCardMap userCardMap
			 *        : cardMapList) { cardList.add(userCardMap.getCard()); }
			 */
			List<Card> cardList = cardService.listCards();
			model.addAttribute("cardList", cardList);
			
			model.addAttribute("action", "create");
			
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
	public String deckIdFormPage(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String view = "home";

		if (Validators.checkIfUserIsLogged(request, model)) {
			Deck deck = deckService.getDeckById(id);
			model.addAttribute("deck", deck);

			List<Card> cardList = cardService.listCards();
			model.addAttribute("cardList", cardList);
			
			model.addAttribute("action", "edit");

			view = "deck/form";
		}
		return view;
	}

	/**
	 * @brief Method to save deck from deck form
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @return String
	 */
	@RequestMapping(value = { "/deck/form/save" }, method = RequestMethod.POST)
	public String deckSave(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		if (Validators.checkIfUserIsLogged(request, model)) {
			HttpSession session = request.getSession(true);

			String deckIdAsString = request.getParameter("deckId");

			if (deckIdAsString == null) {
				String deckName = request.getParameter("deckName");
				Deck deck = new Deck(deckName, (User) session.getAttribute("user"));
				deckService.addDeck(deck);

				for (int i = 1; i <= 5; i++) {
					String cardId = request.getParameter("selected-card-id-" + i).split("#")[1];
					DeckCardMap deckCardMap = new DeckCardMap(i, deck,
							cardService.getCardById(Integer.parseInt(cardId)));
					deckCardMapService.addDeckCardMap(deckCardMap);
				}
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

				for (int i = 0; i < 5; i++) {
					if (listOurMaps.get(i).getPosition() == (i + 1)) {
						String cardId = request.getParameter("selected-card-id-" + (i + 1)).split("#")[1];
						listOurMaps.get(i).setCard(cardService.getCardById(Integer.parseInt(cardId)));
						deckCardMapService.updateDeckCardMap(listOurMaps.get(i));
					}

				}
			}

			view = "redirect:/deck/list";
		}
		return view;
	}

	/**
	 * @brief Method to delete deck
	 * @param model    implementation of Map for use when building data model
	 * @param request  Provides request information for the servlets
	 * @param response To assist the servlet in sending a response
	 * @param id       To know which deck we are deleting
	 * @return String
	 */
	@RequestMapping(value = { "/deck/delete" }, method = RequestMethod.POST)
	public String deleteDeck(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";

		if (Validators.checkIfUserIsLogged(request, model)) {
			Integer deckId = Integer.valueOf(request.getParameter("deleteId"));
			Deck deck = deckService.getDeckById(deckId);
			deckService.removeDeck(deck);

			view = "redirect:/deck/list";
		}
		return view;
	}

}
