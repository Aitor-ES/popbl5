/**
 * @file AchievementServiceImp.java
 * @brief Class to manage the achievement dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AchievementServiceImp implements AchievementService {

	/**
	 * @brief Achievement dao object
	 */
	@Autowired
	private AchievementDao achievementDao;

	/**
	 * @brief Method to add achievements to the dao
	 * @param achievement Achievement object
	 * @return void
	 */
	@Transactional
	@Override
	public void addAchievement(Achievement achievement) {
		achievementDao.addAchievement(achievement);
	}
	
	/**
	 * @brief Method to obtain the achievement using the id from the dao
	 * @param id Achievement id
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public Achievement getAchievementById(int achievement_id) {
		return achievementDao.getAchievementById(achievement_id);
	}
	
	/**
	 * @brief Method to obtain the achievements from the dao
	 * @return List<Achievement>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Achievement> listAchievements() {
		return achievementDao.listAchievements();
	}

}