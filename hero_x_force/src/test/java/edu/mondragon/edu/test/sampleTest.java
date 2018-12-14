package edu.mondragon.edu.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.mondragon.app.Main;

public class sampleTest {
	// Instance of the class under test
	static Main myClass;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Create the instance
		myClass = new Main();
	}

	@Test
	public void testString() {
		assertEquals("example", "example", "example");
	}	
}