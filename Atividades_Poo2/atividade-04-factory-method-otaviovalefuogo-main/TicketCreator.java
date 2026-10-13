public class TicketCreator extends Creator{
	@Override
	public Payment createPayment() {		
		return new Ticket();
	}

}