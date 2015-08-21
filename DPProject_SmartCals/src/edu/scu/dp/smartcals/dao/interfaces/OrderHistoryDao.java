/**
 * 
 */
package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.ProductModel;

/**
 * @author Aparna Ganesh
 *
 */
public interface OrderHistoryDao {
	
	public List<ProductModel> getBestSellingProduct(long vmId) throws SQLException;

}
