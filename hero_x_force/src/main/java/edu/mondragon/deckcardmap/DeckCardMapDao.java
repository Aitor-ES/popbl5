/**
 * @file DeckCardMapDao.java
 * @brief This class is the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.deckcardmap
 */

package edu.mondragon.deckcardmap;

import java.util.List;

public interface DeckCardMapDao {
	/**
	 * @brief This method adds a deck card map
	 * @param deckCardMap DeckCardMap object
	 * @return void
	 */
	void addDeckCardMap(DeckCardMap deckCardMap);
	
	/**
	 * @brief This method updates a deck card map
	 * @param deckCardMap DeckCardMap object
	 * @return void
	 */
	void updateDeckCardMap(DeckCardMap deckCardMap);

	/**
	 * @brief This method obtains the deck card map list
	 * @return List<DeckCardMap>
	 */
	List<DeckCardMap> listDeckCardMaps();

	/**
	 * @brief This method the returns the deck card map which has the indicated id
	 * @return DeckCardMap
	 */
	DeckCardMap getDeckCardMapById(int deckCardMap_id);
}