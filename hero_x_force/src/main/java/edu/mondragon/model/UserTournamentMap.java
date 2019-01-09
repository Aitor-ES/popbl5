/**
 * @file UserTournamentMap.java
 * @brief The UserTournamentMap class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.model;

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

@Entity
@Table(name = "USER_TOURNAMENT_MAPS")
public class UserTournamentMap {

	/**
	 * @brief User tournament map id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_TOURNAMENT_MAP_ID")
	private Integer user_tournament_map_id;

	/**
	 * @brief Joined date
	 */
	@Column(name = "DATE")
	private LocalDateTime date;
	
	/**
	 * @brief User user id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
	private User user;
	
	/**
	 * @brief Tournament tournament id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "TOURNAMENT_ID", nullable = true)
	private Tournament tournament;
	
	/**
	 * @brief Class constructor
	 */
	public UserTournamentMap() {
		this.date = LocalDateTime.now();
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getUser_tournament_map_id() {
		return user_tournament_map_id;
	}

	public void setUser_tournament_map_id(Integer user_tournament_map_id) {
		this.user_tournament_map_id = user_tournament_map_id;
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