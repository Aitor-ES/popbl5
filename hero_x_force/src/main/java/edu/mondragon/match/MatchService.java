/**
 * @file MatchService.java
 * @brief The match service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.match
 */

package edu.mondragon.match;

import java.util.List;

public interface MatchService {
	/**
	 * @brief This method adds a match
	 * @param match Match object
	 * @return void
	 */
	void addMatch(Match match);

	/**
	 * @brief This method obtains the match list
	 * @return List<Match>
	 */
	List<Match> listMatches();

	/**
	 * @brief This method the returns the match which has the indicated id
	 * @param match_id Match id int
	 * @return Match
	 */
	Match getMatchById(int match_id);
	
	/**
	 * @brief This method removes a match
	 * @param match Match object
	 * @return void
	 */
	void removeMatch(Match match);
}