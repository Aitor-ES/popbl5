/**
 * @file CardServiceImp.java
 * @brief Class to manage the card dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImp implements CardService {

	/**
	 * @brief Card dao object
	 */
	@Autowired
	private CardDao cardDao;

	/**
	 * @brief Method to add cards to the dao
	 * @param card Card object
	 * @return void
	 */
	@Transactional
	@Override
	public void addCard(Card card) {
		cardDao.addCard(card);
	}
	
	/**
	 * @brief Method to obtain the card using the id from the dao
	 * @param id Card id
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public Card getCardById(int card_id) {
		return cardDao.getCardById(card_id);
	}
	
	/**
	 * @brief Method to obtain the cards from the dao
	 * @return List<Card>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Card> listCards() {
		return cardDao.listCards();
	}

	/**
	 * @brief Method to return the number of heroes
	 * @return int number of heroes
	 */
	@Override
	public int getHeroNumber() {
		return cardDao.getHeroNumber();
	}

}