package edu.mondragon.test.entity;

import java.util.List;

public interface TestEntityDao {
	/**
	 * @brief This method adds an user
	 * @param user User object
	 * @return void
	 */
	void addTestEntity(TestEntity testEntity);

	/**
	 * @brief This method updates a user
	 * @param user
	 */
	void updateTestEntity(TestEntity testEntity);

	/**
	 * @bried This method removes a user
	 * @param user
	 */
	void removeTestEntity(TestEntity testEntity);

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<TestEntity>
	 */
	List<TestEntity> listTestEntities();

	/**
	 * @brief Method to find a user using the id
	 * @param user_id Users id
	 * @return User
	 */
	TestEntity getTestEntityById(long testEntity_id);
}
