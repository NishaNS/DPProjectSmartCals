package edu.scu.dp.smartcals.dao.impl;

import java.sql.PreparedStatement;

import edu.scu.dp.smartcals.dao.interfaces.AdminLoginDao;
import edu.scu.dp.smartcals.dao.interfaces.DatabaseFactory;
import edu.scu.dp.smartcals.dao.interfaces.InventoryDao;
import edu.scu.dp.smartcals.dao.interfaces.SalesSummaryDao;
import edu.scu.dp.smartcals.model.AdminLoginModel;
import edu.scu.dp.smartcals.model.SalesSummaryModel;

/**
 * @author Nisha Narayanaswamy
 * 
 *  Class to fetch sales statistics from SalesSummary table
 *
 */
public class SalesSummaryDaoImpl implements SalesSummaryDao {
	
	private DatabaseFactory databaseFactory;
	private PreparedStatement statement = null;
	private SalesSummaryModel salesSummary;
	private static SalesSummaryDao INSTANCE;
	
	private SalesSummaryDaoImpl(DatabaseFactory databaseFactory) {
		this.databaseFactory = databaseFactory;
	}
	
	/**
	 * Implementation of Singleton pattern. There should be only one SalesSummaryDAO
	 * instance for the entire application
	 * 
	 * @param databaseFactory
	 * @return
	 */
	public static SalesSummaryDao getInstance(DatabaseFactory databaseFactory) {
		if (INSTANCE == null) {
			INSTANCE = new SalesSummaryDaoImpl(databaseFactory);
		}
		return INSTANCE;
	}

	@Override
	public SalesSummaryModel getAllSalesStatistics() {
		
		return null;
	}

	@Override
	public SalesSummaryModel getVMSalesStatistics(long vendingMachineId) {
	
		return null;
	}

}
