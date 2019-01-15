/**
 * @file UserCardMap.java
 * @brief The userCardMap class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.usercardmap;

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

import edu.mondragon.card.Card;
import edu.mondragon.user.User;

@Entity
@Table(name = "USER_CARD_MAPS")
public class UserCardMap {

	/**
	 * @brief User card map id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_CARD_MAP_ID")
	private Integer user_card_map_id;

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
	 * @brief User user id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User user;
	
	/**
	 * @brief Card card id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID")
	private Card card;
	
	/**
	 * @brief Class constructor
	 */
	public UserCardMap() {
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
	public Integer getUser_card_map_id() {
		return user_card_map_id;
	}

	public void setUser_card_map_id(Integer user_card_map_id) {
		this.user_card_map_id = user_card_map_id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}