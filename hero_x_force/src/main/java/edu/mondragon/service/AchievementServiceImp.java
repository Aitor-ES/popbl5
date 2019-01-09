/**
 * @file AchievementServiceImp.java
 * @brief Class to manage the user dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.dao.AchievementDao;
import edu.mondragon.model.Achievement;

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