package SystemCode;

public class BorrowResult {
    private Loan loan;
    private String failureReason;

    public BorrowResult(Loan loan, String failureReason) {
        this.loan = loan;
        this.failureReason = failureReason;
    }

    public Loan getLoan() {
        return loan;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public boolean isSuccess() {
        return loan != null;
    }
}
