/**
 * @file UserAchievementMapDaoImp.java
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

package edu.mondragon.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mondragon.model.UserAchievementMap;

@Repository
public class UserAchievementMapDaoImp implements UserAchievementMapDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds a userAchievementMap
	 * @param userAchievementMap UserAchievementMap object
	 * @return void
	 */
	@Override
	public void addUserAchievementMap(UserAchievementMap userAchievementMap) {
		getCurrentSession().save(userAchievementMap);
	}

	/**
	 * @brief Method to obtain the list of userAchievementMaps that are in database
	 * @return List<UserAchievementMap>
	 */
	@Override
	public List<UserAchievementMap> listUserAchievementMaps() {
		@SuppressWarnings("unchecked")
		TypedQuery<UserAchievementMap> query = getCurrentSession().createQuery("FROM UserAchievementMap");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a userAchievementMap using the id
	 * @param id UserAchievementMaps id
	 * @return UserAchievementMap
	 */
	@Override
	public UserAchievementMap getUserAchievementMapById(int userAchievementMap_id) {
		UserAchievementMap userAchievementMap = getCurrentSession().find(UserAchievementMap.class, userAchievementMap_id);
		return userAchievementMap;
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}