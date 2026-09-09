package SystemCode;

public class Magazine extends LibraryItem {
    private static final int LOAN_PERIOD_DAYS = 7;
    private String issueNumber;
    private String monthYear;

    public Magazine(String title, String issueNumber, String monthYear) {
        super(title);
        this.issueNumber = issueNumber;
        this.monthYear = monthYear;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public String getMonthYear() {
        return monthYear;
    }

    @Override
    public int getLoanPeriodDays() {
        return LOAN_PERIOD_DAYS;
    }

    @Override
    public String getItemType() {
        return "Magazine";
}
}