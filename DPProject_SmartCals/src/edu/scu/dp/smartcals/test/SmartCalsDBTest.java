package edu.scu.dp.smartcals.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.scu.dp.smartcals.constants.DbType;
import edu.scu.dp.smartcals.dao.impl.ProductDaoImpl;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.exception.ProductNotFoundException;
import edu.scu.dp.smartcals.model.Product;

/**
 * Junit Test file to test Database operations
 * @author Aparna Ganesh
 *
 */
public class SmartCalsDBTest {

	private static ProductDao productDao;

	@BeforeClass
	public static void init() throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream("db.properties");
		Properties properties = new Properties();
		properties.load(f);
		DatabaseFactory factory = DatabaseFactory.getFactory(properties,
				DbType.MYSQL);
		productDao = new ProductDaoImpl(factory);
	}

	@Test
	public void testGetProductsById() throws SQLException, ProductNotFoundException {
		//the productID needs to be passed from UI once the user selects one.
		//For testing purpose productId is hardcoded
		Product product = productDao.getProductById(1);
		assert ( product.getProductId() == 1);

	}

}
