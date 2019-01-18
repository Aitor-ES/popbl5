/**
 * @file DeckCardMapDaoImp.java
 * @brief This class manages the database
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

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeckCardMapDaoImp implements DeckCardMapDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a deckCardMap
	 * @param deckCardMap DeckCardMap object
	 * @return void
	 */
	@Override
	public void addDeckCardMap(DeckCardMap deckCardMap) {
		getCurrentSession().save(deckCardMap);
	}

	/**
	 * @brief This method updates a deckCardMap
	 * @param deckCardMap DeckCardMap object
	 * @return void
	 */
	@Override
	public void updateDeckCardMap(DeckCardMap deckCardMap) {
		getCurrentSession().update(deckCardMap);
	}

	/**
	 * @brief Method to obtain the list of deckCardMaps that are in database
	 * @return List<DeckCardMap>
	 */
	@Override
	public List<DeckCardMap> listDeckCardMaps() {
		@SuppressWarnings("unchecked")
		TypedQuery<DeckCardMap> query = getCurrentSession().createQuery("FROM DeckCardMap");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a deckCardMap using the id
	 * @param deckCardMapId DeckCardMaps id int
	 * @return DeckCardMap
	 */
	@Override
	public DeckCardMap getDeckCardMapById(int deckCardMapId) {
		return getCurrentSession().find(DeckCardMap.class, deckCardMapId);
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}