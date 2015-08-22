package edu.scu.dp.smartcals.payment;

public interface PaymentCreator {
	
	public PaymentProduct makePayment(String type,double amtPayable);
}
