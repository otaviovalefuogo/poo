public class CreditHistoryHandler implements LoanHandler {
    
    @Override
    public boolean evaluate(LoanRequest request) {
        System.out.println("[Credit History] Checking SPC/SERASA restrictions...");
        
        if (request.hasCreditRestriction) {
            System.out.println("-> DENIED: Client has credit restrictions (SPC/SERASA).");
            return false;
        }
        
        System.out.println("-> APPROVED: Clean credit history.");
        return true;
    }
}