package edu.scu.dp.smartcals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.scu.dp.smartcals.constants.ProductCategory;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.InventoryDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.InventoryModel;
import edu.scu.dp.smartcals.model.ProductModel;


public class InventoryDaoImpl implements InventoryDao{
	
	private DatabaseFactory databaseFactory;

	private static InventoryDao INSTANCE;

	private InventoryDaoImpl(DatabaseFactory databaseFactory) {
		this.databaseFactory = databaseFactory;
	}

	/**
	 * Implementation of Singleton pattern. There should be only one ProductDAO
	 * instance for the entire application
	 * 
	 * @param databaseFactory
	 * @return
	 */
	public static InventoryDao getInstance(DatabaseFactory databaseFactory) {
		if (INSTANCE == null) {
			INSTANCE = new InventoryDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}

	@Override
	public InventoryModel getProductById(long id) throws SQLException,
			EmptyResultException {
		InventoryModel invProd = null;
		PreparedStatement statement = null;
		Connection connection = databaseFactory.getConnection();

		try {
			statement = connection
					.prepareStatement("select * from inventory where productID =?");
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				invProd = mapRow(rs); 
			} else {
				throw new EmptyResultException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return invProd;
	}
		
		 
	public static InventoryModel mapRow(ResultSet resultSet) throws SQLException {
				InventoryModel invProd = new InventoryModel();
				invProd.setProductPrice(resultSet.getDouble("Price"));
				invProd.setProductId(resultSet.getLong("ProductID"));
				invProd.setVendingMachineId(resultSet.getLong("VendingMachineID"));
				invProd.setskuId(resultSet.getLong("SKU"));
				invProd.setqty(resultSet.getInt("Quantity"));
				invProd.setinventoryStatus(resultSet.getString("InventoryStatus"));
				return invProd;
		}


}
