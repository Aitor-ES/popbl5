/**
 * @file TournamentServiceImp.java
 * @brief Class to implement the tournament service and manage the tournament dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TournamentServiceImp implements TournamentService {

	/**
	 * @brief Tournament dao object
	 */
	@Autowired
	private TournamentDao tournamentDao;

	/**
	 * @brief Method to add a tournament to the dao
	 * @param tournament Tournament object
	 * @return void
	 */
	@Transactional
	@Override
	public void addTournament(Tournament tournament) {
		tournamentDao.addTournament(tournament);
	}
	
	/**
	 * @brief Method to obtain the tournaments from the dao
	 * @return List<Tournament>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Tournament> listTournaments() {
		return tournamentDao.listTournaments();
	}

	/**
	 * @brief Method to obtain the tournament using the id from the dao
	 * @param id Tournament id
	 * @return Tournament
	 */
	@Transactional(readOnly = true)
	@Override
	public Tournament getTournamentById(int tournamentId) {
		return tournamentDao.getTournamentById(tournamentId);
	}

}