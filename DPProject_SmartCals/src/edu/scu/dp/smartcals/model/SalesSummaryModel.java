package edu.scu.dp.smartcals.model;

/**
 * @author Nisha Narayanaswamy
 * 
 *         SalesSummaryModel represents the SalesSummary table in DB
 *
 */
public class SalesSummaryModel {

	private long vendingMachineID;
	private double dailySalesAmount;
	private double totalSalesAmount;

	public long getVendingMachineID() {
		return vendingMachineID;
	}

	public double getDailySalesAmount() {
		return dailySalesAmount;
	}

	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}

}
