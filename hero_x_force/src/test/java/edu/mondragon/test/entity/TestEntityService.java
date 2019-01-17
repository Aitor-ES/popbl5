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

package edu.mondragon.test.entity;

import java.util.List;

public interface TestEntityService {
	/**
	 * @brief This method adds an user
	 * @param user User object
	 * @return void
	 */
	void addTestEntity(TestEntity testEntity);

	/**
	 * @brief This method update a user
	 * @param user User object
	 * @return void
	 */
	void updateTestEntity(TestEntity testEntity);

	/**
	 * @bried This method removes a user
	 * @param user
	 * @return void
	 */
	void removeTestEntity(TestEntity testEntity);

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<User>
	 */
	List<TestEntity> listTestEntities();

	/**
	 * @brief Method to find a user using the id
	 * @param user_id Users id
	 * @return User
	 */
	TestEntity getTestEntityById(long testEntity_id);

}