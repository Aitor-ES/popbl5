/**
 * @file Deck.java
 * @brief The deck model class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.deck
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
import edu.mondragon.match.Match;
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
	private Integer deckId;

	/**
	 * @brief Deck name
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * @brief User id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATOR_ID", referencedColumnName = "USER_ID")
	private User creator;
	
	/**
	 * @brief DeckCardMap list (FK)
	 */
	@OneToMany(mappedBy="deck", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<DeckCardMap> deckCardMaps = new HashSet<>();
	
	/**
	 * @brief Card id (FK)
	 */
	@OneToMany(mappedBy="deck1", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<Match> matches1 = new HashSet<>();
	
	/**
	 * @brief Card id (FK)
	 */
	@OneToMany(mappedBy="deck2", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<Match> matches2 = new HashSet<>();
	
	/**
	 * @brief Empty constructor
	 */
	public Deck() {}
	
	/**
	 * @brief Class constructor
	 * @param name Deck name String
	 * @param creator Creator user
	 */
	public Deck(String name, User creator) {
		this.name = name;
		this.creator = creator;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getDeckId() {
		return deckId;
	}

	public void setDeckId(Integer deckId) {
		this.deckId = deckId;
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

	public Set<Match> getMatches1() {
		return matches1;
	}

	public void setMatches1(Set<Match> matches1) {
		this.matches1 = matches1;
	}

	public Set<Match> getMatches2() {
		return matches2;
	}

	public void setMatches2(Set<Match> matches2) {
		this.matches2 = matches2;
	}

}