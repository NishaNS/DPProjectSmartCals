/**
 * 
 */
package edu.scu.dp.smartcals.admin;

import java.util.ArrayList;
import java.util.List;

import edu.scu.dp.smartcals.constants.Constants;
import edu.scu.dp.smartcals.vm.Product;

/**
 * @author Aparna Ganesh Admin operations implementations
 */
public class AdminOperationsImpl implements AdminOperations, VMUpdateListener {

	/**
	 * Code change-Aparna - 8/18 Added Alert to notify Monitoring Station View
	 */
	private List<AlertListener> alertListeners;

	public AdminOperationsImpl() {
		alertListeners = new ArrayList<>();
	}

	public void addAlertListeners(AlertListener alertListener) {

		alertListeners.add(alertListener);

	}

	public void sendOutOfStockAlert(long vmId, long productId) {

		Alert alert = new OutOfStockAlert();

		alert.addProperty(Constants.PRODUCT_ID_KEY, productId + "");
		alert.addProperty(Constants.VM_ID_KEY, vmId + "");

		for (AlertListener alertListener : alertListeners) {
			alertListener.update(alert);
		}
	}

	// -------------code change-Aparna 8/18

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
		// notify MonitoringStationView
		 System.out.println("The product " +productId +" for the VM "+vmId + " is out of Stock");
		 sendOutOfStockAlert(vmId, productId);
	}

}
