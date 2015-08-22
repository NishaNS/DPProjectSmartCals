/**
 * 
 */
package edu.scu.dp.smartcals.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.scu.dp.smartcals.constants.Constants;
import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.dao.impl.DaoFactory;
import edu.scu.dp.smartcals.dao.impl.OrderHistoryDaoImpl;
import edu.scu.dp.smartcals.dao.interfaces.OrderHistoryDao;
import edu.scu.dp.smartcals.dao.interfaces.VendingMachineDao;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.VendingMachineModel;
import edu.scu.dp.smartcals.vm.Beverage;
import edu.scu.dp.smartcals.vm.Candy;
import edu.scu.dp.smartcals.vm.Product;
import edu.scu.dp.smartcals.vm.Snack;
import edu.scu.dp.smartcals.vm.VendingMachine;
import edu.scu.dp.smartcals.vm.VendingMachineFactory;

/**
 * @author Aparna Ganesh Admin operations implementations
 */
public class AdminOperationsImpl implements AdminOperations, VMUpdateListener {

	/**
	 * Code change-Aparna - 8/18 Added Alert to notify Monitoring Station View
	 */
	private List<AlertListener> alertListeners;
	
	private OrderHistoryDao orderHistoryDao;
	
	private VendingMachineDao vendingMachineDao;

	public AdminOperationsImpl() {
		alertListeners = new ArrayList<>();
		orderHistoryDao = DaoFactory.getOrderHistoryDao();
		vendingMachineDao = DaoFactory.getVendingMachineDao();
		
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


/**
 * Returns best selling products 
 * @throws SQLException 
 */
	@Override
	public List<Product> getBestSellingProduct(long vmId) throws SQLException {
		
		List<Product> products = new ArrayList<>();		
		List<ProductModel> productModels = orderHistoryDao.getBestSellingProduct(vmId);
		
		VMLocationType type;
		try {
			type = vendingMachineDao.getVendingMachineType(vmId);
		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}
		VendingMachineFactory vendingMachineFactory = VendingMachineFactory.getFactory(type);
		
		for (ProductModel productModel : productModels) {

			switch (productModel.getCategory()) {
			case BEVERAGE:
				Beverage beverage = vendingMachineFactory.createBreverage(productModel);
				products.add(beverage);
				
				break;
			case CANDY:
				Candy candy = vendingMachineFactory.createCandy(productModel);
				products.add(candy);
				break;
			case SNACK:
				Snack snack = vendingMachineFactory.createSnack(productModel);
				products.add(snack);
				break;

			}
		}
		
		return products;
	}

}
