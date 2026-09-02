package SystemCode;

public class Book extends LibraryItem {
    private static final int LOAN_PERIOD_DAYS = 14;
    private String isbn;
    private String author;

    public Book(String isbn, String title, String author) {
        super(title);
        this.isbn = isbn;
        this.author = author;
    }
    
    public String getIsbn() {
    return isbn;
    } 
    
    public String getAuthor(){
        return author;
    }

    @Override
    public int getLoanPeriodDays() {
        return LOAN_PERIOD_DAYS;
    }

}
