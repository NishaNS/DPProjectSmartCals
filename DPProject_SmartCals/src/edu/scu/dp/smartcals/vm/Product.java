package edu.scu.dp.smartcals.vm;


/**
 * @author Aparna Ganesh
 * 
 * Product Class to hold Product attributes
 *
 */
public abstract class Product {
	
	private String prodCategory;
	private String productName;
	private long productID;
	private double productPrice;
	
	
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
