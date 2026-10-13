public class CollateralHandler implements LoanHandler {
    
    @Override
    public boolean evaluate(LoanRequest request) {
        System.out.println("[Collateral] Checking for assets as collateral...");
        
        if (!request.hasCollateral) {
            System.out.println("-> DENIED: Collateral is required for final approval.");
            return false; 
        }
        
        System.out.println("-> APPROVED: Collateral verified.");
        return true; 
    }
}