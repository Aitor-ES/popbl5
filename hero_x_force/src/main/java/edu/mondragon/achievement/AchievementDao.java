/**
 * @file AchievementDao.java
 * @brief This class is the interface for the Dao
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

public interface AchievementDao {
	/**
	 * @brief This method adds an achievement
	 * @param achievement Achievement object
	 * @return void
	 */
	void addAchievement(Achievement achievement);

	/**
	 * @brief This method obtains the achievement list
	 * @return List<Achievement>
	 */
	List<Achievement> listAchievements();
	
	/**
	 * @brief Method to get an achievement by its id
	 * @param achievementId Achievement id int
	 * @return Achievement
	 */
	Achievement getAchievementById(int achievementId);
}