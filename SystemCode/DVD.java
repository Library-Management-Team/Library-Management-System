package SystemCode;

public class DVD extends LibraryItem {
    private static final int LOAN_PERIOD_DAYS = 3;
    private String director;
    private int runningTime;

    public DVD(String title, String director, int runningTime) {
        super(title);
        this.director = director;
        this.runningTime = runningTime;
    }

    public String getDirector() {
        return director;
    }

    public int getRunningTime() {
        return runningTime;
    }

    @Override
    public int getLoanPeriodDays() {
        return LOAN_PERIOD_DAYS;
    }

}