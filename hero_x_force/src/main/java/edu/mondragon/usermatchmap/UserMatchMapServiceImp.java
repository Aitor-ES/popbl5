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

package edu.mondragon.usermatchmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserMatchMapServiceImp implements UserMatchMapService {

	/**
	 * @brief userMatchMap dao object
	 */
	@Autowired
	private UserMatchMapDao userMatchMapDao;

	/**
	 * @brief Method to add userMatchMaps to the dao
	 * @param userMatchMap UserMatchMap object
	 * @return void
	 */
	@Transactional
	@Override
	public void addUserMatchMap(UserMatchMap userMatchMap) {
		userMatchMapDao.addUserMatchMap(userMatchMap);
	}
	
	/**
	 * @brief Method to obtain the userMatchMaps from the dao
	 * @return List<UserMatchMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<UserMatchMap> listUserMatchMaps() {
		return userMatchMapDao.listUserMatchMaps();
	}
	
	/**
	 * @brief Method to obtain the userMatchMap using the id from the dao
	 * @param id UserMatchMaps id
	 * @return UserMatchMap
	 */
	@Transactional(readOnly = true)
	@Override
	public UserMatchMap getUserMatchMapById(int userMatchMap_id) {
		return userMatchMapDao.getUserMatchMapById(userMatchMap_id);
	}

}