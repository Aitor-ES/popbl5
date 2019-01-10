/**
 * @file CardDaoImp.java
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

package edu.mondragon.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mondragon.model.Card;

@Repository
public class CardDaoImp implements CardDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a card
	 * @param card Card object
	 * @return void
	 */
	@Override
	public void addCard(Card card) {
		getCurrentSession().save(card);
	}

	/**
	 * @brief Method to obtain the list of cards that are in database
	 * @return List<Card>
	 */
	@Override
	public List<Card> listCards() {
		@SuppressWarnings("unchecked")
		TypedQuery<Card> query = getCurrentSession().createQuery("FROM Card");
		return query.getResultList();
	}
	
	/**
	 * @brief Method to find a card using the id
	 * @param id Cards id
	 * @return Card
	 */
	@Override
	public Card getCardById(int card_id) {
		Card card = getCurrentSession().find(Card.class, card_id);
		return card;
	}
	
	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}