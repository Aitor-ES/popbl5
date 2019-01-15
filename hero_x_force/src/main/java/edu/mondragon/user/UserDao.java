/**
 * @file UserDao.java
 * @brief This class is the interface for the Dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.dao
 */

package edu.mondragon.user;

import java.util.List;
import java.util.Set;

import edu.mondragon.deck.Deck;
import edu.mondragon.match.Match;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;

public interface UserDao {
	/**
	 * @brief This method adds an user
	 * @param user User object
	 * @return void
	 */
	void addUser(User user);

	/**
	 * @brief This method updates a user
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * @bried This method removes a user
	 * @param user
	 */
	void removeUser(User user);

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<User>
	 */
	List<User> listUsers();

	/**
	 * @brief Method to find a user using the id
	 * @param user_id Users id
	 * @return User
	 */
	User getUserById(int user_id);

	/**
	 * @brief Method to find a user using the username
	 * @param name Users name
	 * @return User
	 */
	User getUserByName(String name);

	/**
	 * @brief Method to find user using the email
	 * @param email
	 * @return
	 */
	User getUserByEmail(String email);

	/**
	 * @brief Method to find a user using the email
	 * @param email Users email
	 * @return User
	 */
	Set<UserAchievementMap> getUserAchievements(int user_id);

	/**
	 * @brief
	 * @param user_id
	 * @return
	 */
	Set<UserCardMap> getUserCards(int user_id);

	/**
	 * @brief
	 * @param user_id
	 * @return
	 */
	Set<Deck> getUserDecks(int user_id);

	/**
	 * @brief
	 * @param user_id
	 * @return
	 */
	Set<Match> getMatchesAsUser_1(int user_id);

	/**
	 * @brief
	 * @param user_id
	 * @return
	 */
	Set<Match> getMatchesAsUser_2(int user_id);
}