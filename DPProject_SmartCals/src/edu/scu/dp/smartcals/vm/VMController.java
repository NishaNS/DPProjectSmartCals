package edu.scu.dp.smartcals.vm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.scu.dp.smartcals.constants.ProductCategory;
import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.dao.impl.DaoFactory;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.dao.interfaces.VendingMachineDao;
import edu.scu.dp.smartcals.exception.DatabaseInitializationException;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.VendingMachineModel;
import edu.scu.dp.smartcals.ui.VMClient;
import edu.scu.dp.smartcals.ui.VMDetails_View;
import edu.scu.dp.smartcals.ui.VMProdCategory;
import edu.scu.dp.smartcals.ui.VMSelectionView;

/**
 * @author Aparna Ganesh
 * @author Nisha Narayanaswamy VMController class decides the views to be
 *         displayed on user action, delegates the call to required classes
 *
 */
public class VMController {

	private VendingMachineDao vendingMachineDao;

	private ProductDao productDao;
	
	//start - Nisha - 8/15
	
	private VMClient mainWindow;
	private VMSelectionView vmSelectionView;	
	
	//end - Nisha 8/15

	

	public VMController() {
		
		//start - Nisha - 8/15
		
		//launch in following sequence - JFrame, SelectionView..etc
		if(mainWindow == null)
			this.mainWindow = new VMClient();
		if(vmSelectionView == null)
			this.vmSelectionView = new VMSelectionView(this);
		
		//$$$$$$ add obj for other views here - only 1 obj per view in entire application $$$$$$
		
		//load first view from this page only 
		mainWindow.addPanels(vmSelectionView);
	
		//end - Nisha - 8/15	
		
		
		try {
			// TODO This factory intialize part shud be done only once for the
			// entire application. Do it where appl starts
			// for testing purpose its here
			DaoFactory.initialize();
		} catch (DatabaseInitializationException e) {
			
			e.printStackTrace();
		}
		//initializing the daos' used here
		vendingMachineDao = DaoFactory.getVendingMachineDao();
		productDao = DaoFactory.getProductDao();
	}
	
	//start - Nisha - 8/15 - new methods
	/**
	 * @return vendingMachineView Return the view holding the JFrame object
	 */
	public VMClient getView(){
		return mainWindow;
	}
	
	public VMSelectionView getSelectView(){
		return this.vmSelectionView;
	}
	
	//$$$$$$ add getter methods for other views here  $$$$$$
	
	//end - Nisha - 8/15

	/**
	 * Returns all the Vending Machines from Database to ViewAllVendingMachines
	 * user interface. Converting Vending Machine Model objects to Vending
	 * Machine objects
	 * 
	 * @return
	 */
	public List<VendingMachine> getAllVendingMachines() {
		List<VendingMachineModel> vendingMachineModels = null;
		List<VendingMachine> vendingMachines = new ArrayList<>();
		try {
			vendingMachineModels = vendingMachineDao.getAllVMBasicInfo();
		} catch (EmptyResultException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Collections.emptyList();
		}

		for (VendingMachineModel vmModel : vendingMachineModels) {

			VendingMachineFactory vendingMachineFactory = VendingMachineFactory.getFactory(vmModel.getType());
			VendingMachine vendingMachine = vendingMachineFactory.createVendingMachine(vmModel);
			vendingMachines.add(vendingMachine);
		}
		return vendingMachines;
	}

	/**
	 * Returns all the products for a given VM
	 * 
	 * @param vmId
	 * @return
	 */
	public VendingMachine getVendingMachine(long vmId) {

		assert (vmId != 0);

		VendingMachineModel vmModel;

		List<Beverage> beverages = new ArrayList<>();

		List<Candy> candies = new ArrayList<>();

		List<Snack> snacks = new ArrayList<>();

		try {
			vmModel = vendingMachineDao.getVendingMachine(vmId);
		} catch (SQLException | EmptyResultException e) {
			
			e.printStackTrace();
			return null;

		}
		
		VendingMachineFactory vendingMachineFactory = VendingMachineFactory.getFactory(vmModel.getType());

		VendingMachine vendingMachine = vendingMachineFactory.createVendingMachine(vmModel);

		List<ProductModel> productModels = vmModel.getProductModels();
System.out.println("Product Model contains "+productModels.toString());
		for (ProductModel productModel : productModels) {
			
			switch (productModel.getCategory()) {
			case BEVERAGE:
				Beverage breverage = vendingMachineFactory
				.createBreverage(productModel);
				beverages.add(breverage);
				break;
			case CANDY:
				Candy candy = vendingMachineFactory.createCandy(productModel);
				candies.add(candy);
				break;
			case SNACK:
				Snack snack = vendingMachineFactory.createSnack(productModel);
				snacks.add(snack);
				break;

			}
		}
		vendingMachine.setBeverages(beverages);
		vendingMachine.setCandies(candies);
		vendingMachine.setSnacks(snacks);

		return vendingMachine;

	}
	
	//start - Nisha - 8/15
	public static void main(String[] args){
		new VMController();
	}
	//end - Nisha - 8/15

}
