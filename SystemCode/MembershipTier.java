package SystemCode;

public enum MembershipTier {
    STANDARD(MembershipLimits.STANDARD_ITEM_LIMIT, MembershipLimits.STANDARD_LOAN_PERIOD),
    PREMIUM(MembershipLimits.PREMIUM_ITEM_LIMIT, MembershipLimits.PREMIUM_LOAN_PERIOD);

    private final int borrowingLimit;
    private final int loanPeriod;

    MembershipTier(int borrowingLimit, int loanPeriod) {
        this.borrowingLimit = borrowingLimit;
        this.loanPeriod = loanPeriod;
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

}
