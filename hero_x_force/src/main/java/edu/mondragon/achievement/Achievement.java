/**
 * @file Achievement.java
 * @brief The achievement class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
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
	private Integer achievement_id;

	/**
	 * @brief Achievement name
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * @brief Achievement description
	 */
	@Column(name = "DESCRIPTION")
	private String description;
	
	/**
	 * @brief Achievement points
	 */
	@Column(name = "POINTS")
	private Integer points;
	
	/**
	 * @brief User achievement map id (FK)
	 */
	@OneToMany(mappedBy="achievement", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserAchievementMap> userAchievementMaps = new HashSet<UserAchievementMap>();
	
	/**
	 * @brief Empty constructor
	 */
	public Achievement() {
	}
	
	/**
	 * @brief Class constructor
	 * @param name
	 * @param description
	 * @param points
	 */
	public Achievement(String name, String description, Integer points) {
		this.name = name;
		this.description = description;
		this.points = points;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getAchievement_id() {
		return achievement_id;
	}

	public void setAchievement_id(Integer achievement_id) {
		this.achievement_id = achievement_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Set<UserAchievementMap> getUserAchievementMaps() {
		return userAchievementMaps;
	}

	public void setUserAchievementMaps(Set<UserAchievementMap> userAchievementMaps) {
		this.userAchievementMaps = userAchievementMaps;
	}
	
}