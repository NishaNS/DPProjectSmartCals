package edu.scu.dp.smartcals.vm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.dao.impl.DaoFactory;
import edu.scu.dp.smartcals.dao.interfaces.VendingMachineDao;
import edu.scu.dp.smartcals.exception.DatabaseInitializationException;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * @author Aparna Ganesh
 * @author Nisha Narayanaswamy
 * VMController class decides the views to be displayed on user action, delegates the call to required classes
 *
 */
public class VMController {
	
	private VendingMachineDao vendingMachineDao;
	
	public VMController() {
		try {
			//TODO This factory intialize part shud be done only once for the entire application. Do it where appl starts
			//for testing purpose its here
			DaoFactory.initialize();
		} catch (DatabaseInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vendingMachineDao = DaoFactory.getVendingMachineDao();
	}
	/**
	 * Returns all the Vending Machines from Database to ViewAllVendingMachines user interface.
	 * Converting Vending Machine Model objects to Vending Machine objects
	 * @return
	 */
	public List<VendingMachine> getAllVendingMachines() {
		List<VendingMachineModel> vendingMachineModels = null;
		List<VendingMachine> vendingMachines = new ArrayList<>();
		try {
			vendingMachineModels = vendingMachineDao.getAllVendingMachines();
		} catch (EmptyResultException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Collections.emptyList();
		}
		
		for(VendingMachineModel vmModel : vendingMachineModels ) {
			
			VendingMachineFactory vendingMachineFactory = VendingMachineFactory.getFactory(VMLocationType.valueOf(vmModel.getLocation()));
			VendingMachine vendingMachine = vendingMachineFactory.createVendingMachine(vmModel);
			vendingMachines.add(vendingMachine);
		}
		return vendingMachines;
	}

}
