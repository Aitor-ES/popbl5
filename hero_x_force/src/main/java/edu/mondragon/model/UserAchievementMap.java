/**
 * @file UserAchievementMap.java
 * @brief The userAchievementMap class
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
@Table(name = "USER_ACHIEVEMENT_MAPS")
public class UserAchievementMap {

	/**
	 * @brief User achievement map id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ACHIEVEMENT_MAP_ID")
	private Integer user_achievement_map_id;

	/**
	 * @brief Unlock date
	 */
	@Column(name = "DATE")
	private String date;
	
	/**
	 * @brief User user id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
	private User user;
	
	/**
	 * @brief Achievement achievement id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACHIEVEMENT_ID", referencedColumnName = "ACHIEVEMENT_ID", nullable = true)
	private Achievement achievement;
	
	/**
	 * @brief Empty constructor
	 */
	public UserAchievementMap() {
	}
	
	/**
	 * @brief Class constructor
	 * @param date
	 */
	public UserAchievementMap(String date) {
		this.date = date;
	}

	/*
	 * @brief Getters and setters
	 */	
	public Integer getUser_achievement_map_id() {
		return user_achievement_map_id;
	}

	public void setUser_achievement_map_id(Integer user_achievement_map_id) {
		this.user_achievement_map_id = user_achievement_map_id;
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

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

}