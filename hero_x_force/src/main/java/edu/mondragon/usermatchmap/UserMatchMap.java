/**
 * @file UserMatchMap.java
 * @brief The UserMatchMap class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.usermatchmap;

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

import edu.mondragon.match.Match;
import edu.mondragon.user.User;

@Entity
@Table(name = "USER_MATCH_MAPS")
public class UserMatchMap {

	/**
	 * @brief User match map id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_MATCH_MAP_ID")
	private Integer user_match_map_id;

	/**
	 * @brief Played date
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
	 * @brief Match match id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATCH_ID", referencedColumnName = "MATCH_ID", nullable = true)
	private Match match;
	
	/**
	 * @brief Class constructor
	 */
	public UserMatchMap() {
		this.date = LocalDateTime.now();
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getUser_match_map_id() {
		return user_match_map_id;
	}

	public void setUser_match_map_id(Integer user_match_map_id) {
		this.user_match_map_id = user_match_map_id;
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

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}