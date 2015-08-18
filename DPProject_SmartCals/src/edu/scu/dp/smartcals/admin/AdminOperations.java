/**
 * 
 */
package edu.scu.dp.smartcals.admin;

import edu.scu.dp.smartcals.vm.Product;

/**
 * @author Aparna Ganesh
 *
 */
public interface AdminOperations {

	public void reStockProduct(long vmId,long productId,int quantity);
	
	public void addNewProduct(Product product,long vmId);
}
