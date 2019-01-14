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
	private Integer match_id;

	/**
	 * @brief Match date
	 */
	@Column(name = "DATE")
	private LocalDateTime date;
	
	/**
	 * @brief user_1 user_id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_1_ID", referencedColumnName = "USER_ID")
	private User user_1;
	
	/**
	 * @brief user_2 user_id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_2_ID", referencedColumnName = "USER_ID")
	private User user_2;
	
	/**
	 * @brief deck_1 deck_id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DECK_1_ID", referencedColumnName = "DECK_ID")
	private Deck deck_1;
	
	/**
	 * @brief deck_2 deck_id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DECK_2_ID", referencedColumnName = "DECK_ID")
	private Deck deck_2;
	
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
		this.date = LocalDateTime.now();
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser_1() {
		return user_1;
	}

	public void setUser_1(User user_1) {
		this.user_1 = user_1;
	}

	public User getUser_2() {
		return user_2;
	}

	public void setUser_2(User user_2) {
		this.user_2 = user_2;
	}

	public Deck getDeck_1() {
		return deck_1;
	}

	public void setDeck_1(Deck deck_1) {
		this.deck_1 = deck_1;
	}

	public Deck getDeck_2() {
		return deck_2;
	}

	public void setDeck_2(Deck deck_2) {
		this.deck_2 = deck_2;
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