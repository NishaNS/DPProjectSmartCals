/**
 * 
 */
package edu.scu.dp.smartcals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.scu.dp.smartcals.constants.VMStatus;
import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.VendingMachineDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * Class to perform operations from Vending machine table
 * @author Aparna Ganesh
 *
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

	

	DatabaseFactory databaseFactory;
	
	private static VendingMachineDao INSTANCE;
	

	private VendingMachineDaoImpl(DatabaseFactory databaseFactory) {

		this.databaseFactory = databaseFactory;
	}
	/**
	 * Implementation of Singleton pattern as there should be only VendingMachineDAO for 
	 * the entire application
	 * @param databaseFactory
	 * @return
	 */
	public static VendingMachineDao getInstance(DatabaseFactory databaseFactory) {
		if(INSTANCE == null) {
			INSTANCE = new VendingMachineDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}
	 
	/**
	 * Returns all the vending machines basic info.
	 */

	@Override
	public List<VendingMachineModel> getAllVMBasicInfo() throws EmptyResultException, SQLException {
		PreparedStatement statement = null;
		Connection connection = databaseFactory.getConnection();
		List<VendingMachineModel> vendingMachines = new ArrayList<>();

		try {
			statement = connection
					.prepareStatement("select * from vendingmachine");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				vendingMachines.add(mapRow(rs));

			} 
				
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return vendingMachines;

	}
	
		
	/**
	 * VendingMachine Row Mapper
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private VendingMachineModel mapRow(ResultSet rs) throws SQLException {
		VendingMachineModel vendingMachine = new VendingMachineModel();
		vendingMachine.setVendingMachineId(rs.getLong("VendingMachineID"));
		vendingMachine.setLocation(rs.getString("Location"));
		vendingMachine.setType(VMLocationType.valueOf(rs.getString("type").toUpperCase()));
		vendingMachine.setStatus(VMStatus.valueOf(rs.getString("Status").toUpperCase()));
		return vendingMachine;
	}

}
