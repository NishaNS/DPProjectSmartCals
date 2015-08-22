package edu.scu.dp.smartcals.payment;



public class CashPayment implements PaymentProduct{
	double amtPayable;
	double amtToReturn;
	double totValue;
 	double fiveDollar;
	double tenDollar;
	double oneDollar;
	
	public CashPayment(double amtPayable){
		this.amtPayable = amtPayable;
	}
	@Override
	public boolean getPaymentStatus(){
		if (amtPayable > totValue)
			return false;
		amtToReturn = totValue - amtPayable;	
		return true;
	}

	@Override
	public double getAmtToReturn() {
		// TODO Auto-generated method stub
		return amtToReturn;
	}

	@Override
	public double getAmtPayable() {
	    return amtPayable;
		
	}
	@Override
	public void setTotValue(double amt1, double amt2, double amt3) {
		oneDollar = amt1;
		fiveDollar = amt2;
		tenDollar = amt3;
		totValue = oneDollar * 1 + fiveDollar * 5 + tenDollar * 10;	
	}



}
