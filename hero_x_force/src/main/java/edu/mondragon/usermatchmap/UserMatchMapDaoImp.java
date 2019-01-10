/**
 * @file UserMatchMapDaoImp.java
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

package edu.mondragon.usermatchmap;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserMatchMapDaoImp implements UserMatchMapDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a userMatchMap
	 * @param userMatchMap UserMatchMap object
	 * @return void
	 */
	@Override
	public void addUserMatchMap(UserMatchMap userMatchMap) {
		getCurrentSession().save(userMatchMap);
	}

	/**
	 * @brief Method to obtain the list of userMatchMaps that are in database
	 * @return List<UserMatchMap>
	 */
	@Override
	public List<UserMatchMap> listUserMatchMaps() {
		@SuppressWarnings("unchecked")
		TypedQuery<UserMatchMap> query = getCurrentSession().createQuery("FROM UserMatchMap");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a userMatchMap using the id
	 * @param id UserMatchMaps id
	 * @return UserMatchMap
	 */
	@Override
	public UserMatchMap getUserMatchMapById(int userMatchMap_id) {
		UserMatchMap userMatchMap = getCurrentSession().find(UserMatchMap.class, userMatchMap_id);
		return userMatchMap;
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}