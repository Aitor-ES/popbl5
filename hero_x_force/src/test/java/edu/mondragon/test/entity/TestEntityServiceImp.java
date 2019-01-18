/**
 * @file TestEntityServiceImp.java
 * @brief Class to implement the test entity service and manage the test entity dao
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestEntityServiceImp implements TestEntityService {

	/**
	 * @brief testEntity dao object
	 */
	@Autowired
	private TestEntityDao testEntityDao;

	/**
	 * @brief Method to add testEntities to the dao
	 * @param testEntity TestEntity object
	 * @return void
	 */
	@Transactional
	@Override
	public void addTestEntity(TestEntity testEntity) {
		testEntityDao.addTestEntity(testEntity);
	}

	/**
	 * @brief Method to update testEntities from the dao
	 * @param testEntity TestEntity object
	 * @return void
	 */
	@Transactional
	@Override
	public void updateTestEntity(TestEntity testEntity) {
		testEntityDao.updateTestEntity(testEntity);
	}

	/**
	 * @bried This method removes a testEntity from the dao
	 * @param testEntity TestEntity object
	 * @return void
	 */
	@Transactional
	@Override
	public void removeTestEntity(TestEntity testEntity) {
		testEntityDao.removeTestEntity(testEntity);
	}

	/**
	 * @brief Method to obtain the testEntities from the dao
	 * @return List<TestEntity>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<TestEntity> listTestEntities() {
		return testEntityDao.listTestEntities();
	}

	/**
	 * @brief Method to obtain the testEntity using the id from the dao
	 * @param testEntityId test entity id
	 * @return TestEntity
	 */
	@Transactional(readOnly = true)
	@Override
	public TestEntity getTestEntityById(long testEntityId) {
		return testEntityDao.getTestEntityById(testEntityId);
	}
	
}