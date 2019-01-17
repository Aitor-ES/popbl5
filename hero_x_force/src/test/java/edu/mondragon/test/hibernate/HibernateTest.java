package edu.mondragon.test.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
@ContextConfiguration(
		  classes = { HibernateTestConfig.class }, 
		  loader = AnnotationConfigContextLoader.class)
@Transactional
public class HibernateTest {
	
	@Autowired
    private TestEntityService testEntityService;

	@Test
	public void insertValueThenGetItBack() {
		TestEntity testEntity = new TestEntity(1, "Paco");
		testEntityService.addTestEntity(testEntity);
         
        testEntity = testEntityService.getTestEntityById(1);
        assertEquals("Paco", testEntity.getDescription());
	}
	
	@Test
	public void insertValueAndUpdateThenGetItBack() {
		TestEntity testEntity = new TestEntity(2, "Josefa");
		testEntityService.addTestEntity(testEntity);
		
		testEntity.setDescription("Pepita");
		testEntityService.updateTestEntity(testEntity);
         
		testEntity = testEntityService.getTestEntityById(2);
        assertNotEquals("Josefa", testEntity.getDescription());
        assertEquals("Pepita", testEntity.getDescription());
	}
}
