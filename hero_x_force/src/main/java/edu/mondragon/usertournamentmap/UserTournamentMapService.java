/**
 * @file UserService.java
 * @brief The user service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.usertournamentmap;

import java.util.List;

public interface UserTournamentMapService {
	void addUserTournamentMap(UserTournamentMap userTournamentMap);

	List<UserTournamentMap> listUserTournamentMaps();

	UserTournamentMap getUserTournamentMapById(int userTournamentMap_id);
}