/**
 * @file User.java
 * @brief The user class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.user;

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

import edu.mondragon.deck.Deck;
import edu.mondragon.match.Match;
import edu.mondragon.tournament.Tournament;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;
import edu.mondragon.usermatchmap.UserMatchMap;
import edu.mondragon.usertournamentmap.UserTournamentMap;

@Entity
@Table(name = "USERS")
public class User {

	/**
	 * @brief User id (PK)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer user_id;

	/**
	 * @brief User name
	 */
	@Column(name = "USERNAME")
	private String username;

	/**
	 * @brief User email
	 */
	@Column(name = "EMAIL")
	private String email;

	/**
	 * @brief User password
	 */
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * @brief User wins
	 */
	@Column(name = "WINS")
	private Integer wins;

	/**
	 * @brief User loses
	 */
	@Column(name = "LOSES")
	private Integer loses;

	/**
	 * @brief User points
	 */
	@Column(name = "POINTS")
	private Integer points;

	/**
	 * @brief Deck list (FK)
	 */
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<Deck> decks = new HashSet<Deck>();
	
	/**
	 * @brief Matches list (FK)
	 */
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<Match> matches = new HashSet<Match>();
	
	/**
	 * @brief Tournament list (FK)
	 */
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<Tournament> tournaments = new HashSet<Tournament>();
	
	/**
	 * @brief UserTournamentMap list (FK)
	 */
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserTournamentMap> userTournamentMaps = new HashSet<UserTournamentMap>();	
	
	/**
	 * @brief UserMatchMap list (FK)
	 */
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserMatchMap> userMatchMaps = new HashSet<UserMatchMap>();
	
	/**
	 * @brief UserAchievementMap list (FK)
	 */
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserAchievementMap> userAchievementMaps = new HashSet<UserAchievementMap>();
	
	/**
	 * @brief UserCardMap list (FK)
	 */
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)	
	private Set<UserCardMap> userCardMaps = new HashSet<UserCardMap>();
	
	/**
	 * @brief Empty constructor
	 */
	public User() {
	}

	/**
	 * @brief Class constructor
	 * @param username Users name
	 * @param email    Users email
	 * @param password Users password
	 */
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	/*
	 * @brief Getters and setters
	 */
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLoses() {
		return loses;
	}

	public void setLoses(Integer loses) {
		this.loses = loses;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Set<Deck> getDecks() {
		return decks;
	}

	public void setDecks(Set<Deck> decks) {
		this.decks = decks;
	}

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public Set<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(Set<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Set<UserTournamentMap> getUserTournamentMaps() {
		return userTournamentMaps;
	}

	public void setUserTournamentMaps(Set<UserTournamentMap> userTournamentMaps) {
		this.userTournamentMaps = userTournamentMaps;
	}

	public Set<UserMatchMap> getUserMatchMaps() {
		return userMatchMaps;
	}

	public void setUserMatchMaps(Set<UserMatchMap> userMatchMaps) {
		this.userMatchMaps = userMatchMaps;
	}

	public Set<UserAchievementMap> getUserAchievementMaps() {
		return userAchievementMaps;
	}

	public void setUserAchievementMaps(Set<UserAchievementMap> userAchievementMaps) {
		this.userAchievementMaps = userAchievementMaps;
	}

	public Set<UserCardMap> getUserCardMaps() {
		return userCardMaps;
	}

	public void setUserCardMaps(Set<UserCardMap> userCardMaps) {
		this.userCardMaps = userCardMaps;
	}	
	
}