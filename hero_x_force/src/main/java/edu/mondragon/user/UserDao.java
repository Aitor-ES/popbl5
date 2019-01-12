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
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;
import edu.mondragon.usermatchmap.UserMatchMap;

public interface UserDao {
	void addUser(User user);

	List<User> listUsers();

	User getUserById(int user_id);
	User getUserByName(String name);
	User getUserByEmail(String email);
	
	Set<UserAchievementMap> getUserAchievements(int user_id);
	Set<UserCardMap> getUserCards(int user_id);
	Set<Deck> getUserDecks(int user_id);
	Set<UserMatchMap> getUser_1_matches(int user_id);
	Set<UserMatchMap> getUser_2_matches(int user_id);
}