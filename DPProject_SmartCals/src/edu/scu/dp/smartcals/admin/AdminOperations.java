/**
 * 
 */
package edu.scu.dp.smartcals.admin;

import java.sql.SQLException;
import java.util.List;

import edu.scu.dp.smartcals.exception.AdminOperationsException;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.vm.Product;
import edu.scu.dp.smartcals.vm.VendingMachine;

/**
 * @author Aparna Ganesh
 * Interface to define Admin operations
 */
public interface AdminOperations {

	public void reStockProduct(long vmId,long productId,int quantity);
	
	public void addNewProduct(Product product,long vmId);
	
	public List<Product> getBestSellingProduct(long vmId) throws AdminOperationsException;
}
