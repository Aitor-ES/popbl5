/**
 * @file TournamentDao.java
 * @brief This class is the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.tournament
 */

package edu.mondragon.tournament;

import java.util.List;

public interface TournamentDao {
	/**
	 * @brief Method to add a tournament
	 * @param tournament Tournament object
	 * @return void
	 */
	void addTournament(Tournament tournament);

	/**
	 * @brief Method to obtain the tournament list
	 * @return List<Tournament>
	 */
	List<Tournament> listTournaments();

	/**
	 * @brief Method to find a tournament using the id
	 * @param tournamentId Tournament id int
	 * @return Tournament
	 */
	Tournament getTournamentById(int tournamentId);
}