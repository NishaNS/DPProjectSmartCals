/**
 * 
 */
package edu.scu.dp.smartcals.vm;

import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * Factory class to return Hospital Vending Machine
 * @author Aparna Ganesh
 *
 */
public class HospitalVendingMachineFactory extends VendingMachineFactory {


/**
 * Factory method pattern to retun Hospital Vending Machine
 */
	@Override
	public VendingMachine createVendingMachine(VendingMachineModel vendingMachineModel) {
		VendingMachine hospitalVendingMachine = new HospitalVendingMachine();
		//TODO set id,location, status for hospital implementation
		return null;
	}
	}


