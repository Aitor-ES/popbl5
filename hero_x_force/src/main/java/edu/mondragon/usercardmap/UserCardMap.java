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
	 * @brief Unlock date
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
	 * @brief Card card id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID", nullable = true)
	private Card card;
	
	/**
	 * @brief Class constructor
	 */
	public UserCardMap() {
		this.date = LocalDateTime.now();
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}