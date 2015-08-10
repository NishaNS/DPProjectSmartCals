/**
 * 
 */
package edu.scu.dp.smartcals.vm;

import java.util.List;

import edu.scu.dp.smartcals.constants.VMStatus;

/**
 * @author Aparna Ganesh
 * Vending Machine class to perform all Vending Machine operations.
 * Implements the methods listed from Vending Machine Interface.
 */
public abstract class AbstractVendingMachine implements VendingMachine {

	private long vendingMachineId;
	
	private String location;

	private VMStatus status;

	private List<Beverage> beverage;

	private List<Candy> candies;

	private List<Snack> snacks;

	
	@Override
	public void buyFood() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payFood() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getNutriInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> searchProductByCalorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductBySmartTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buySmartCard() {
		// TODO Auto-generated method stub
		
	}

	public List<Beverage> getBeverage() {
		return beverage;
	}

	public void setBeverage(List<Beverage> beverage) {
		this.beverage = beverage;
	}

	

	public List<Candy> getCandies() {
		return candies;
	}

	public void setCandies(List<Candy> candies) {
		this.candies = candies;
	}

	public List<Snack> getSnacks() {
		return snacks;
	}

	public void setSnacks(List<Snack> snacks) {
		this.snacks = snacks;
	}

	public long getVendingMachineId() {
		return vendingMachineId;
	}

	public void setVendingMachineId(long vendingMachineId) {
		this.vendingMachineId = vendingMachineId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public VMStatus getStatus() {
		return status;
	}

	public void setStatus(VMStatus status) {
		this.status = status;
	}

}
