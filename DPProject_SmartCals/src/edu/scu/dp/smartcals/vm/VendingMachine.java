/**
 * 
 */
package edu.scu.dp.smartcals.vm;

import java.util.List;

import edu.scu.dp.smartcals.constants.VMLocationType;
import edu.scu.dp.smartcals.constants.VMStatus;

/**
 * @author Aparna Ganesh
 * Vending Machine class to perform all Vending Machine operations.
 * Implements the methods listed from Vending Machine Interface.
 */
public abstract class VendingMachine {

	private long vendingMachineId;
	
	private String location;

	private VMStatus status;
	
	private VMLocationType locationType;

	private List<Beverage> beverage;

	private List<Candy> candies;

	private List<Snack> snacks;

	
	public void buyFood() {
		// TODO Auto-generated method stub
		
	}

	public void payFood() {
		// TODO Auto-generated method stub
		
	}

	public void getNutriInfo() {
		// TODO Auto-generated method stub
		
	}

	public List<Product> searchProductByCalorie() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> searchProductBySmartTag() {
		// TODO Auto-generated method stub
		return null;
	}

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

	public VMLocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(VMLocationType locationType) {
		this.locationType = locationType;
	}

}
