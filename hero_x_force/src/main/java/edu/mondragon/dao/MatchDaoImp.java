/**
 * @file MatchDaoImp.java
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

import edu.mondragon.model.Match;

@Repository
public class MatchDaoImp implements MatchDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a match
	 * @param match Match object
	 * @return void
	 */
	@Override
	public void addMatch(Match match) {
		getCurrentSession().save(match);
	}

	/**
	 * @brief Method to obtain the list of matchs that are in database
	 * @return List<Match>
	 */
	@Override
	public List<Match> listMatchs() {
		@SuppressWarnings("unchecked")
		TypedQuery<Match> query = getCurrentSession().createQuery("FROM Match");
		return query.getResultList();
	}
	
	/**
	 * @brief Method to find a match using the id
	 * @param id Matchs id
	 * @return Match
	 */
	@Override
	public Match getMatchById(int match_id) {
		Match match = getCurrentSession().find(Match.class, match_id);
		return match;
	}
	
	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}