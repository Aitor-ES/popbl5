/**
 * @file UserTournamentMapService.java
 * @brief The user tournament map service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.usertournamentmap
 */

package edu.mondragon.usertournamentmap;

import java.util.List;

public interface UserTournamentMapService {
	/**
	 * @brief Method to add a UserTournamentMap
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
	 * @brief Method to obtain a UserTournamentMap object
	 * @param userTournamentMapId UserTournamentMap id int
	 * @return UserTournamentMap
	 */
	UserTournamentMap getUserTournamentMapById(int userTournamentMapId);
}