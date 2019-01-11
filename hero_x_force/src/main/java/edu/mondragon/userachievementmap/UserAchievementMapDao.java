/**
 * @file UserAchievementMapDao.java
 * @brief This class is the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.userachievementmap;

import java.util.List;

public interface UserAchievementMapDao {
	void addUserAchievementMap(UserAchievementMap userAchievementMap);

	List<UserAchievementMap> listUserAchievementMaps();

	UserAchievementMap getUserAchievementMapById(int userAchievementMap_id);
}