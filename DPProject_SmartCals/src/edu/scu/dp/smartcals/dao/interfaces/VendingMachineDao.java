/**
 * 
 */
package edu.scu.dp.smartcals.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * Vending Machine DAO
 * @author Aparna Ganesh
 *
 */
public interface VendingMachineDao {
	
	/**
	 * Lists all vending machines from Vending machine table
	 * @return
	 * @throws EmptyResultException
	 * @throws SQLException
	 */
	public List<VendingMachineModel> getAllVendingMachines() throws EmptyResultException, SQLException;

}
