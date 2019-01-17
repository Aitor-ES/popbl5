/**
 * @file UserAchievementMapService.java
 * @brief The UserAchievementMapService service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.userachievementmap
 */

package edu.mondragon.userachievementmap;

import java.util.List;

public interface UserAchievementMapService {
	/**
	 * @brief Method to add an UserAchievementMap
	 * @param userAchievementMap UserAchievementMap object
	 * @return void
	 */
	void addUserAchievementMap(UserAchievementMap userAchievementMap);

	/**
	 * @brief Method to obtain the UserAchievementMap list
	 * @return List<UserAchievementMap>
	 */
	List<UserAchievementMap> listUserAchievementMaps();

	/**
	 * @brief This method gets an UserAchievementMap
	 * @param userAchievementMap_id UserAchievementMap object id int
	 * @return UserAchievementMap
	 */
	UserAchievementMap getUserAchievementMapById(int userAchievementMap_id);
}