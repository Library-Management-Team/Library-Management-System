package SystemCode;

public class Member {
    private static int nextId = 1;

    private String id;
    private String name;
    private String contactInfo;
    private MembershipTier membershipTier;
    private int loansCount = 0;
    private double outstandingBalance = 0.0;

    public Member(String name, String contactInfo, MembershipTier membershipTier) {
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

    public double getOutstandingBalance() {
    return outstandingBalance;
    }

    public void addFine(double amount) {
        outstandingBalance += amount;
    }

    public void payFine(double amount) {

        if (amount < 0 || amount > outstandingBalance) {
            return;
        }
        outstandingBalance -= amount;
    }

}
