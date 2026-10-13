public class Pix implements Payment {

	@Override
	public void process(double value) {
		System.out.printf("The payment is being processed by pix in the amount of:$ %.2f\n", value);
	}

}