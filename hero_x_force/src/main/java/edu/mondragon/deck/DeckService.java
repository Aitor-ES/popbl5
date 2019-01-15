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
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.deck;

import java.util.List;

public interface DeckService {
	void addDeck(Deck deck);
	
	void updateDeck(Deck deck);

	List<Deck> listDecks();

	Deck getDeckById(int deck_id);
}