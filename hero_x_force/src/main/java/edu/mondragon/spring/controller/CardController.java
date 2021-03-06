/**
 * @file CardController.java
 * @brief Card controller class
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mondragon.card.Card;
import edu.mondragon.card.CardService;
import edu.mondragon.spring.configuration.ApplicationContextProvider;
import edu.mondragon.user.UserService;

@Controller
@RequestMapping("/")
public class CardController {

	/**
	 * @brief Hibernate services
	 */
	UserService userService = ApplicationContextProvider.getContext().getBean(UserService.class);
	CardService cardService = ApplicationContextProvider.getContext().getBean(CardService.class);

	/**
	 * @brief Method to redirect to heroes view
	 * @param model    Defines a holder for model attributes. Primarily designed for adding attributes to the model
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
	 * @return String
	 */
	@RequestMapping(value = { "/heroes" }, method = RequestMethod.GET)
	public String heroesPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String view = "home";
		
		if (Validators.checkIfUserIsLogged(request, model)) {
			List<Card> heroesList = cardService.listCards();
			model.addAttribute("heroesList", heroesList);
			
			view = "heroes";
		}
		
		return view;
	}

	/**
	 * @brief Method to redirect to card data view
	 * @param model    Defines a holder for model attributes. Primarily designed for adding attributes to the model
	 * @param request  Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
	 * @return String
	 */
	@RequestMapping(value = { "/card/{id}/data" }, method = RequestMethod.GET)
	public String cardDataPage(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable("id") int id) {
		String view = "home";

		if (Validators.checkIfUserIsLogged(request, model)) {
			Card card = cardService.getCardById(id);
			model.addAttribute("card", card);

			view = "card/data";
		}
		return view;
	}

	/**
	 * @brief Method to create a JSON object with the stats of the card to parse it with AJAX
	 * @param id ID of the card whose stats are wanted
	 * @return String
	 */
	@RequestMapping(value = { "/card/stats" }, method = RequestMethod.GET)
	@ResponseBody
	public String obtainHeroesJson(@RequestParam("id") String id) {
		int idAsInt = Integer.parseInt(id);

		Card card = cardService.getCardById(idAsInt);
		JSONArray ja = new JSONArray();
		JSONObject json = new JSONObject();

		json.put("area", "HP");
		json.put("value", card.getHp());

		ja.put(json);

		json = new JSONObject();
		json.put("area", "ATK");
		json.put("value", card.getAtk());

		ja.put(json);

		json = new JSONObject();
		json.put("area", "DEF");
		json.put("value", card.getDef());

		ja.put(json);

		json = new JSONObject();
		json.put("area", "Mag ATK");
		json.put("value", card.getMagAtk());

		ja.put(json);

		json = new JSONObject();
		json.put("area", "Mag DEF");
		json.put("value", card.getMagDef());

		ja.put(json);

		json = new JSONObject();
		json.put("area", "SPD");
		json.put("value", card.getSpd());

		ja.put(json);

		return "[" + ja.toString() + "]";
	}

}
