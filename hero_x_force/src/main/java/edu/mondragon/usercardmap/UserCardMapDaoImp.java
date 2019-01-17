/**
 * @file UserCardMapDaoImp.java
 * @brief This class manages the database
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.usercardmap
 */

package edu.mondragon.usercardmap;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserCardMapDaoImp implements UserCardMapDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a userCardMap
	 * @param userCardMap UserCardMap object
	 * @return void
	 */
	@Override
	public void addUserCardMap(UserCardMap userCardMap) {
		getCurrentSession().save(userCardMap);
	}

	/**
	 * @brief Method to obtain the list of userCardMaps that are in database
	 * @return List<UserCardMap>
	 */
	@Override
	public List<UserCardMap> listUserCardMaps() {
		@SuppressWarnings("unchecked")
		TypedQuery<UserCardMap> query = getCurrentSession().createQuery("FROM UserCardMap");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a userCardMap using the id
	 * @param id UserCardMaps id
	 * @return UserCardMap
	 */
	@Override
	public UserCardMap getUserCardMapById(int userCardMap_id) {
		UserCardMap userCardMap = getCurrentSession().find(UserCardMap.class, userCardMap_id);
		return userCardMap;
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}