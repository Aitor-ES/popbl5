package edu.mondragon.edu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.mondragon.user.User;

public class sampleTest {
	// Instance of the class under test
	static User myClass;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		// Create the instance
		myClass = new User();
	}

	@Test
	public void testString() {
		assertEquals("example", "example", "example");
	}
}