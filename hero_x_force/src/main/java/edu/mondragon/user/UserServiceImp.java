/**
 * @file UserserviceImp.java
 * @brief Class to implement the user service and manage the user dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.deck.Deck;
import edu.mondragon.match.Match;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;

@Service
public class UserServiceImp implements UserService {

	/**
	 * @brief User dao object
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * @brief Method to add users to the dao
	 * @param user User object
	 * @return void
	 */
	@Transactional
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	/**
	 * @brief Method to update users from the dao
	 * @param user User object
	 * @return void
	 */
	@Transactional
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	/**
	 * @bried This method removes a user from the dao
	 * @param user User object
	 * @return void
	 */
	@Transactional
	@Override
	public void removeUser(User user) {
		userDao.removeUser(user);
	}

	/**
	 * @brief Method to obtain the users from the dao
	 * @return List<User>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	/**
	 * @brief Method to obtain the user using the id from the dao
	 * @param userId User id int
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	/**
	 * @brief Method to obtain the user using the name from the dao
	 * @param name User name string
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

	/**
	 * @brief Method to obtain the user using the email from the dao
	 * @param email Users email
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	/**
	 * @brief Method to get user achievements
	 * @param userId User id
	 * @return Set<UserAchievementMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public Set<UserAchievementMap> getUserAchievements(int userId) {
		return userDao.getUserAchievements(userId);
	}

	/**
	 * @brief Method to get user cards
	 * @param userId User id
	 * @return Set<UserCardMap>
	 */
	@Transactional(readOnly = true)
	@Override
	public Set<UserCardMap> getUserCards(int userId) {
		return userDao.getUserCards(userId);
	}

	/**
	 * @brief Method to get user decks
	 * @param userId User id
	 * @return Set<Deck>
	 */
	@Transactional(readOnly = true)
	@Override
	public Set<Deck> getUserDecks(int userId) {
		return userDao.getUserDecks(userId);
	}

	/**
	 * @brief Method to get user matches as user1
	 * @param userId User id
	 * @return Set<Match>
	 */
	@Transactional(readOnly = true)
	@Override
	public Set<Match> getMatchesAsUser1(int userId) {
		return userDao.getMatchesAsUser1(userId);
	}

	/**
	 * @brief Method to get user matches as user2
	 * @param userId User id
	 * @return Set<Match>
	 */
	@Transactional(readOnly = true)
	@Override
	public Set<Match> getMatchesAsUser2(int userId) {
		return userDao.getMatchesAsUser2(userId);
	}
}