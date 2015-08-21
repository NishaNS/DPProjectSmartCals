package edu.scu.dp.smartcals.vm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.scu.dp.smartcals.constants.ProductCategory;
import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.dao.impl.DaoFactory;
import edu.scu.dp.smartcals.dao.interfaces.AdminLoginDao;
import edu.scu.dp.smartcals.dao.interfaces.NutritionalInfoDao;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.dao.interfaces.VendingMachineDao;
import edu.scu.dp.smartcals.exception.DatabaseInitializationException;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.AdminLoginModel;
import edu.scu.dp.smartcals.model.NutritionalInfoModel;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.VendingMachineModel;
import edu.scu.dp.smartcals.ui.LoginView;
import edu.scu.dp.smartcals.ui.MonitoringStationView;
import edu.scu.dp.smartcals.ui.TabbedView;
import edu.scu.dp.smartcals.ui.VMClient;
import edu.scu.dp.smartcals.ui.VMDetails_View;
import edu.scu.dp.smartcals.ui.VMProdCategory;
import edu.scu.dp.smartcals.ui.VMSelectionView;
import edu.scu.dp.smartcals.ui.VendingMachineView;

/**
 * @author Aparna Ganesh
 * @author Nisha Narayanaswamy VMController class decides the views to be
 *         displayed on user action, delegates the call to required classes
 *
 */
public class VMController {

	private VendingMachineDao vendingMachineDao;
	private ProductDao productDao;
	private AdminLoginDao adminLoginDao;
	//start - Nisha - 8/20 
	private NutritionalInfoDao nutriInfoDao;
	//end - Nisha

	private VMClient mainWindow;
	private VMSelectionView vmSelectionView;
	private VendingMachineView vendingMachineView;
	private LoginView loginView;
	private MonitoringStationView monitoringStationView;	
	private LoginCheckPointStrategy loginStrategy;
	
	private TabbedView tabbedView;

	public VMController() {
		// Code change done-Aparna
		initialiseDao();

		// launch in following sequence - JFrame, SelectionView..etc
		if (mainWindow == null)
			this.mainWindow = new VMClient();
		if (vmSelectionView == null)
			this.vmSelectionView = new VMSelectionView(this);
		if (vendingMachineView == null)
			this.vendingMachineView = new VendingMachineView(this);
		if (loginView == null)
			this.loginView = new LoginView(this);
		if (monitoringStationView == null)
			this.monitoringStationView = new MonitoringStationView(this);
		
		//start - Nisha - 8/19
		if(tabbedView == null)
			this.tabbedView = new TabbedView(this);
		//end - Nisha - 8/19
		
		// TODO load Selection View to run-Aparna
		// load first view from this page only

		mainWindow.addPanels(vmSelectionView);

	}

	/**
	 * code change-Aparna Method to initialize DB connection and Dao
	 */
	private void initialiseDao() {
		try {

			DaoFactory.initialize();
		} catch (DatabaseInitializationException e) {

			e.printStackTrace();
		}
		// initializing the daos' used here
		vendingMachineDao = DaoFactory.getVendingMachineDao();
		productDao = DaoFactory.getProductDao();
		adminLoginDao = DaoFactory.getAdminLoginDao();
	
		//start - Nisha - 8/20 
		nutriInfoDao = DaoFactory.getNutritionalInfoDao();
		//end - Nisha
	}

	/**
	 * @return vendingMachineView Return the view holding the JFrame object
	 */
	public VMClient getView() {
		return mainWindow;
	}

	public VMSelectionView getSelectView() {
		return this.vmSelectionView;
	}

	public VendingMachineView getVendingMachineView() {
		return vendingMachineView;
	}
	
	//start - Nisha - 8/19 - new methods
	public MonitoringStationView getMonitoringStationView() {
		return monitoringStationView;
	}
	
	public LoginView getLoginView() {
		return loginView;
	}
	
	//code change in progress- Aparna 21/8
	public TabbedView getTabbedView() {
		return tabbedView;
	}

	public void setTabbedView(TabbedView tabbedView) {
		this.tabbedView = tabbedView;
	}
	//-------------------------------------------------------------
	//end - Nisha - 8/19
	
	// $$$$$$ add getter methods for other views here $$$$$$


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
		} catch (SQLException e) {
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
		} catch (SQLException e) {

			e.printStackTrace();
			return null;

		}

		VendingMachineFactory vendingMachineFactory = VendingMachineFactory.getFactory(vmModel.getType());

		VendingMachine vendingMachine = vendingMachineFactory.createVendingMachine(vmModel);

		List<ProductModel> productModels = vmModel.getProductModels();
		
		System.out.println("Product Model contains " + productModels.toString());
		
		for (ProductModel productModel : productModels) {

			switch (productModel.getCategory()) {
			case BEVERAGE:
				Beverage breverage = vendingMachineFactory.createBreverage(productModel);
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

	
	//start - Nisha - 8/20 - display nutri info
	/**
	 * Display Nutritional Info on the view for selected product
	 * @throws EmptyResultException 
	 * @throws SQLException 
	 */
	public String displayNutritionalInfo(long ProdID) throws EmptyResultException {
		NutritionalInfoModel nutriInfoModel = null;
		
		try {
			nutriInfoModel = nutriInfoDao.getNutriInfo(ProdID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nutriInfoModel.toString();	
	}	
	//end - Nisha - 8/20
	
	/**
	 * Authenticates the user login with database
	 * 
	 * @param username
	 *            The value entered in Username field in Login view
	 * @param password
	 *            The value entered in Password field in Login view
	 */
	public void authenticateUser(String username, String password) {

		try {

			AdminLoginModel adminLoginModel = adminLoginDao.validateLogin(
					username, password);

			if (adminLoginModel != null) {

				// update DB table with time of latest login
				adminLoginDao.setLastLoginTime(username);

				//start - Nisha - 8/19 - tabbed view
				
				// load next view in tabbed view
				tabbedView.getTabPane().removeTabAt(1);
				tabbedView.getTabPane().setSelectedIndex(1);
				tabbedView.getTabPane().addTab("Monitoring Station",
						monitoringStationView);				
				//end - Nisha - 8/19

			} else {

				// update table with number of failed attempts
				adminLoginDao.setLoginFailedAttempt(username);

				// set strategy
				this.setLoginCheckPointStrategy(new FailedLoginAttemptStrategy());
				if(loginStrategy.performSecurityCheck(username) == false)
					loginView.setMessage("<html>You have failed your login attempt for 3 times consecutively. <br>Your account will be locked for 30 minutes.</html>");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param strategy 
	 *            Client to provide the strategy for failed login attempts
	 */
	public void setLoginCheckPointStrategy(LoginCheckPointStrategy loginStrategy) {
		this.loginStrategy = loginStrategy;
	}

	public static void main(String[] args) {
		new VMController();
	}

	
}
