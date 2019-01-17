/**
 * @file UserDaoImp.java
 * @brief This class manages the database
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.tournament;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TournamentDaoImp implements TournamentDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a tournament
	 * @param tournament Tournament object
	 * @return void
	 */
	@Override
	public void addTournament(Tournament tournament) {
		getCurrentSession().save(tournament);
	}

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<User>
	 */
	@Override
	public List<Tournament> listTournaments() {
		@SuppressWarnings("unchecked")
		TypedQuery<Tournament> query = getCurrentSession().createQuery("FROM Tournament");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a tournament using the id
	 * @param tournamentId Tournament id int
	 * @return User
	 */
	@Override
	public Tournament getTournamentById(int tournamentId) {
		Tournament tournament = getCurrentSession().find(Tournament.class, tournamentId);
		return tournament;
	}
	
	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}