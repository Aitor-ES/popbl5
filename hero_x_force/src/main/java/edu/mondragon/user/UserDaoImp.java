/**
 * @file UserDaoImp.java
 * @brief This class manages the database
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
	 * @param user
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
	 * @param id Users id
	 * @return User
	 */
	@Override
	public User getUserById(int user_id) {
		User user = getCurrentSession().find(User.class, user_id);
		return user;
	}

	/**
	 * @brief Method to find a user using the username
	 * @param name Users name
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
	 * @param email Users email
	 * @return User
	 */
	@Override
	public User getUserByEmail(String email) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = getCurrentSession()
				.createQuery("FROM User As user WHERE user.email = '" + email + "'");
		return query.getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public Set<UserAchievementMap> getUserAchievements(int user_id) {
		User user = getCurrentSession().find(User.class, user_id);
		return user.getUserAchievementMaps();
	}

	@Override
	public Set<UserCardMap> getUserCards(int user_id) {
		User user = getCurrentSession().find(User.class, user_id);
		return user.getUserCardMaps();
	}

	@Override
	public Set<Deck> getUserDecks(int user_id) {
		User user = getCurrentSession().find(User.class, user_id);
		return user.getDecks();
	}

	@Override
	public Set<Match> getMatchesAsUser_1(int user_id) {
		User user = getCurrentSession().find(User.class, user_id);
		return user.getMatchesAsUser_1();
	}

	@Override
	public Set<Match> getMatchesAsUser_2(int user_id) {
		User user = getCurrentSession().find(User.class, user_id);
		return user.getMatchesAsUser_2();
	}
}