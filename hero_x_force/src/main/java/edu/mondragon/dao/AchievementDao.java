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
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.dao;

import java.util.List;

import edu.mondragon.model.Achievement;

public interface AchievementDao {
	void addAchievement(Achievement achievement);

	List<Achievement> listAchievements();
	
	Achievement getAchievementById(int achievement_id);
}