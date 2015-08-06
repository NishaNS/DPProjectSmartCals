package abstractfactory;

/**
 * @author Nisha Narayanaswamy
 * 
 * Product Model
 *
 */
public abstract class Product {
	
	private String prodCategory;
	private String productName;
	private long productID;
	private String productPrice;
	private long itemCode;
	
	public abstract void getCategory();
	public abstract void setCategory();
	
	public abstract void getName();
	public abstract void setName();
	
	public abstract void getPrice();
	public abstract void setPrice();
	
	public abstract void getItemCode();
	public abstract void setItemCode();
	
	public abstract void getImage();
	public abstract void setImage();
	
	public abstract void getNutriInfo(long prodID);
	public abstract void setNutriInfo(long prodID);

}
