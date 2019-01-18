/**
 * @file UserTournamentMap.java
 * @brief The UserTournamentMap model class
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

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.mondragon.tournament.Tournament;
import edu.mondragon.user.User;

@Entity
@Table(name = "USER_TOURNAMENT_MAPS")
public class UserTournamentMap {

	/**
	 * @brief User tournament map id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_TOURNAMENT_MAP_ID")
	private Integer userTournamentMapId;

	/**
	 * @brief Joined date
	 */
	@Column(name = "DATE")
	private LocalDateTime date;
	
	/**
	 * @brief User (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User user;
	
	/**
	 * @brief Tournament (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "TOURNAMENT_ID")
	private Tournament tournament;
	
	/**
	 * @brief Empty constructor
	 */
	public UserTournamentMap() {
		this.date = LocalDateTime.now();
	}
	
	/**
	 * @brief Class constructor with parameters
	 * @param user User who joins the tournament
	 * @param tournament Tournament object
	 */
	public UserTournamentMap(User user, Tournament tournament) {
		this.date = LocalDateTime.now();
		
		this.user = user;
		this.tournament = tournament;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getUserTournamentMapId() {
		return userTournamentMapId;
	}

	public void setUserTournamentMapId(Integer userTournamentMapId) {
		this.userTournamentMapId = userTournamentMapId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}