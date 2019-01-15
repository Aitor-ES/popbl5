/**
 * @file DeckDaoImp.java
 * @brief This class manages the database
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.deck;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeckDaoImp implements DeckDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a deck
	 * @param deck Deck object
	 * @return void
	 */
	@Override
	public void addDeck(Deck deck) {
		getCurrentSession().save(deck);
	}

	@Override
	public void updateDeck(Deck deck) {
		getCurrentSession().update(deck);
	}

	/**
	 * @brief Method to obtain the list of decks that are in database
	 * @return List<Deck>
	 */
	@Override
	public List<Deck> listDecks() {
		@SuppressWarnings("unchecked")
		TypedQuery<Deck> query = getCurrentSession().createQuery("FROM Deck");
		return query.getResultList();
	}
	
	/**
	 * @brief Method to find a deck using the id
	 * @param id Decks id
	 * @return Deck
	 */
	@Override
	public Deck getDeckById(int deck_id) {
		Deck deck = getCurrentSession().find(Deck.class, deck_id);
		return deck;
	}
	
	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}