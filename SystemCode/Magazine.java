package SystemCode;
public class Magazine extends LibraryItem {
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
        return 7;
    }
}