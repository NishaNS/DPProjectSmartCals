package edu.scu.dp.smartcals.model;

/**
 * @author Nisha Narayanaswamy
 * 
 * NutritionalInfo Model
 *
 */
public class NutritionalInfo {
	
	//Builder design Pattern to be applied
	//only getter methods added so far ****** setter methods required for Admin
	
	private long productID;	
	
	private String calories;
	
	public long getProductID() {
		return productID;
	}
	
	public void setProductID(long prodID) {
		this.productID = prodID;
	}

	public String getCalories() {
		return calories;
	}
	
	public void setCalories(String calories) {
		this.calories = calories;
	}

	

}
