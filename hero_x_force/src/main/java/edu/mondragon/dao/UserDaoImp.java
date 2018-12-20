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

package edu.mondragon.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mondragon.model.User;

@Repository
public class UserDaoImp implements UserDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds an user
	 * @param user User object
	 * @return void
	 */
	@Override
	public void add(User user) {
		getCurrentSession().save(user);
	}

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<User>
	 */
	@Override
	public List<User> listUsers() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = getCurrentSession().createQuery("FROM User");
		query.getSingleResult();
		return query.getResultList();
	}

	/**
	 * @brief Method to find a user using the id
	 * @param id Users id
	 * @return User
	 */
	@Override
	public User getUserById(long id) {
		User user = getCurrentSession().find(User.class, id);
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
		TypedQuery<User> query = getCurrentSession().createQuery("FROM User AS user WHERE user.firstName = '" + name + "'");
		return query.getResultList().stream().findFirst().orElse(null);
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}