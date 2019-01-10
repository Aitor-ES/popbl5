/**
 * @file AchievementService.java
 * @brief The achievement service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.service;

import java.util.List;

import edu.mondragon.model.Achievement;

public interface AchievementService {
	void addAchievement(Achievement achievement);

	List<Achievement> listAchievements();
	
	Achievement getAchievementById(int achievement_id);
}