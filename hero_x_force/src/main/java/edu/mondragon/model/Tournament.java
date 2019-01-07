/**
 * @file Tournament.java
 * @brief The tournament class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.model;

import java.time.LocalDate;

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
@Table(name = "TOURNAMENTS")
public class Tournament {

	/**
	 * @brief Tournament id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOURNAMENT_ID")
	private int tournament_id;

	/**
	 * @brief Tournament name
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * @brief Tournament number of participants
	 */
	@Column(name = "NUM_PARTICIPANTS")
	private int num_participants;

	/**
	 * @brief Tournament date
	 */
	@Column(name = "DATE")
	private String date;

	/**
	 * @brief Tournament winner id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="WINNER_ID", nullable=true)
  private User user;
	
	@Column(name = "WINNER_ID")
	private int winner_id;

	/**
	 * @brief Empty constructor
	 */
	public Tournament() {
	}

	/**
	 * @brief Class constructor
	 * @param name             Tournament name
	 * @param num_participants Tournament participants
	 * @param date 			       Tournament start date
	 */
	public Tournament(String name, int num_participants) {
		this.name = name;
		this.num_participants = num_participants;
		this.date = LocalDate.now().toString();
	}

	public int getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(int tournament_id) {
		this.tournament_id = tournament_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum_participants() {
		return num_participants;
	}

	public void setNum_participants(int num_participants) {
		this.num_participants = num_participants;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getWinnerID() {
		return winner_id;
	}

	public void setWinnerID(int winner_id) {
		this.winner_id = winner_id;
	}

}