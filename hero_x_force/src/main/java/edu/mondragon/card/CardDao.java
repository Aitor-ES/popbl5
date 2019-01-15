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
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.card;

import java.util.List;

public interface CardDao {
	void addCard(Card card);

	List<Card> listCards();
	
	Card getCardById(int card_id);
	
	int getHeroNumber();
}