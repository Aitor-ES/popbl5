/**
 * @file MatchServiceImp.java
 * @brief Class to manage the user dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchServiceImp implements MatchService {

	/**
	 * @brief Match dao object
	 */
	@Autowired
	private MatchDao matchDao;

	/**
	 * @brief Method to add matches to the dao
	 * @param match Match object
	 * @return void
	 */
	@Transactional
	@Override
	public void addMatch(Match match) {
		matchDao.addMatch(match);
	}
	
	/**
	 * @brief This method updates a match
	 * @param match Match object
	 * @return void
	 */
	@Transactional
	@Override
	public void updateMatch(Match match) {
		matchDao.updateMatch(match);
	}
	
	/**
	 * @brief Method to obtain the match using the id from the dao
	 * @param matchId Match id int
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public Match getMatchById(int matchId) {
		return matchDao.getMatchById(matchId);
	}
	
	/**
	 * @brief Method to obtain the matches from the dao
	 * @return List<Match>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Match> listMatches() {
		return matchDao.listMatches();
	}

	/**
	 * @brief Method to remove a match
	 * @param match Match object
	 * @return void
	 */
	@Override
	public void removeMatch(Match match) {
		matchDao.removeMatch(match);		
	}

}