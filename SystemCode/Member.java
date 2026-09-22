package SystemCode;

import java.math.BigDecimal;

public class Member {
    private static int nextId = 1;

    private String id;
    private String name;
    private String contactInfo;
    private MembershipTier membershipTier;
    private int loansCount = 0;
    private BigDecimal outstandingBalance = new BigDecimal("0.0");

    public Member(String name, String contactInfo, MembershipTier membershipTier) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (contactInfo == null || contactInfo.isBlank()) {
            throw new IllegalArgumentException("Contact information cannot be empty.");
        }

        if (membershipTier == null) {
            throw new IllegalArgumentException("Membership tier cannot be null.");
        }
        id = String.valueOf(nextId++);
        this.name = name;
        this.contactInfo = contactInfo;
        this.membershipTier = membershipTier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public MembershipTier getTier() {
        return membershipTier;
    }

    public int getLoansCount() {
        return loansCount;
    }

    public void incrementLoansCount() {
        loansCount++;
    }

    public void decrementLoansCount() {
        loansCount--;
    }

    public void addFine(BigDecimal amount) {
        outstandingBalance = outstandingBalance.add(amount);
    }

    public void payFine(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0 || amount.compareTo(outstandingBalance) > 0) {
            return;
        }

        outstandingBalance = outstandingBalance.subtract(amount);
    }

    public BigDecimal getOutstandingBalance(){
        return outstandingBalance;
    }

}
