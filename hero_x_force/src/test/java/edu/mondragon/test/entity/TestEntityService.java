/**
 * @file TestEntityService.java
 * @brief The test entity service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.test.entity
 */

package edu.mondragon.test.entity;

import java.util.List;

public interface TestEntityService {
	/**
	 * @brief This method adds a test entity
	 * @param testEntity test entity object
	 * @return void
	 */
	void addTestEntity(TestEntity testEntity);

	/**
	 * @brief This method update a test entity
	 * @param testEntity test entity object
	 * @return void
	 */
	void updateTestEntity(TestEntity testEntity);

	/**
	 * @bried This method removes a test entity
	 * @param testEntity test entity object
	 * @return void
	 */
	void removeTestEntity(TestEntity testEntity);

	/**
	 * @brief Method to obtain the list of test entities that are in database
	 * @return List<TestEntity>
	 */
	List<TestEntity> listTestEntities();

	/**
	 * @brief Method to find a test entity using the id
	 * @param testEntityId test entity id
	 * @return TestEntity
	 */
	TestEntity getTestEntityById(long testEntityId);

}