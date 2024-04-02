/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: Management company data manager
 * Due: 4/1/24
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ben Safford
*/

public class ManagementCompany {
	
	private String name;
	private String taxID;
	private double feePercentage;
	private Property[] properties;
	
	private Plot plot;
	
	public final int MAX_PROPERTY = 5;
	public final int MGMT_WIDTH = 10;
	public final int MGMT_DEPTH = 10;
	
	public ManagementCompany(String name, String taxID, double fee) {
		properties = new Property[MAX_PROPERTY];
		
		this.name = name;
		this.setTaxID(taxID);
		this.setFeePercentage(fee);
		
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public int addProperty(Property p) {
		if(isPropertiesFull())
			return -1;
		if(p == null)
			return -2;
		if(!plot.contains(p.getPlot()))
			return -3;
		int indexToAddAt = getPropertiesCount();
		for(int i = 0; i < indexToAddAt; i++) { //loop through all existing properties
			if(properties[i].getPlot().overlaps(p.getPlot()))
				return -4;
		}
		properties[indexToAddAt] = p;
		return indexToAddAt;
	}
	
	public void removeLastProperty() {
		properties[getPropertiesCount() - 1] = null;
	}
	
	public boolean isPropertiesFull() {
		return properties[properties.length - 1] != null;
	}
	
	public int getPropertiesCount() {
		for(int i = 0; i < properties.length; i++)
			if(properties[i] == null)
				return i;
		return properties.length;
	}
	
	public Property getHighestRentPropperty() {
		Property outP =  properties[0];
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) //more performant than using getPropertiesCount
				break;
			if(properties[i].getRentAmount() > outP.getRentAmount())
				outP = properties[i];
		}
		return outP;
	}
	
	public double getTotalRent() {
		double total = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) //more performant than using getPropertiesCount
				break;
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	public boolean isMangementFeeValid() {
		return 0 < feePercentage && feePercentage < 100;
	}
	
	public String getName() {return name;}
	public Plot getPlot() {return plot;}

	public String getTaxID() {
		return taxID;
	}
	
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public double getFeePercentage() {
		return feePercentage;
	}

	public void setFeePercentage(double feePercentage) {
		this.feePercentage = feePercentage;
	}
	
	public String toString() {
		return "List of the properties for " + name + ", taxID: " + taxID + "\n"
				+ "______________________________________________________\n"
				+ getPropertyList()
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: " + (getTotalRent() * feePercentage * 0.01);
	}
	
	private String getPropertyList() {
		String outString = "";
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null) //more performant than using getPropertiesCount
				break;
			outString += properties[i].toString() + "\n";
		}
		return outString;
	}
}
