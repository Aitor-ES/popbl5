/**
 * @file UserserviceImp.java
 * @brief Class to manage the user dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.userachievementmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAchievementMapServiceImp implements UserAchievementMapService {

	/**
	 * @brief userAchievementMap dao object
	 */
	@Autowired
	private UserAchievementMapDao userAchievementMapDao;

	/**
	 * @brief Method to add userAchievementMaps to the dao
	 * @param userAchievementMap UserAchievementMap object
	 * @return void
	 */
	@Transactional
	@Override
	public void addUserAchievementMap(UserAchievementMap userAchievementMap) {
		userAchievementMapDao.addUserAchievementMap(userAchievementMap);
	}
	
	/**
	 * @brief Method to obtain the userAchievementMaps from the dao
	 * @return List<UserAchievementMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<UserAchievementMap> listUserAchievementMaps() {
		return userAchievementMapDao.listUserAchievementMaps();
	}
	
	/**
	 * @brief Method to obtain the userAchievementMap using the id from the dao
	 * @param id UserAchievementMaps id
	 * @return UserAchievementMap
	 */
	@Transactional(readOnly = true)
	@Override
	public UserAchievementMap getUserAchievementMapById(int userAchievementMap_id) {
		return userAchievementMapDao.getUserAchievementMapById(userAchievementMap_id);
	}

}