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
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.dao;

import java.util.List;

import edu.mondragon.model.UserCardMap;

public interface UserCardMapDao {
	void addUserCardMap(UserCardMap userCardMap);

	List<UserCardMap> listUserCardMaps();

	UserCardMap getUserCardMapById(int userCardMap_id);
}