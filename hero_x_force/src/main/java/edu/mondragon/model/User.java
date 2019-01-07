/**
 * @file User.java
 * @brief The user class
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	/**
	 * @brief User id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int user_id;

	/**
	 * @brief User name
	 */
	@Column(name = "USERNAME")
	private String username;

	/**
	 * @brief User email
	 */
	@Column(name = "EMAIL")
	private String email;

	/**
	 * @brief User password
	 */
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * @brief User wins
	 */
	@Column(name = "WINS")
	private int wins;
	
	/**
	 * @brief User loses
	 */
	@Column(name = "LOSES")
	private int loses;
	
	/**
	 * @brief User points
	 */
	@Column(name = "POINTS")
	private int points;
	
	/**
	 * @brief Empty constructor
	 */
	public User() {}

	/**
	 * @brief Class constructor
	 * @param username Users name
	 * @param email  Users email
	 * @param password Users password
	 */
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {
		this.loses = loses;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}