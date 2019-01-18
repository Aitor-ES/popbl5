/**
 * @file Tournament.java
 * @brief The tournament model class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.tournament
 */

package edu.mondragon.tournament;

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

import edu.mondragon.match.Match;
import edu.mondragon.user.User;
import edu.mondragon.usertournamentmap.UserTournamentMap;

@Entity
@Table(name = "TOURNAMENTS")
public class Tournament {

	/**
	 * @brief Tournament id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOURNAMENT_ID")
	private Integer tournamentId;

	/**
	 * @brief Tournament name
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * @brief Tournament number of participants
	 */
	@Column(name = "NUM_PARTICIPANTS")
	private Integer numParticipants;

	/**
	 * @brief Tournament date string
	 */
	@Column(name = "DATE")
	private String date;

	/**
	 * @brief Tournament hour string
	 */
	@Column(name = "HOUR")
	private String hour;

	/**
	 * @brief Winner (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WINNER_ID", referencedColumnName = "USER_ID", nullable = true)
	private User winner;

	/**
	 * @brief Match list (FK)
	 */
	@OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Match> matches = new HashSet<>();

	/**
	 * @brief UserTournamentMap list (FK)
	 */
	@OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<UserTournamentMap> userTournamentMaps = new HashSet<>();

	/**
	 * @brief Empty constructor
	 */
	public Tournament() {
	}

	/**
	 * @brief Class constructor
	 * @param name            Tournament name
	 * @param numParticipants Number of participants
	 */
	public Tournament(String name, Integer numParticipants) {
		this.name = name;
		this.numParticipants = numParticipants;
		this.date = parseCurrentDate(LocalDateTime.now());
		this.hour = parseCurrentHour(LocalDateTime.now());
	}

	/**
	 * @brief Method to parse date
	 * @param date LocalDateTime to parse
	 * @return String
	 */
	private String parseCurrentDate(LocalDateTime date) {
		String pattern = "YYYY-MM-dd";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		return date.format(formatter);
	}

	/**
	 * @brief Method to parse hour
	 * @param date LocalDateTime to parse
	 * @return String
	 */
	private String parseCurrentHour(LocalDateTime date) {
		String pattern = "HH:mm";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		return date.format(formatter);
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumParticipants() {
		return numParticipants;
	}

	public void setNumParticipants(Integer numParticipants) {
		this.numParticipants = numParticipants;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getWinner() {
		return winner;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public Set<UserTournamentMap> getUserTournamentMaps() {
		return userTournamentMaps;
	}

	public void setUserTournamentMaps(Set<UserTournamentMap> userTournamentMaps) {
		this.userTournamentMaps = userTournamentMaps;
	}

}