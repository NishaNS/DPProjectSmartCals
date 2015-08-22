package edu.scu.dp.smartcals.payment;

public class ConcretePaymentCreator implements PaymentCreator{
    private PaymentProduct pay;
	@Override
	public PaymentProduct makePayment(String type,double amtPayable) {
		if(type == "Coin")
			pay = new CoinPayment(amtPayable);
		else if(type == "NullCoin")
			pay = new NullCoinPayment();
		else if(type == "Cash")
			pay = new CashPayment(amtPayable);
		else if(type == "NullCash")
			pay = new NullCashPayment();
		else if(type == "SmartCard")
			pay = new SmartCardPayment();
		return pay;
	}

}

