public class Main {
    public static void main(String[] args) {
        
        
        Creator paymentCard = new CardCreator();
        paymentCard.doPayment(200.0);
        

        Creator paymentPix = new PixCreator();
        paymentPix.doPayment(150.0);


        Creator paymeCntTicket = new TicketCreator();
        paymeCntTicket.doPayment(50.0);
        
  
        Creator paymentTransfer = new TransferCreator();
        paymentTransfer.doPayment(1000.0);
    }
}