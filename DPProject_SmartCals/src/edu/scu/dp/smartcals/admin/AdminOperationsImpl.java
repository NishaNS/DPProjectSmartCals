/**
 * 
 */
package edu.scu.dp.smartcals.admin;

import edu.scu.dp.smartcals.vm.Product;

/**
 * @author Aparna Ganesh
 * Admin operations implementations
 */
public class AdminOperationsImpl implements AdminOperations,VMUpdateListener {

	
	@Override
	public void reStockProduct(long vmId, long productId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void addNewProduct(Product product, long vmId) {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void updateOutOfStock(long vmId, long productId) {
		
		System.out.println("The product " +productId +" for the VM "+vmId + " is out of Stock");
		
	}

}
