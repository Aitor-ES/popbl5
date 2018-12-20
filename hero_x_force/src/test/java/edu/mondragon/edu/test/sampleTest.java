package edu.mondragon.edu.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.mondragon.model.User;

public class sampleTest {
	// Instance of the class under test
	static User myClass;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Create the instance
		myClass = new User();
	}

	@Test
	public void testString() {
		assertEquals("example", "example", "example");
	}	
}