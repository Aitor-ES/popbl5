/**
 * @file UserService.java
 * @brief The user service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.user
 */

package edu.mondragon.user;

import java.util.List;
import java.util.Set;

import edu.mondragon.deck.Deck;
import edu.mondragon.match.Match;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;

public interface UserService {
	/**
	 * @brief This method adds an user
	 * @param user User object
	 * @return void
	 */
	void addUser(User user);

	/**
	 * @brief This method update a user
	 * @param user User object
	 * @return void
	 */
	void updateUser(User user);

	/**
	 * @bried This method removes a user
	 * @param user
	 * @return void
	 */
	void removeUser(User user);

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<User>
	 */
	List<User> listUsers();

	/**
	 * @brief Method to find a user using the id
	 * @param userId User id int
	 * @return User
	 */
	User getUserById(int userId);

	/**
	 * @brief Method to find a user using the username
	 * @param name Users name
	 * @return User
	 */
	User getUserByName(String name);

	/**
	 * @brief Method to find a user using the email
	 * @param email Users email
	 * @return User
	 */
	User getUserByEmail(String email);

	/**
	 * @brief
	 * @param userId User id int
	 * @return
	 */
	Set<UserAchievementMap> getUserAchievements(int userId);

	/**
	 * @brief
	 * @param userId User id int
	 * @return
	 */
	Set<UserCardMap> getUserCards(int userId);

	/**
	 * @brief
	 * @param userId User id int
	 * @return
	 */
	Set<Deck> getUserDecks(int userId);

	/**
	 * @brief
	 * @param userId User id int
	 * @return
	 */
	Set<Match> getMatchesAsUser1(int userId);

	/**
	 * @brief
	 * @param userId User id int
	 * @return
	 */
	Set<Match> getMatchesAsUser2(int userId);
}