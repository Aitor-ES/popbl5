/**
 * @file UserTournamentMapDao.java
 * @brief This class is the interface for the Dao
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

public interface UserTournamentMapDao {
	/**
	 * @brief Method to add an UserTournamentMap
	 * @param userTournamentMap UserTournamentMap object
	 * @return void
	 */
	void addUserTournamentMap(UserTournamentMap userTournamentMap);

	/**
	 * @brief Method to get the UserTournamentMap list
	 * @return List<UserTournamentMap>
	 */
	List<UserTournamentMap> listUserTournamentMaps();

	/**
	 * @brief Method to obtain an UserTournamentMap object
	 * @param userTournamentMap_id UserTournamentMap object id int
	 * @return UserTournamentMap
	 */
	UserTournamentMap getUserTournamentMapById(int userTournamentMap_id);
}