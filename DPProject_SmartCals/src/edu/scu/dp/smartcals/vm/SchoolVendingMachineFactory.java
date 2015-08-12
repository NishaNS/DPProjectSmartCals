/**
 * 
 */
package edu.scu.dp.smartcals.vm;

import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * @author Aparna Ganesh
 * Factory method pattern to return School Vending Machine
 */
public class SchoolVendingMachineFactory extends VendingMachineFactory {

	
	@Override
	public VendingMachine createVendingMachine(VendingMachineModel vendingMachineModel) {
		
		VendingMachine schoolVendingMachine = new SchoolVendingMachine();
		schoolVendingMachine.setVendingMachineId(vendingMachineModel.getVendingMachineId());
		schoolVendingMachine.setLocation(vendingMachineModel.getLocation());
		schoolVendingMachine.setStatus(vendingMachineModel.getStatus());
		schoolVendingMachine.setLocationType(vendingMachineModel.getType());
		return schoolVendingMachine;
	}

	
	
}
