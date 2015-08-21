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

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.OrderHistoryDao;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * @author Aparna Ganesh
 *Order History - To get best selling product
 */
public class OrderHistoryDaoImpl implements OrderHistoryDao{

	private DatabaseFactory databaseFactory;

	private static OrderHistoryDao INSTANCE;
	
	private ProductDao productDao;

	private OrderHistoryDaoImpl(DatabaseFactory databaseFactory) {
		this.databaseFactory = databaseFactory;
		productDao = ProductDaoImpl.getInstance(databaseFactory);
	}
	
	/**
	 * Implementation of Singleton pattern. There should be only one ProductDAO
	 * instance for the entire application
	 * 
	 * @param databaseFactory
	 * @return
	 */
	public static OrderHistoryDao getInstance(DatabaseFactory databaseFactory) {
		if (INSTANCE == null) {
			INSTANCE = new OrderHistoryDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}

	@Override
	public List<ProductModel> getBestSellingProduct(long vmId) throws SQLException {
		PreparedStatement statement = null;
		Connection connection = databaseFactory.getConnection();
		List<ProductModel> bestSellingProducts = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement("select count(*) product_count,product_id from orderdetails group by product_id,vm_id having vm_id=? order by product_count desc limit 3");
			statement.setLong(1, vmId);
			ResultSet rs = statement.executeQuery();
			 
			while (rs.next()) {
				
				long productId = rs.getLong("product_id");
				bestSellingProducts.add(productDao.getProductById(productId));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeStatement(statement);
			databaseFactory.closeConnection();
		}
		return bestSellingProducts;

		
	}

}
