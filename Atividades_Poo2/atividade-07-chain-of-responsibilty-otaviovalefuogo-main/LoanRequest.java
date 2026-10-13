public class LoanRequest {
    public double requestedAmount;      
    public double monthlyIncome;       
    public int numberOfInstallments;    
    public boolean hasCreditRestriction;
    public boolean hasCollateral;       

    public LoanRequest(double requestedAmount, double monthlyIncome, int numberOfInstallments, boolean hasCreditRestriction, boolean hasCollateral) {
        this.requestedAmount = requestedAmount;
        this.monthlyIncome = monthlyIncome;
        this.numberOfInstallments = numberOfInstallments;
        this.hasCreditRestriction = hasCreditRestriction;
        this.hasCollateral = hasCollateral;
    }


    public double getInstallmentAmount() {
        return requestedAmount / numberOfInstallments;
    }
}