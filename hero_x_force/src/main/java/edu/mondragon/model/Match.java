/**
 * @file Match.java
 * @brief The match class
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

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MATCHES")
public class Match {

	/**
	 * @brief Matches id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATCH_ID")
	private Integer match_id;

	/**
	 * @brief Match date
	 */
	@Column(name = "DATE")
	private String date;
	
	/**
	 * @brief Tournament id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "TOURNAMENT_ID", nullable = true)
	private Tournament tournament;
	
	/**
	 * @brief User id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
	private User user;

	/**
	 * @brief UserMatchMap list (FK)
	 */
	@OneToMany(mappedBy="match", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserMatchMap> userMatchMaps = new HashSet<UserMatchMap>();
	
	/**
	 * @brief Empty constructor
	 */
	public Match() {
	}
	
	/**
	 * @brief Class constructor
	 * @param date
	 */
	public Match(String date) {
		this.date = date;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getMatch_id() {
		return match_id;
	}

	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<UserMatchMap> getUserMatchMaps() {
		return userMatchMaps;
	}

	public void setUserMatchMaps(Set<UserMatchMap> userMatchMaps) {
		this.userMatchMaps = userMatchMaps;
	}
	
}