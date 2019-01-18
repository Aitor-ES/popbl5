/**
 * @file TestEntity.java
 * @brief TestEntity model class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.test.entity
 */

package edu.mondragon.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity {

	/**
	 * @brief TestEntity id (PK)
	 */
	@Id
	private long id;

	/**
	 * @brief Description
	 */
	private String description;

	/**
	 * @brief Class constructor
	 * @param id          Test entity id
	 * @param description Test entity description
	 */
	public TestEntity(long id, String description) {
		this.id = id;
		this.description = description;
	}

	/*
	 * Getters and setters
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}