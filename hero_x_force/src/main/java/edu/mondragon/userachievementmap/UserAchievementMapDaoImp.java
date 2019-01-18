/**
 * @file UserAchievementMapDaoImp.java
 * @brief This class implements the user achievement map dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/11/2019
 * @brief Package edu.mondragon.userachievementmap
 */

package edu.mondragon.userachievementmap;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	 * @brief Method to obtain the list of userAchievementMaps that are in the database
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
	 * @param userAchievementMapId UserAchievementMap id int
	 * @return UserAchievementMap
	 */
	@Override
	public UserAchievementMap getUserAchievementMapById(int userAchievementMapId) {
		return getCurrentSession().find(UserAchievementMap.class, userAchievementMapId);
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}