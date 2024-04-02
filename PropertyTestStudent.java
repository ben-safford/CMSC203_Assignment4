/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Property testCases
 * Due: 4/1/24
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ben Safford
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertyTestStudent {

	Property testProp;
	
	@Before
	public void setUp() throws Exception {
		testProp = new Property ("TestProp", "Baltimore", 400.0, "Dave Jones",1,1,1,2);
	}

	@After
	public void tearDown() throws Exception {
		testProp = null;
	}

	@Test
	public void testToString() {
		assertTrue(testProp.toString().equals("TestProp,Baltimore,Dave Jones,400.0"));
	}

}
