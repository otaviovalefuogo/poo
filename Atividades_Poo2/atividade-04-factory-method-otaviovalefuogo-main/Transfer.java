public class Transfer implements Payment {

	@Override
	public void process(double value) {
		System.out.printf("The payment is being processed by transfer in the amount of:$ %.2f\n", value);
	}

}