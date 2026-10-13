public class CardCreator extends Creator{
	@Override
	public Payment createPayment() {		
		return new Card();
	}

}