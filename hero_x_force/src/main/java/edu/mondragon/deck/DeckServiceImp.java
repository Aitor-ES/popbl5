/**
 * @file DeckServiceImp.java
 * @brief Class to manage the user dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.deck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeckServiceImp implements DeckService {

	/**
	 * @brief Deck dao object
	 */
	@Autowired
	private DeckDao deckDao;

	/**
	 * @brief Method to add decks to the dao
	 * @param deck Deck object
	 * @return void
	 */
	@Transactional
	@Override
	public void addDeck(Deck deck) {
		deckDao.addDeck(deck);
	}
	
	/**
	 * @brief Method to obtain the deck using the id from the dao
	 * @param id Deck id
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public Deck getDeckById(int deck_id) {
		return deckDao.getDeckById(deck_id);
	}
	
	/**
	 * @brief Method to obtain the decks from the dao
	 * @return List<Deck>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Deck> listDecks() {
		return deckDao.listDecks();
	}

}