package SystemCode;

public class Book extends LibraryItem {
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
        return 14;
    }

}
