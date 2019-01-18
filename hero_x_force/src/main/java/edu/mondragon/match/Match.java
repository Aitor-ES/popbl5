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
 * @brief Package edu.mondragon.match
 */

package edu.mondragon.match;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.mondragon.deck.Deck;
import edu.mondragon.tournament.Tournament;
import edu.mondragon.user.User;

@Entity
@Table(name = "MATCHES")
public class Match {

	/**
	 * @brief Matches id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATCH_ID")
	private Integer matchId;

	/**
	 * @brief Match date
	 */
	@Column(name = "DATE")
	private String date;

	/**
	 * @brief user_1 user_id (FK)
	 * @brief Match hour
	 */
	@Column(name = "HOUR")
	private String hour;

	/**
	 * @brief user_1_matchMap list (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_1_ID", referencedColumnName = "USER_ID")
	private User user1;

	/**
	 * @brief user_2 user_id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_2_ID", referencedColumnName = "USER_ID")
	private User user2;

	/**
	 * @brief deck_1 deck_id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DECK_1_ID", referencedColumnName = "DECK_ID")
	private Deck deck1;

	/**
	 * @brief deck_2 deck_id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DECK_2_ID", referencedColumnName = "DECK_ID")
	private Deck deck2;

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

	/**
	 * @brief This method parses the current date
	 * @param date LocalDateTime object
	 * @return String
	 */
	private String parseCurrentDate(LocalDateTime date) {
		String pattern = "YYYY-MM-dd";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		return date.format(formatter);
	}

	/**
	 * @brief This method parses the current hour
	 * @param date LocalDateTime object
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
	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
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
	
	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public Deck getDeck1() {
		return deck1;
	}

	public void setDeck1(Deck deck1) {
		this.deck1 = deck1;
	}

	public Deck getDeck2() {
		return deck2;
	}

	public void setDeck2(Deck deck2) {
		this.deck2 = deck2;
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