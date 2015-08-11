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
import edu.scu.dp.smartcals.dao.impl.SmartCardDaoImpl;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.SmartCardDao;
import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.model.SmartCard;

public class SmartCardTest {

	private static SmartCardDao smctDao;
	

	@BeforeClass
	public static void init() throws IOException, ClassNotFoundException {
		System.out.println("hhh");
		FileInputStream f = new FileInputStream("db.properties");
		Properties properties = new Properties();
		properties.load(f);
		DatabaseFactory factory = DatabaseFactory.getFactory(properties,
				DbType.MYSQL);
		System.out.println("ddd");
		smctDao = new SmartCardDaoImpl(factory);
	}

	@Test
	public void testGetProductsById() throws SQLException, EmptyResultException {
		SmartCard smct = smctDao.buySmartCard();
		System.out.println(smct.getBalance());
		smct = smctDao.loadSmartCard(12, 25.00);
		System.out.println(smct.getBalance());
	
	}
}