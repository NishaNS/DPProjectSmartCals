/**
 * 
 */
package edu.scu.dp.smartcals.vm;

import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * @author Aparna Ganesh
 * Vending Machine Factory to return SchoolFactory and Hospital Factory
 */
public abstract class VendingMachineFactory {

	/**
	 * Retuns VendingMachine 
	 * @param vendingMachineModel
	 * @return
	 */
	public abstract VendingMachine createVendingMachine(VendingMachineModel vendingMachineModel);
	
	/**
	 * Returns either SchoolVMFactory or HospitalVMFactory based on user requirement
	 * @param vmLocationType
	 * @return
	 */
	public static VendingMachineFactory getFactory(VMLocationType vmLocationType) {
		
		switch(vmLocationType) {
		case SCHOOL:
			return new SchoolVendingMachineFactory();
			
		
		case HOSPITAL:
			return new HospitalVendingMachineFactory();
			
		 default:
			return null;
	}
		
}
}