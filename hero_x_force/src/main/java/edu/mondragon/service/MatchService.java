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
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.service;

import java.util.List;

import edu.mondragon.model.Match;

public interface MatchService {
	void addMatch(Match match);

	List<Match> listMatches();

	Match getMatchById(int match_id);
}