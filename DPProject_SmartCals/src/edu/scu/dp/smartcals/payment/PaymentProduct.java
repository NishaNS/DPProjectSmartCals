package edu.scu.dp.smartcals.payment;

public interface PaymentProduct {
	public boolean getPaymentStatus();
	public double getAmtToReturn();
	public double getAmtPayable();
	public void setTotValue(double amt1,double amt2,double amt3);
}
