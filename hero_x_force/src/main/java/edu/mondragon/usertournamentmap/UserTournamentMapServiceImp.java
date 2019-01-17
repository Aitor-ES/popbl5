/**
 * @file UserTournamentMapServiceImp.java
 * @brief Class to manage the UserTournamentMap dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.usertournamentmap
 */

package edu.mondragon.usertournamentmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTournamentMapServiceImp implements UserTournamentMapService {

	/**
	 * @brief userTournamentMap dao object
	 */
	@Autowired
	private UserTournamentMapDao userTournamentMapDao;

	/**
	 * @brief Method to add userTournamentMaps to the dao
	 * @param userTournamentMap UserTournamentMap object
	 * @return void
	 */
	@Transactional
	@Override
	public void addUserTournamentMap(UserTournamentMap userTournamentMap) {
		userTournamentMapDao.addUserTournamentMap(userTournamentMap);
	}
	
	/**
	 * @brief Method to obtain the userTournamentMaps from the dao
	 * @return List<UserTournamentMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<UserTournamentMap> listUserTournamentMaps() {
		return userTournamentMapDao.listUserTournamentMaps();
	}
	
	/**
	 * @brief Method to obtain the userTournamentMap using the id from the dao
	 * @param id UserTournamentMaps id
	 * @return UserTournamentMap
	 */
	@Transactional(readOnly = true)
	@Override
	public UserTournamentMap getUserTournamentMapById(int userTournamentMap_id) {
		return userTournamentMapDao.getUserTournamentMapById(userTournamentMap_id);
	}

}