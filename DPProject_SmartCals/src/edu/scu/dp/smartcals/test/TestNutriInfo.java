package edu.scu.dp.smartcals.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.scu.dp.smartcals.constants.DbType;
import edu.scu.dp.smartcals.dao.impl.NutritionalInfoDaoImpl;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.NutritionalInfoDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.NutritionalInfo;

public class TestNutriInfo {
	
	private static NutritionalInfoDao nutriInfoDao;
	
	@BeforeClass
	public static void init() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("db.properties");
		Properties properties = new Properties();
		properties.load(fin);
		DatabaseFactory dbFactory = DatabaseFactory.getFactory(properties, DbType.MYSQL);
		nutriInfoDao = new NutritionalInfoDaoImpl(dbFactory);
	}
	
	@Test
	public void testGetProdID() throws SQLException, EmptyResultException{
		//the productID needs to be passed from UI once the user selects one.
		//For testing purpose productId is hardcoded
		NutritionalInfo nutri = nutriInfoDao.getNutriInfo(103);
		System.out.println(nutri.getProductID());
		
	}

	
	
	
	
	

}
