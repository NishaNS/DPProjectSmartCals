package edu.scu.dp.smartcals.payment;



public class NullCoinPayment implements PaymentProduct{
	double amtPayable = 0.0;
	double amtToReturn = 0.0;
	@Override
	public boolean getPaymentStatus() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double getAmtToReturn() {
		// TODO Auto-generated method stub
		return amtToReturn;
	}
	@Override
	public double getAmtPayable() {
		// TODO Auto-generated method stub
		return amtPayable;
	}
	@Override
	public void setTotValue(double amt1, double amt2, double amt3) {
		// TODO Auto-generated method stub
		
	}
	

}

