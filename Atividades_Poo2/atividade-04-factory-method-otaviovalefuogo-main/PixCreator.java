public class PixCreator extends Creator {
	@Override
	public Payment createPayment() {		
		return new Pix();
	}
}