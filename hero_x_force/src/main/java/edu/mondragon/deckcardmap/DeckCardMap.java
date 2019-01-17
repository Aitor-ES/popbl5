/**
 * @file DeckCardMap.java
 * @brief The deckCardMap class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.deckcardmap
 */

package edu.mondragon.deckcardmap;

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
import edu.mondragon.deck.Deck;

@Entity
@Table(name = "DECK_CARD_MAPS")
public class DeckCardMap {

	/**
	 * @brief Deck card map id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DECK_CARD_MAP_ID")
	private Integer deckCardMapId;

	/**
	 * @brief Formed date
	 */
	@Column(name = "POSITION")
	private Integer position;
	
	/**
	 * @brief User user id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DECK_ID", referencedColumnName = "DECK_ID")
	private Deck deck;
	
	/**
	 * @brief Card card id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID")
	private Card card;
	
	/**
	 * @brief Empty constructor
	 */
	public DeckCardMap() {
	}
	
	/**
	 * @brief Class constructor
	 * @param date
	 */
	public DeckCardMap(Integer position, Deck deck, Card card) {
		this.position = position;
		this.deck = deck;
		this.card = card;
	}

	/*
	 * @brief Getters and setters
	 */	
	public Integer getDeckCardMapId() {
		return deckCardMapId;
	}

	public void setDeckCardMapId(Integer deckCardMapId) {
		this.deckCardMapId = deckCardMapId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}