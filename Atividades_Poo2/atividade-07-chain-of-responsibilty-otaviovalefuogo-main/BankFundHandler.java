public class BankFundHandler implements LoanHandler {
    private final double MAX_BANK_FUNDS = 1000000.00;

    @Override
    public boolean evaluate(LoanRequest request) {
        System.out.println("[Bank Fund] Checking institutional funds...");
        
        if (request.requestedAmount > MAX_BANK_FUNDS) {
            System.out.println("-> DENIED: The bank does not have enough funds for this request.");
            return false;
        }
        
        System.out.println("-> APPROVED: Funds available.");
        return true;
    }
}