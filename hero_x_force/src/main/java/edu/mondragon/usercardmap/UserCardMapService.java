/**
 * @file UserCardMapService.java
 * @brief The user service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.usercardmap
 */

package edu.mondragon.usercardmap;

import java.util.List;

public interface UserCardMapService {
	/**
	 * @brief Method to add a UserCardMap
	 * @param userCardMap UserCardMap object
	 * @return void
	 */
	void addUserCardMap(UserCardMap userCardMap);

	/**
	 * @brief Method to obtain the UserCardMap list
	 * @return List<UserCardMap>
	 */
	List<UserCardMap> listUserCardMaps();

	/**@brief Method to get a UserCardMap
	 * @param userCardMapId UserCardMap object id
	 * @return UserCardMap
	 */
	UserCardMap getUserCardMapById(int userCardMapId);
}