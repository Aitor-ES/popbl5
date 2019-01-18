/**
 * @file DeckDaoImp.java
 * @brief This class implements the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.deck
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
	
	/**
	 * @brief This method updates a deck
	 * @param deck Deck object
	 * @return void
	 */
	@Override
	public void updateDeck(Deck deck) {
		getCurrentSession().update(deck);
	}

	/**
	 * @bried This method removes a deck
	 * @param deck Deck object
	 * @return void
	 */
	@Override
	public void removeDeck(Deck deck) {
		getCurrentSession().remove(deck);
	}

	/**
	 * @brief Method to obtain the list of decks that are in the database
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
	 * @param deckId Decks id int
	 * @return Deck
	 */
	@Override
	public Deck getDeckById(int deckId) {
		return getCurrentSession().find(Deck.class, deckId);
	}
	
	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}