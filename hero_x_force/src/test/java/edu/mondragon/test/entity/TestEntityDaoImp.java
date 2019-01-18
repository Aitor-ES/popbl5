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
	 * @brief This method adds a user
	 * @param user User object
	 * @return void
	 */
	@Override
	public void addTestEntity(TestEntity testEntity) {
		getCurrentSession().save(testEntity);
	}

	/**
	 * @brief This method update a user
	 * @param user User object
	 * @return void
	 */
	@Override
	public void updateTestEntity(TestEntity testEntity) {
		getCurrentSession().update(testEntity);
	}

	/**
	 * @bried This method removes a user
	 * @param user
	 */
	@Override
	public void removeTestEntity(TestEntity testEntity) {
		getCurrentSession().remove(testEntity);
	}

	/**
	 * @brief Method to obtain the list of users that are in database
	 * @return List<TestEntity>
	 */
	@Override
	public List<TestEntity> listTestEntities() {
		@SuppressWarnings("unchecked")
		TypedQuery<TestEntity> query = getCurrentSession().createQuery("FROM TestEntity");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a user using the id
	 * @param id Users id
	 * @return User
	 */
	@Override
	public TestEntity getTestEntityById(long testEntity_id) {
		TestEntity user = getCurrentSession().find(TestEntity.class, testEntity_id);
		return user;
	}

}