/**
 * @file UserTournamentMapDaoImp.java
 * @brief This class implements the user tournament map dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.usertournamentmap
 */

package edu.mondragon.usertournamentmap;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserTournamentMapDaoImp implements UserTournamentMapDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a userTournamentMap
	 * @param userTournamentMap UserTournamentMap object
	 * @return void
	 */
	@Override
	public void addUserTournamentMap(UserTournamentMap userTournamentMap) {
		getCurrentSession().save(userTournamentMap);
	}

	/**
	 * @brief Method to obtain the list of userTournamentMaps that are in the database
	 * @return List<UserTournamentMap>
	 */
	@Override
	public List<UserTournamentMap> listUserTournamentMaps() {
		@SuppressWarnings("unchecked")
		TypedQuery<UserTournamentMap> query = getCurrentSession().createQuery("FROM UserTournamentMap");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a userTournamentMap using the id
	 * @param userTournamentMapId UserTournamentMaps id int
	 * @return UserTournamentMap
	 */
	@Override
	public UserTournamentMap getUserTournamentMapById(int userTournamentMapId) {
		return getCurrentSession().find(UserTournamentMap.class, userTournamentMapId);
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}