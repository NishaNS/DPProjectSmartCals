package edu.scu.dp.smartcals.dao.interfaces;

import edu.scu.dp.smartcals.model.SalesSummaryModel;

/**
 * @author Nisha Narayanaswamy
 * 
 * 
 */
public interface SalesSummaryDao {
	
	public SalesSummaryModel getAllSalesStatistics();
	
	public SalesSummaryModel getVMSalesStatistics(long vendingMachineId);

}
