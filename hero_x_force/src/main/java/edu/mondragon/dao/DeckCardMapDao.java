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
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.dao;

import java.util.List;

import edu.mondragon.model.DeckCardMap;

public interface DeckCardMapDao {
	void addDeckCardMap(DeckCardMap deckCardMap);

	List<DeckCardMap> listDeckCardMaps();

	DeckCardMap getDeckCardMapById(int deckCardMap_id);
}