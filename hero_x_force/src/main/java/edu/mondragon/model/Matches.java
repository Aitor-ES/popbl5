/**
 * @file Matches.java
 * @brief The matches class
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
@Table(name = "MATCHES")
public class Matches {

	/**
	 * @brief Matches id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATCH_ID")
	private Integer match_id;

	/**
	 * @brief Matches name
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * @brief Matches number of participants
	 */
	@Column(name = "NUM_PARTICIPANTS")
	private Integer num_participants;

	/**
	 * @brief Matches date
	 */
	@Column(name = "DATE")
	private String date;

	/**
	 * @brief Matches winner id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WINNER_ID", referencedColumnName = "USER_ID", nullable = true)
	private User user;

	/**
	 * @brief Empty constructor
	 */
	public Matches() {
	}

	/**
	 * @brief Class constructor
	 * @param name             Matches name
	 * @param num_participants Matches participants
	 * @param date             Matches start date
	 */
	public Matches(String name, Integer num_participants) {
		this.name = name;
		this.num_participants = num_participants;
		this.date = LocalDate.now().toString();
	}

	public Integer getMatch_id() {
		return match_id;
	}

	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum_participants() {
		return num_participants;
	}

	public void setNum_participants(Integer num_participants) {
		this.num_participants = num_participants;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}