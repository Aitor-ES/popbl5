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
 * @brief Package edu.mondragon.model
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
	private Integer deck_card_map_id;

	/**
	 * @brief Formed date
	 */
	@Column(name = "POSITION")
	private Integer position;
	
	/**
	 * @brief User user id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DECK_ID", referencedColumnName = "DECK_ID", nullable = true)
	private Deck deck;
	
	/**
	 * @brief Card card id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID", nullable = true)
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
	public DeckCardMap(Integer position) {
		this.position = position;
	}

	/*
	 * @brief Getters and setters
	 */	
	public Integer getDeck_card_map_id() {
		return deck_card_map_id;
	}

	public void setDeck_card_map_id(Integer deck_card_map_id) {
		this.deck_card_map_id = deck_card_map_id;
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