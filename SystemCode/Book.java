package SystemCode;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int availableCopies;

    public Book(String isbn, String title, String author, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public boolean isAvailable(){
        return availableCopies > 0;
    }

    public String getTitle() {
        return title;
    }
    
    public String getIsbn() {
    return isbn;
    } 
    
    public void borrowCopy(){
        availableCopies--;
    }

    public void returnCopy(){
        availableCopies++;
    }
    
    
}
