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
 * @brief Package edu.mondragon.userachievementmap
 */

package edu.mondragon.userachievementmap;

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

import edu.mondragon.achievement.Achievement;
import edu.mondragon.user.User;

@Entity
@Table(name = "USER_ACHIEVEMENT_MAPS")
public class UserAchievementMap {

	/**
	 * @brief User achievement map id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ACHIEVEMENT_MAP_ID")
	private Integer userAchievementMapId;

	/**
	 * @brief Unlock date
	 */
	@Column(name = "DATE")
	private LocalDateTime date;
	
	/**
	 * @brief User user id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User user;
	
	/**
	 * @brief Achievement achievement id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACHIEVEMENT_ID", referencedColumnName = "ACHIEVEMENT_ID")
	private Achievement achievement;
	
	/**
	 * @brief Class constructor
	 */
	public UserAchievementMap() {
		this.date = LocalDateTime.now();
	}

	/*
	 * @brief Getters and setters
	 */	
	public Integer getUserAchievementMapId() {
		return userAchievementMapId;
	}

	public void setUserAchievementMapId(Integer userAchievementMapId) {
		this.userAchievementMapId = userAchievementMapId;
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

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

}