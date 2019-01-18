/**
 * @file UserService.java
 * @brief The user service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
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
	 * @brief This method adds a user
	 * @param user User object
	 * @return void
	 */
	void addUser(User user);

	/**
	 * @brief This method updates a user
	 * @param user User object
	 * @return void
	 */
	void updateUser(User user);

	/**
	 * @bried This method removes a user
	 * @param user User object
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
	 * @param name User name string
	 * @return User
	 */
	User getUserByName(String name);

	/**
	 * @brief Method to find user using the email
	 * @param email User email string
	 * @return User
	 */
	User getUserByEmail(String email);

	/**
	 * @brief Method to get user achievements
	 * @param userId User id
	 * @return Set<UserAchievementMap>
	 */
	Set<UserAchievementMap> getUserAchievements(int userId);

	/**
	 * @brief Method to get user cards
	 * @param userId User id
	 * @return Set<UserCardMap>
	 */
	Set<UserCardMap> getUserCards(int userId);

	/**
	 * @brief Method to get user decks
	 * @param userId User id
	 * @return Set<Deck>
	 */
	Set<Deck> getUserDecks(int userId);

	/**
	 * @brief Method to get user matches as user1
	 * @param userId User id
	 * @return Set<Match>
	 */
	Set<Match> getMatchesAsUser1(int userId);

	/**
	 * @brief Method to get user matches as user2
	 * @param userId User id
	 * @return Set<Match>
	 */
	Set<Match> getMatchesAsUser2(int userId);
}