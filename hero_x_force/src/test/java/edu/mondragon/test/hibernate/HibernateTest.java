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

	@Autowired
	private TestEntityService testEntityService;

	@Test
	public void insertValueThenGetItBackAndAssertEquals() {
		TestEntity testEntity = new TestEntity(1, "Paco");
		testEntityService.addTestEntity(testEntity);

		testEntity = testEntityService.getTestEntityById(testEntity.getId());
		assertEquals("Paco", testEntity.getDescription());
	}

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

	@Test
	public void insertAndRemoveValueThenCheckIfExists() {
		TestEntity testEntity = new TestEntity(3, "José");
		testEntityService.addTestEntity(testEntity);
		testEntityService.removeTestEntity(testEntity);
		assertNull(testEntityService.getTestEntityById(testEntity.getId()));
	}

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
