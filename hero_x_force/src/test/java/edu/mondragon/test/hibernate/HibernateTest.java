/**
 * @file HibernateTest.java
 * @brief Class to test Hibernate integration
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.test.hibernate
 */

package edu.mondragon.test.hibernate;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import edu.mondragon.test.configuration.HibernateTestConfig;
import edu.mondragon.test.entity.TestEntity;
import edu.mondragon.test.entity.TestEntityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateTestConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class HibernateTest {

	/**
	 * @brief Hibernate services
	 */
	@Autowired
	private TestEntityService testEntityService;

	/**
	 * @brief Method to test DB inserts and gets
	 */
	@Test
	public void insertValueThenGetItBackAndAssertEquals() {
		TestEntity testEntity = new TestEntity(1, "Paco");
		testEntityService.addTestEntity(testEntity);

		testEntity = testEntityService.getTestEntityById(testEntity.getId());
		assertEquals("Paco", testEntity.getDescription());
	}

	/**
	 * @brief Method to test DB inserts, updates and gets
	 */
	@Test
	public void insertAndUpdateValueThenGetItBackAndAssertEquals() {
		TestEntity testEntity = new TestEntity(2, "Josefa");
		testEntityService.addTestEntity(testEntity);

		testEntity.setDescription("Pepita");
		testEntityService.updateTestEntity(testEntity);

		testEntity = testEntityService.getTestEntityById(testEntity.getId());
		assertNotEquals("Josefa", testEntity.getDescription());
		assertEquals("Pepita", testEntity.getDescription());
	}

	/**
	 * @brief Method to test DB deletes
	 */
	@Test
	public void insertAndRemoveValueThenCheckIfExists() {
		TestEntity testEntity = new TestEntity(3, "José");
		testEntityService.addTestEntity(testEntity);
		testEntityService.removeTestEntity(testEntity);
		assertNull(testEntityService.getTestEntityById(testEntity.getId()));
	}

	/**
	 * @brief Method to test DB list getting
	 */
	@Test
	public void insertValuesThenGetAsListAndAssertThatListContainsValues() {
		TestEntity testEntity1 = new TestEntity(4, "Pilar");
		testEntityService.addTestEntity(testEntity1);

		TestEntity testEntity2 = new TestEntity(5, "Natividad");
		testEntityService.addTestEntity(testEntity2);

		List<TestEntity> testEntityList = testEntityService.listTestEntities();
		assertThat(testEntityList, hasItems(testEntity1, testEntity2));
	}
}
