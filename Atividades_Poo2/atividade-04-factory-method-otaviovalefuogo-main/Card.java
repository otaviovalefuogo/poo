public class Card implements Payment {

	@Override
	public void process(double value) {
		System.out.printf("The payment is being processed by card in the amount of:$ %.2f\n", value);

	}

}