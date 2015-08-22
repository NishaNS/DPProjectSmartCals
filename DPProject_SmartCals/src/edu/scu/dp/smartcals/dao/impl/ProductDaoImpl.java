package edu.scu.dp.smartcals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.ProductModel;

/**
 * Class to perform operations from Product Table
 * 
 * @author Aparna Ganesh
 *
 */
public class ProductDaoImpl implements ProductDao {

	private DatabaseFactory databaseFactory;

	private static ProductDao INSTANCE;

	private ProductDaoImpl(DatabaseFactory databaseFactory) {
		this.databaseFactory = databaseFactory;
	}

	/**
	 * Implementation of Singleton pattern. There should be only one ProductDAO
	 * instance for the entire application
	 * 
	 * @param databaseFactory
	 * @return
	 */
	public static ProductDao getInstance(DatabaseFactory databaseFactory) {
		if (INSTANCE == null) {
			INSTANCE = new ProductDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}

	/**
	 * Returns a product for a given product ID. Connection is opened and closed
	 * for every DB operation
	 */
	@Override
	public ProductModel getProductById(long id) throws SQLException,
			EmptyResultException {

		ProductModel product = null;
		PreparedStatement statement = null;
		Connection connection = databaseFactory.getConnection();

		try {
			statement = connection
					.prepareStatement("select * from product where productID =?");
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				product = ProductRowMapper.mapRow(rs);
				
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
		return product;
	}

	@Override
	public void addProduct(ProductModel product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(ProductModel product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductModel> getProductByCalorieRange(int low, int high) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getProductBySmartTag(List<String> smartTags) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
