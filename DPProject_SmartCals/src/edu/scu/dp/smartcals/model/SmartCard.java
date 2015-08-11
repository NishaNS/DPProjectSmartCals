/**
 * 
 */
package edu.scu.dp.smartcals.model;

/**
 * Product Model representing Product DB Table
 * @author Sharadha Ramaswamy
 *
 */
public class SmartCard {

	//TODO add more product attributes here
	private long smartCardId;
	
	private String userName;
	
	private double balance;

	public long getSmartCard() {
		return smartCardId;
	}

	public void setSmartCard(long smartCardId) {
		this.smartCardId = smartCardId;
	}

	public String getName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	} 
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
}