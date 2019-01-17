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
 * @brief Package edu.mondragon.match
 */

package edu.mondragon.match;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	 * @brief This method updates a match
	 * @param match Match object
	 * @return void
	 */
	@Override
	public void updateMatch(Match match) {
		getCurrentSession().update(match);
	}

	/**
	 * @brief Method to obtain the list of matchs that are in database
	 * @return List<Match>
	 */
	@Override
	public List<Match> listMatches() {
		@SuppressWarnings("unchecked")
		TypedQuery<Match> query = getCurrentSession().createQuery("FROM Match");
		return query.getResultList();
	}
	
	/**
	 * @brief Method to find a match using the id
	 * @param matchId Matchs id int
	 * @return Match
	 */
	@Override
	public Match getMatchById(int matchId) {
		Match match = getCurrentSession().find(Match.class, matchId);
		return match;
	}
	
	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	/**
	 * @brief Method to remove a match
	 * @return void
	 */
	@Override
	public void removeMatch(Match match) {
		getCurrentSession().remove(match);
	}

}