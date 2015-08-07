package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.Product;

/**
 * Data Access Object for Product
 * @author Aparna Ganesh
 *
 */
public interface ProductDao {
	
	/**
	 * Returns the product for the given productId 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws EmptyResultException 
	 */
	public Product getProductById(long id) throws SQLException, EmptyResultException;
	
	public void addProduct(Product product) throws SQLException;
	
	public void updateProduct(Product product) throws SQLException;
	
	public List<Product> getProductByCalorieRange(int low, int high) throws SQLException;
	
	public List<Product> getProductBySmartTag(List<String> smartTags) throws SQLException;
	
//TODO getProductByCategory(Catergory category) // fetch all the producst in all categories store it in hashmap and 
	//when the user loads VM fetch from the map (in-momeory)

}
