public abstract class Creator {
	
		
	public void doPayment(double value) {
		System.out.println("Initiating payment process");
		Payment Payment = createPayment();
		Payment.process(value);
	}
	
	public abstract Payment createPayment();
}