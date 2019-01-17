/**
 * @file UserCardMapServiceImp.java
 * @brief Class to manage the UserCardMapServiceImp dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.usercardmap
 */

package edu.mondragon.usercardmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCardMapServiceImp implements UserCardMapService {

	/**
	 * @brief userCardMap dao object
	 */
	@Autowired
	private UserCardMapDao userCardMapDao;

	/**
	 * @brief Method to add userCardMaps to the dao
	 * @param userCardMap UserCardMap object
	 * @return void
	 */
	@Transactional
	@Override
	public void addUserCardMap(UserCardMap userCardMap) {
		userCardMapDao.addUserCardMap(userCardMap);
	}
	
	/**
	 * @brief Method to obtain the userCardMaps from the dao
	 * @return List<UserCardMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<UserCardMap> listUserCardMaps() {
		return userCardMapDao.listUserCardMaps();
	}
	
	/**
	 * @brief Method to obtain the userCardMap using the id from the dao
	 * @param userCardMapId UserCardMaps id int
	 * @return UserCardMap
	 */
	@Transactional(readOnly = true)
	@Override
	public UserCardMap getUserCardMapById(int userCardMapId) {
		return userCardMapDao.getUserCardMapById(userCardMapId);
	}

}