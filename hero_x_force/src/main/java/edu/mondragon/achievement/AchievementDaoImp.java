/**
 * @file AchievementDaoImp.java
 * @brief This class implements the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.achievement
 */

package edu.mondragon.achievement;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AchievementDaoImp implements AchievementDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds an achievement
	 * @param achievement Achievement object
	 * @return void
	 */
	@Override
	public void addAchievement(Achievement achievement) {
		getCurrentSession().save(achievement);
	}

	/**
	 * @brief Method to obtain the list of achievements that are in database
	 * @return List<Achievement>
	 */
	@Override
	public List<Achievement> listAchievements() {
		@SuppressWarnings("unchecked")
		TypedQuery<Achievement> query = getCurrentSession().createQuery("FROM Achievement");
		return query.getResultList();
	}
	
	/**
	 * @brief Method to find a achievement using the id
	 * @param achievementId Achievements id int
	 * @return Achievement
	 */
	@Override
	public Achievement getAchievementById(int achievementId) {
		return getCurrentSession().find(Achievement.class, achievementId);
	}
	
	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}