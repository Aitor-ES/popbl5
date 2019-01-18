/**
 * @file Achievement.java
 * @brief The achievement model class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.achievement
 */

package edu.mondragon.achievement;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.mondragon.userachievementmap.UserAchievementMap;

@Entity
@Table(name = "ACHIEVEMENTS")
public class Achievement {

	/**
	 * @brief Achievement id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACHIEVEMENT_ID")
	private Integer achievementId;

	/**
	 * @brief Achievement name
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * @brief Achievement points
	 */
	@Column(name = "POINTS")
	private Integer points;

	/**
	 * @brief Achievement description
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	/**
	 * @brief User achievement map id (FK)
	 */
	@OneToMany(mappedBy = "achievement", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<UserAchievementMap> userAchievementMaps = new HashSet<>();

	/**
	 * @brief Empty constructor
	 */
	public Achievement() {
	}

	/**
	 * @brief Class constructor
	 * @param name Achievement name
	 * @param description Achievement description
	 * @param points Achievement points
	 */
	public Achievement(String name, Integer points, String description) {
		this.name = name;
		this.points = points;
		this.description = description;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(Integer achievementId) {
		this.achievementId = achievementId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<UserAchievementMap> getUserAchievementMaps() {
		return userAchievementMaps;
	}

	public void setUserAchievementMaps(Set<UserAchievementMap> userAchievementMaps) {
		this.userAchievementMaps = userAchievementMaps;
	}

}