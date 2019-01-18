/**
 * @file UserserviceImp.java
 * @brief Class to implement the user achievement map service and manage the user achievement map dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAchievementMapServiceImp implements UserAchievementMapService {

	/**
	 * @brief DAO objects
	 */
	@Autowired
	private UserAchievementMapDao userAchievementMapDao;

	/**
	 * @brief Method to add a userAchievementMap to the dao
	 * @param userAchievementMap UserAchievementMap object
	 * @return void
	 */
	@Transactional
	@Override
	public void addUserAchievementMap(UserAchievementMap userAchievementMap) {
		userAchievementMapDao.addUserAchievementMap(userAchievementMap);
	}
	
	/**
	 * @brief Method to obtain the userAchievementMap list from the dao
	 * @return List<UserAchievementMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<UserAchievementMap> listUserAchievementMaps() {
		return userAchievementMapDao.listUserAchievementMaps();
	}
	
	/**
	 * @brief Method to obtain the userAchievementMap using the id from the dao
	 * @param userAchievementMapId UserAchievementMap id int
	 * @return UserAchievementMap
	 */
	@Transactional(readOnly = true)
	@Override
	public UserAchievementMap getUserAchievementMapById(int userAchievementMapId) {
		return userAchievementMapDao.getUserAchievementMapById(userAchievementMapId);
	}

}