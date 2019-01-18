/**
 * @file CardService.java
 * @brief The card service interface class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.card
 */

package edu.mondragon.card;

import java.util.List;

public interface CardService {
	/**
	 * @brief This method adds a card
	 * @param card Card object
	 * @return void
	 */
	void addCard(Card card);

	/**
	 * @brief This method obtains the card list
	 * @return List<Card>
	 */
	List<Card> listCards();

	/**
	 * @brief This method obtains the card which has the indicated id
	 * @param cardId Card id int
	 * @return Card
	 */
	Card getCardById(int cardId);
	
	/**
	 * @brief This method returns the number of heroes in the game
	 * @return int
	 */
	int getHeroNumber();
}