/**
 * @file UserDaoImp.java
 * @brief This class implements the user dao interface
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

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mondragon.deck.Deck;
import edu.mondragon.match.Match;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;

@Repository
public class UserDaoImp implements UserDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @brief This method adds a user
	 * @param user User object
	 * @return void
	 */
	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);
	}

	/**
	 * @brief This method update a user
	 * @param user User object
	 * @return void
	 */
	@Override
	public void updateUser(User user) {
		getCurrentSession().update(user);
	}

	/**
	 * @bried This method removes a user
	 * @param user User object
	 * @return void
	 */
	@Override
	public void removeUser(User user) {
		getCurrentSession().remove(user);
	}

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<User>
	 */
	@Override
	public List<User> listUsers() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = getCurrentSession().createQuery("FROM User");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a user using the id
	 * @param userId User id int
	 * @return User
	 */
	@Override
	public User getUserById(int userId) {
		return getCurrentSession().find(User.class, userId);
	}

	/**
	 * @brief Method to find a user using the username
	 * @param name Users name string
	 * @return User
	 */
	@Override
	public User getUserByName(String name) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = getCurrentSession()
				.createQuery("FROM User AS user WHERE user.username = '" + name + "'");
		return query.getResultList().stream().findFirst().orElse(null);
	}

	/**
	 * @brief Method to find a user using the email
	 * @param email Users email string
	 * @return User
	 */
	@Override
	public User getUserByEmail(String email) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = getCurrentSession()
				.createQuery("FROM User As user WHERE user.email = '" + email + "'");
		return query.getResultList().stream().findFirst().orElse(null);
	}

	/**
	 * @brief Method to get user achievements
	 * @param userId User id
	 * @return Set<UserAchievementMap>
	 */
	@Override
	public Set<UserAchievementMap> getUserAchievements(int userId) {
		User user = getCurrentSession().find(User.class, userId);
		return user.getUserAchievementMaps();
	}

	/**
	 * @brief Method to get user cards
	 * @param userId User id
	 * @return Set<UserCardMap>
	 */
	@Override
	public Set<UserCardMap> getUserCards(int userId) {
		User user = getCurrentSession().find(User.class, userId);
		return user.getUserCardMaps();
	}

	/**
	 * @brief Method to get user decks
	 * @param userId User id
	 * @return Set<Deck>
	 */
	@Override
	public Set<Deck> getUserDecks(int userId) {
		User user = getCurrentSession().find(User.class, userId);
		return user.getDecks();
	}

	/**
	 * @brief Method to get user matches as user1
	 * @param userId User id
	 * @return Set<Match>
	 */
	@Override
	public Set<Match> getMatchesAsUser1(int userId) {
		User user = getCurrentSession().find(User.class, userId);
		return user.getMatchesAsUser1();
	}

	/**
	 * @brief Method to get user matches as user2
	 * @param userId User id
	 * @return Set<Match>
	 */
	@Override
	public Set<Match> getMatchesAsUser2(int userId) {
		User user = getCurrentSession().find(User.class, userId);
		return user.getMatchesAsUser2();
	}
}