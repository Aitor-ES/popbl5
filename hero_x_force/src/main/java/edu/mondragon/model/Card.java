/**
 * @file Card.java
 * @brief The card class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.model;

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

@Entity
@Table(name = "CARDS")
public class Card {

	/**
	 * @brief Card id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARD_ID")
	private Integer card_id;

	/**
	 * @brief Card name
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * @brief Card saga
	 */
	@Column(name = "SAGA")
	private String saga;
	
	/**
	 * @brief Card image
	 */
	@Column(name = "IMG")
	private String img;
	
	/**
	 * @brief Card alternative
	 */
	@Column(name = "ALT")
	private String alt;
	
	/**
	 * @brief Card type
	 */
	@Column(name = "TYPE")
	private String type;
	
	/**
	 * @brief Card hit points
	 */
	@Column(name = "HP")
	private Integer hp;
	
	/**
	 * @brief Card attack
	 */
	@Column(name = "ATK")
	private Integer atk;
	
	/**
	 * @brief Card defense
	 */
	@Column(name = "DEF")
	private Integer def;
	
	/**
	 * @brief Card magic attack
	 */
	@Column(name = "MAG_ATK")
	private Integer mag_atk;
	
	/**
	 * @brief Card magic defense
	 */
	@Column(name = "MAG_DEF")
	private Integer mag_def;
	
	/**
	 * @brief Card speed
	 */
	@Column(name = "SPD")
	private Integer spd;
	
	/**
	 * @brief Card stars
	 */
	@Column(name = "STARS")
	private Integer stars;
	
	/**
	 * @brief Ability id (FK)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ABILITY_ID", referencedColumnName = "ABILITY_ID", nullable = true)
	private Ability ability;

	/**
	 * @brief UserCardMap list (FK)
	 */
	@OneToMany(mappedBy="card", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserCardMap> userCardMaps = new HashSet<UserCardMap>();
	
	/**
	 * @brief DeckCardMap list (FK)
	 */
	@OneToMany(mappedBy="card", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<DeckCardMap> deckCardMaps = new HashSet<DeckCardMap>();
	
	/**
	 * @brief Empty constructor
	 */
	public Card() {
	}
	
	/**
	 * @brief Class constructor
	 * @param name
	 * @param description
	 * @param points
	 */
	@SuppressWarnings("null")
	public Card(String name, String saga, String img, String alt, String type, Ability ability, Integer hp, Integer atk, Integer def, Integer mag_atk, Integer mag_def, Integer spd, Integer stars) {
		this.name = name;
		this.saga = saga;
		this.img = img;
		this.alt = alt;
		this.type = type;
		this.ability = ability;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.mag_atk = mag_atk;
		this.mag_def = mag_def;
		this.spd = spd;
		this.stars = stars;
	}
	
	/*
	 * @brief Getters and setters
	 */
	public Integer getCard_id() {
		return card_id;
	}

	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSaga() {
		return saga;
	}

	public void setSaga(String saga) {
		this.saga = saga;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getAtk() {
		return atk;
	}

	public void setAtk(Integer atk) {
		this.atk = atk;
	}

	public Integer getDef() {
		return def;
	}

	public void setDef(Integer def) {
		this.def = def;
	}

	public Integer getMag_atk() {
		return mag_atk;
	}

	public void setMag_atk(Integer mag_atk) {
		this.mag_atk = mag_atk;
	}

	public Integer getMag_def() {
		return mag_def;
	}

	public void setMag_def(Integer mag_def) {
		this.mag_def = mag_def;
	}

	public Integer getSpd() {
		return spd;
	}

	public void setSpd(Integer spd) {
		this.spd = spd;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public Set<UserCardMap> getUserCardMaps() {
		return userCardMaps;
	}

	public void setUserCardMaps(Set<UserCardMap> userCardMaps) {
		this.userCardMaps = userCardMaps;
	}

	public Set<DeckCardMap> getDeckCardMaps() {
		return deckCardMaps;
	}

	public void setDeckCardMaps(Set<DeckCardMap> deckCardMaps) {
		this.deckCardMaps = deckCardMaps;
	}

}