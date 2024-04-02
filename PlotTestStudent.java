/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Plot test cases
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

public class PlotTestStudent {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test //simple overlap test. one plot to test with, a plot that overlaps, and one that doesn't
	public void testOverlap() {
		Plot pTest = new Plot(1,1,2,2);
		Plot pOverlapYes = new Plot(2,1,2,2); 
		Plot pOverlapNo = new Plot(4,1,2,2);
		assertTrue(pTest.overlaps(pOverlapYes));
		assertFalse(pTest.overlaps(pOverlapNo));
	}
	
	@Test //simple overlap test. one plot to test with, a plot that it contains, and one that it doesn't
	public void testContains() {
		Plot pTest = new Plot(1,1,5,5);
		Plot pContainYes = new Plot(2,2,2,2); 
		Plot pContainNo = new Plot(5,1,4,2);
		assertTrue(pTest.contains(pContainYes));
		assertFalse(pTest.contains(pContainNo));
	}

}
