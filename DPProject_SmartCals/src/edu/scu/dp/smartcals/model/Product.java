/**
 * 
 */
package edu.scu.dp.smartcals.model;

/**
 * Product Model
 * @author Aparna Ganesh
 *
 */
public class Product {

	//TODO add more product attributes here
	private long productId;
	
	private String productName;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	} 
}
