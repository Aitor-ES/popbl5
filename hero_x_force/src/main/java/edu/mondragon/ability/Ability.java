/**
 * @file Ability.java
 * @brief The ability model class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.ability
 */

package edu.mondragon.ability;

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

import edu.mondragon.card.Card;

@Entity
@Table(name = "ABILITIES")
public class Ability {

	/**
	 * @brief Ability id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ABILITY_ID")
	private Integer abilityId;

	/**
	 * @brief Ability name
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * @brief Ability description
	 */
	@Column(name = "DESCRIPTION")
	private String description;
	
	/**
	 * @brief Card id (FK)
	 */
	@OneToMany(mappedBy="ability", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<Card> cards = new HashSet<>();
	
	/**
	 * @brief Empty constructor
	 */
	public Ability() {
	}
	
	/**
	 * @brief Class constructor
	 * @param name Ability name
	 * @param description Ability description
	 */
	public Ability(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getAbilityId() {
		return abilityId;
	}

	public void setAbilityId(Integer abilityId) {
		this.abilityId = abilityId;
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

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

}