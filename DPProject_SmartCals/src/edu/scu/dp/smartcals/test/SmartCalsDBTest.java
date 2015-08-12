package edu.scu.dp.smartcals.test;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.scu.dp.smartcals.constants.DbType;
import edu.scu.dp.smartcals.dao.impl.DaoFactory;
import edu.scu.dp.smartcals.dao.impl.ProductDaoImpl;
import edu.scu.dp.smartcals.dao.impl.VendingMachineDaoImpl;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.ProductDao;
import edu.scu.dp.smartcals.dao.interfaces.VendingMachineDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.ProductModel;
import edu.scu.dp.smartcals.model.VendingMachineModel;

/**
 * Junit Test file to test Database operations
 * @author Aparna Ganesh
 *
 */
public class SmartCalsDBTest {

	private static ProductDao productDao;
	
	private static VendingMachineDao vendingMachineDao;
/**
 * Test case to initialise database connection
 * @throws Exception
 */
	@BeforeClass
	public static void init() throws Exception {
		DaoFactory.initialize();
		productDao = DaoFactory.getProductDao();
		vendingMachineDao = DaoFactory.getVendingMachineDao();
		
		
	}

	@Test
	public void testGetProductsById() throws SQLException, EmptyResultException {
		//the productID needs to be passed from UI once the user selects one.
		//For testing purpose productId is hardcoded


		ProductModel product = productDao.getProductById(101);
		assertTrue( product.getProductId() == 101);

	}
	/**
	 * Test case to display all products from Vending Machine table
	 * @throws SQLException
	 * @throws EmptyResultException
	 */
	@Test
	public void testGetAllVendingMachines() throws SQLException, EmptyResultException {
		
		
		List<VendingMachineModel> vendingMachines = vendingMachineDao.getAllVMBasicInfo();
		
		for(VendingMachineModel vmModel : vendingMachines) {
			System.out.println(vmModel);
		}
		assertTrue(vendingMachines.size() == 3);


	}

}
