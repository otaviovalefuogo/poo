public class IncomeHandler implements LoanHandler {
    
    @Override
    public boolean evaluate(LoanRequest request) {
        System.out.println("[Income] Checking income compatibility...");
        
        double maxInstallment = request.monthlyIncome * 0.25; 
        
        if (request.getInstallmentAmount() > maxInstallment) {
            System.out.println("-> DENIED: Installment exceeds 25% of monthly income.");
            return false; 
        }
        
        System.out.println("-> APPROVED: Income is compatible.");
        return true; 
    }
}