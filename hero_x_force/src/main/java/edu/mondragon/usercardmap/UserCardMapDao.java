/**
 * @file UserCardMapDao.java
 * @brief This class is the interface for the Dao
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

public interface UserCardMapDao {
	/**
	 * @brief Method to add an UserCardMap
	 * @param userCardMap UserCardMap object
	 * @return void
	 */
	void addUserCardMap(UserCardMap userCardMap);

	/**
	 * @brief Method to obtain the UserCardMap list
	 * @return List<UserCardMap>
	 */
	List<UserCardMap> listUserCardMaps();

	/**
	 * @brief Method to obtain an UserCardMap
	 * @param userCardMap_id UserCardMap object id
	 * @return UserCardMap
	 */
	UserCardMap getUserCardMapById(int userCardMap_id);
}