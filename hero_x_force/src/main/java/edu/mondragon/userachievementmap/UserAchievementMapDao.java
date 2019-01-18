/**
 * @file UserAchievementMapDao.java
 * @brief This class is the interface for the Dao
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

public interface UserAchievementMapDao {
	/**
	 * @brief Method to add a UserAchievementMap
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
	 * @param userAchievementMapId UserAchievementMap id int
	 * @return UserAchievementMap
	 */
	UserAchievementMap getUserAchievementMapById(int userAchievementMapId);
}