/**
 * @file DeckService.java
 * @brief The deck service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.deck
 */

package edu.mondragon.deck;

import java.util.List;

public interface DeckService {
	/**
	 * @brief This method adds a deck
	 * @param deck Deck object
	 * @return void
	 */
	void addDeck(Deck deck);
	
	/**
	 * @brief This method update the deck data
	 * @param deck Deck object
	 * @return void
	 */
	void updateDeck(Deck deck);

	/**
	 * @bried This method removes a deck
	 * @param deck
	 * @return void
	 */
	void removeDeck(Deck deck);

	/**
	 * @brief This method obtains the deck list
	 * @return List<Deck>
	 */
	List<Deck> listDecks();

	/**
	 * @brief This method returns the deck number
	 * @param deckId Deck id int
	 * @return Deck
	 */
	Deck getDeckById(int deckId);
}