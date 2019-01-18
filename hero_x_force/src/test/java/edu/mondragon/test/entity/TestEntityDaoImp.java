/**
 * @file test entityDaoImp.java
 * @brief This class implements the test entity dao
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

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDaoImp implements TestEntityDao {

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
	 * @brief This method adds a test entity
	 * @param testEntity Test entity object
	 * @return void
	 */
	@Override
	public void addTestEntity(TestEntity testEntity) {
		getCurrentSession().save(testEntity);
	}

	/**
	 * @brief This method update a test entity
	 * @param testEntity test entity object
	 * @return void
	 */
	@Override
	public void updateTestEntity(TestEntity testEntity) {
		getCurrentSession().update(testEntity);
	}

	/**
	 * @bried This method removes a test entity
	 * @param testEntity test entity object
	 * @return void
	 */
	@Override
	public void removeTestEntity(TestEntity testEntity) {
		getCurrentSession().remove(testEntity);
	}

	/**
	 * @brief Method to obtain the list of test entities that are in the database
	 * @return List<TestEntity>
	 */
	@Override
	public List<TestEntity> listTestEntities() {
		@SuppressWarnings("unchecked")
		TypedQuery<TestEntity> query = getCurrentSession().createQuery("FROM TestEntity");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a test entity using the id
	 * @param testEntityId test entity id
	 * @return TestEntity
	 */
	@Override
	public TestEntity getTestEntityById(long testEntityId) {
		TestEntity testEntity = getCurrentSession().find(TestEntity.class, testEntityId);
		return testEntity;
	}

}