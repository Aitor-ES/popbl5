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
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.service;

import java.util.List;

import edu.mondragon.model.User;

public interface UserService {
	
	/**
	 * @brief This method adds an user
	 * @param user User object
	 * @return void
	 */
	void add(User user);

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<User>
	 */
	List<User> listUsers();

	/**
	 * @brief Method to find a user using the id
	 * @param id Users id
	 * @return User
	 */
	User getUserById(long id);
	
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
}