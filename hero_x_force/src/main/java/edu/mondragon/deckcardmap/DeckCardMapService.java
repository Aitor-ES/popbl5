/**
 * @file DeckCardMapService.java
 * @brief The deckCard service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.deckcardmap;

import java.util.List;

public interface DeckCardMapService {
	void addDeckCardMap(DeckCardMap deckCardMap);
	
	void updateDeckCardMap(DeckCardMap deckCardMap);

	List<DeckCardMap> listDeckCardMaps();

	DeckCardMap getDeckCardMapById(int deckCardMap_id);
}