package edu.scu.dp.smartcals.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.exception.ProductNotFoundException;
import edu.scu.dp.smartcals.model.Product;

/**
 * 
 * @author Aparna Ganesh
 *
 */
public class ProductDaoImpl implements ProductDao {

	private DatabaseFactory databaseFactory;

	public ProductDaoImpl(DatabaseFactory databaseFactory) {

		this.databaseFactory = databaseFactory;

	}
	@Override
	public Product getProductById(long id) throws SQLException, ProductNotFoundException {
		//first get the connection, write query, return the resultset
		Product product = null;
		PreparedStatement statement = null;
		Connection connection = databaseFactory.getConnection();
		
		try {
			statement = connection.prepareStatement("select * from product where productID =?");
		statement.setLong(1, id);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			product = mapRow(rs);
			/*long productId = rs.getLong("ProductID");
			String productName = rs.getString("ProductName");
			System.out.println("Product Id " + productId + "ProductName" + productName);*/
		}
		else {
			throw new ProductNotFoundException();
		}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeStatement(statement);
			DBUtils.closeConnection(connection);
		}
		return product;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getProductByCalorieRange(int low, int high) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductBySmartTag(List<String> smartTags) {
		// TODO Auto-generated method stub
		return null;
	}
/**
 * Product Row Mapper
 * @param resultSet
 * @return
 * @throws SQLException
 */
	private Product mapRow(ResultSet resultSet) throws SQLException {
		Product product = new Product();
		product.setProductId(resultSet.getLong("ProductID"));
		product.setProductName(resultSet.getString("ProductName"));
		// TODO need to add more columns

		return product;
	}
}
