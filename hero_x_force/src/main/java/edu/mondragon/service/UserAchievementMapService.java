/**
 * @file UserService.java
 * @brief The user service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.service;

import java.util.List;

import edu.mondragon.model.UserAchievementMap;

public interface UserAchievementMapService {
	void addUserAchievementMap(UserAchievementMap userAchievementMap);

	List<UserAchievementMap> listUserAchievementMaps();

	UserAchievementMap getUserAchievementMapById(int userAchievementMap_id);
}