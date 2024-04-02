/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Management company test cases
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

public class ManagementCompanyTestStudent {

	ManagementCompany mgmtCompany; 
	
	@Before
	public void setUp() throws Exception {
		mgmtCompany = new ManagementCompany("Railey", "555555555",6);
	}

	@After
	public void tearDown() throws Exception {
		mgmtCompany = null;
	}

	private Property getTestProperty(int x, int y) {return getTestProperty(x, y, 100);}
	
	private Property getTestProperty(int x, int y, double rent) {
		return new Property ("Sunsational", "Beckman", rent, "BillyBob Wilson",x,y,1,2);	
	}
	
	@Test
	public void testFee() {
		assertEquals(mgmtCompany.isMangementFeeValid(), true); //fee is between 0 and 100
		assertEquals(mgmtCompany.getFeePercentage(), 6.0, 0.01); //fee is what we set in setup
	}
	
	@Test
	public void testEditProperties() {
		//add one property
		assertEquals(mgmtCompany.addProperty(getTestProperty(0, 0)), 0);
		//add nine properties to fill array
		for(int i = 1; i < 5; i++) {
			int j = mgmtCompany.addProperty(getTestProperty(i, 0));
			System.out.println(j);
			assertEquals(j, i);
		}
		//fail to add a sixth property
		assertEquals(mgmtCompany.addProperty(getTestProperty(0, 2)), -1);
		
		//remove a property, check count to be sure
		mgmtCompany.removeLastProperty();
		assertEquals(mgmtCompany.getPropertiesCount(), 4);
		//try and fail to add overlap
		assertEquals(mgmtCompany.addProperty(getTestProperty(0,1)), -4);
		//try and fail to add property outside bounds
		assertEquals(mgmtCompany.addProperty(getTestProperty(12,12)), -3);
		//try and fail to add null property
		assertEquals(mgmtCompany.addProperty(null), -2);
	}
	
	@Test
	public void testPropertyRent() {
		//fill with properties
		double totalRent = 0;
		for(int i = 0; i < 5; i++) {
			double rent = (i + 5) * 100;
			mgmtCompany.addProperty(getTestProperty(i, 0, rent));
			totalRent += rent;
		}
		//get total rent check
		assertEquals(mgmtCompany.getTotalRent(), totalRent, 0.01);
		
		//ensure highest rent property matches the highest rent we assigned
		assertEquals(mgmtCompany.getHighestRentPropperty().getRentAmount(), 900, 0.01);
	}
	
	@Test
	public void testToString() {
		var sampleProperty = new Property ("TestProp", "Baltimore", 400.0, "Dave Jones",1,1,1,2);
		
		mgmtCompany.addProperty(sampleProperty);
		
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "TestProp,Baltimore,Dave Jones,400.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 24.0";
		assertEquals(expectedString, mgmtCompany.toString());
				
	}

}
