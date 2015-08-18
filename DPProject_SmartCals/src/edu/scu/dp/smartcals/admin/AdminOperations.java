/**
 * 
 */
package edu.scu.dp.smartcals.admin;

import edu.scu.dp.smartcals.vm.Product;

/**
 * @author Aparna Ganesh
 * Interface to define Admin operations
 */
public interface AdminOperations {

	public void reStockProduct(long vmId,long productId,int quantity);
	
	public void addNewProduct(Product product,long vmId);
}
