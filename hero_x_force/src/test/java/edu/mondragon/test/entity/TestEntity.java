package edu.mondragon.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity {

	@Id
	private long id;
	
	private String description;

	public TestEntity(long id, String description) {
		this.id = id;
		this.description = description;
	}

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