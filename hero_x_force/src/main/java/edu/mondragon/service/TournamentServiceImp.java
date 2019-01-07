/**
 * @file UserserviceImp.java
 * @brief Class to manage the user dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.dao.TournamentDao;
import edu.mondragon.model.Tournament;

@Service
public class TournamentServiceImp implements TournamentService {

	/**
	 * @brief Tournament dao object
	 */
	@Autowired
	private TournamentDao tournamentDao;

	/**
	 * @brief Method to add tournaments to the dao
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

}