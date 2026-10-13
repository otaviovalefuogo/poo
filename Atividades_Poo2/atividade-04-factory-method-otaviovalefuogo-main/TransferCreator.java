public class TransferCreator extends Creator{
	@Override
	public Payment createPayment() {		
		return new Transfer();
	}

}