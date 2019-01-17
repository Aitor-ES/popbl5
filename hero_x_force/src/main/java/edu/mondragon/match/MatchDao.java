/**
 * @file MatchDao.java
 * @brief This class is the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.match
 */

package edu.mondragon.match;

import java.util.List;

public interface MatchDao {
	/**
	 * @brief This method adds a match
	 * @param match Match object
	 * @return void
	 */
	void addMatch(Match match);
	
	/**
	 * @brief This method updates a match
	 * @param match Match object
	 * @return void
	 */
	void updateMatch(Match match);

	/**
	 * @brief This method obtains the match list
	 * @return List<Match>
	 */
	List<Match> listMatches();
	
	/**
	 * @brief This method the returns the match which has the indicated id
	 * @param matchId Match id int
	 * @return Match
	 */
	Match getMatchById(int matchId);
	
	/**
	 * @brief This method removes a match
	 * @param match Match object
	 * @return void
	 */
	void removeMatch(Match match);
}