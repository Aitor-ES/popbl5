/**
 * @file UserserviceImp.java
 * @brief Class to manage the user dao
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

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.deck.Deck;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;
import edu.mondragon.usermatchmap.UserMatchMap;

@Service
public class UserServiceImp implements UserService {

	/**
	 * @brief user dao object
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
	 * @param id Users id
	 * @return User
	 */
	@Transactional(readOnly = true)
	@Override
	public User getUserById(int user_id) {
		return userDao.getUserById(user_id);
	}
	
	/**
	 * @brief Method to obtain the user using the name from the dao
	 * @param name Users name
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

	@Transactional(readOnly = true)
	@Override
	public Set<UserAchievementMap> getUserAchievements(int user_id) {
		return userDao.getUserAchievements(user_id);
	}

	@Transactional(readOnly = true)
	@Override
	public Set<UserCardMap> getUserCards(int user_id) {
		return userDao.getUserCards(user_id);
	}

	@Transactional(readOnly = true)
	@Override
	public Set<Deck> getUserDecks(int user_id) {
		return userDao.getUserDecks(user_id);
	}

	@Transactional(readOnly = true)
	@Override
	public Set<UserMatchMap> getUser_1_matches(int user_id) {
		return userDao.getUser_1_matches(user_id);
	}

	@Transactional(readOnly = true)
	@Override
	public Set<UserMatchMap> getUser_2_matches(int user_id) {
		return userDao.getUser_2_matches(user_id);
	}
}