public class Main {
    public static void main(String[] args) {
        
   
        LoanProcessor processor = new LoanProcessor();
        

        processor.addHandler(new BankFundHandler());
        processor.addHandler(new IncomeHandler());
        processor.addHandler(new CreditHistoryHandler());
        processor.addHandler(new CollateralHandler());


        LoanRequest req = new LoanRequest(50000, 15000, 24, false, true);
        
       
        processor.process(req);
    }
}