/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Property data storage
 * Due: 4/1/24
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ben Safford
*/


public class Property {

	private String propertyName, city, owner;
	private Plot plot;
	private double rentAmount;
	
	String test2;
	
	public Property(String name, String city, double rentAmt, String owner) {
		propertyName = name;
		this.city = city;
		rentAmount = rentAmt;
		this.owner = owner;
	}
	
	public Property(String name, String city, double rentAmt, String owner, int px, int py, int pdx, int pdy) {
		this(name, city, rentAmt, owner);
		this.plot = new Plot(px, py, pdx, pdy);
		
		Object[] test = new java.util.Date[100];
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
}
