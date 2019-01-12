/**
 * @file Deck.java
 * @brief The deck class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.deck;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.mondragon.deckcardmap.DeckCardMap;
import edu.mondragon.user.User;

@Entity
@Table(name = "DECKS")
public class Deck {

	/**
	 * @brief Deck id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DECK_ID")
	private Integer deck_id;

	/**
	 * @brief Deck name
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * @brief User id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATOR_ID", referencedColumnName = "USER_ID", nullable = true)
	private User creator;
	
	/**
	 * @brief DeckCardMap list (FK)
	 */
	@OneToMany(mappedBy="deck", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<DeckCardMap> deckCardMaps = new HashSet<DeckCardMap>();	
	
	/**
	 * @brief Empty constructor
	 */
	public Deck() {
	}
	
	/**
	 * @brief Class constructor
	 * @param name
	 * @param description
	 * @param points
	 */
	public Deck(String name) {
		this.name = name;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getDeck_id() {
		return deck_id;
	}

	public void setDeck_id(Integer deck_id) {
		this.deck_id = deck_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<DeckCardMap> getDeckCardMaps() {
		return deckCardMaps;
	}

	public void setDeckCardMaps(Set<DeckCardMap> deckCardMaps) {
		this.deckCardMaps = deckCardMaps;
	}

}