/**
 * @file CardDao.java
 * @brief This class is the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.card
 */

package edu.mondragon.card;

import java.util.List;

public interface CardDao {
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
	 * @param id Id card int
	 * @return Achievement
	 */
	Card getCardById(int card_id);
	
	/**
	 * @brief This method returns the hero number
	 * @return int
	 */
	int getHeroNumber();
}