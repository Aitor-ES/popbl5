/**
 * @file DeckCardMapserviceImp.java
 * @brief Class to implement the deckcardmap service and manage the DeckCardMap dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.deckcardmap
 */

package edu.mondragon.deckcardmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeckCardMapServiceImp implements DeckCardMapService {

	/**
	 * @brief deckCardMap dao object
	 */
	@Autowired
	private DeckCardMapDao deckCardMapDao;

	/**
	 * @brief Method to add a deck card map to the dao
	 * @param deckCardMap DeckCardMap object
	 * @return void
	 */
	@Transactional
	@Override
	public void addDeckCardMap(DeckCardMap deckCardMap) {
		deckCardMapDao.addDeckCardMap(deckCardMap);
	}

	/**
	 * @brief This method updates a deck card map
	 * @param deckCardMap DeckCardMap object
	 * @return void
	 */
	@Transactional
	@Override
	public void updateDeckCardMap(DeckCardMap deckCardMap) {
		deckCardMapDao.updateDeckCardMap(deckCardMap);
	}
	
	/**
	 * @brief Method to obtain the deck card maps from the dao
	 * @return List<DeckCardMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<DeckCardMap> listDeckCardMaps() {
		return deckCardMapDao.listDeckCardMaps();
	}
	
	/**
	 * @brief Method to obtain the deck card map using the id from the dao
	 * @param deckCardMapId DeckCardMaps id int
	 * @return DeckCardMap
	 */
	@Transactional(readOnly = true)
	@Override
	public DeckCardMap getDeckCardMapById(int deckCardMapId) {
		return deckCardMapDao.getDeckCardMapById(deckCardMapId);
	}

}