package edu.scu.dp.smartcals.payment;


public class CoinPayment implements PaymentProduct{
    
	double amtPayable;
	double amtToReturn;
	double totValue;
 	double quarters;
	double halfDollar;
	double oneDollar;
	
	public CoinPayment(double amtPayable){
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
		quarters = amt1;
		halfDollar = amt2;
		oneDollar = amt3;
		totValue = quarters * 25 + halfDollar * 50 + oneDollar * 100;
		totValue = totValue/100;
		
	}


}
