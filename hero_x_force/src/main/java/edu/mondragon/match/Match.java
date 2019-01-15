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

package edu.mondragon.match;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import edu.mondragon.tournament.Tournament;
import edu.mondragon.user.User;
import edu.mondragon.usermatchmap.UserMatchMap;

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
	 * @brief Match hour
	 */
	@Column(name = "HOUR")
	private String hour;
	
	/**
	 * @brief user_1_matchMap list (FK)
	 */
	@OneToMany(mappedBy="user_1", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserMatchMap> user_1_matchMap = new HashSet<UserMatchMap>();
	
	/**
	 * @brief user_2_matchMap list (FK)
	 */
	@OneToMany(mappedBy="user_2", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserMatchMap> user_2_matchMap = new HashSet<UserMatchMap>();
	
	/**
	 * @brief Tournament id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TOURNAMENT_ID", referencedColumnName = "TOURNAMENT_ID", nullable = true)
	private Tournament tournament;
	
	/**
	 * @brief Winner user id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WINNER_ID", referencedColumnName = "USER_ID", nullable = true)
	private User winner;
	
	/**
	 * @brief Class constructor
	 */
	public Match() {
		this.date = parseCurrentDate(LocalDateTime.now());
		this.hour = parseCurrentHour(LocalDateTime.now());
	}

	private String parseCurrentDate(LocalDateTime date) {
		String pattern = "YYYY-MM-dd";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		
		return date.format(formatter);
	}
	
	private String parseCurrentHour(LocalDateTime date) {
		String pattern = "HH:mm";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		
		return date.format(formatter);
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

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Set<UserMatchMap> getUser_1_matchMap() {
		return user_1_matchMap;
	}

	public void setUser_1_matchMap(Set<UserMatchMap> user_1_matchMap) {
		this.user_1_matchMap = user_1_matchMap;
	}

	public Set<UserMatchMap> getUser_2_matchMap() {
		return user_2_matchMap;
	}

	public void setUser_2_matchMap(Set<UserMatchMap> user_2_matchMap) {
		this.user_2_matchMap = user_2_matchMap;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public User getWinner() {
		return winner;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}
	
}