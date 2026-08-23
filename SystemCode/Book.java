package SystemCode;

public class Book {
    private int ISBN;
    private String title;
    private String author;
    private int availableCopies;

    Book(int iSBN, String title, String author, int availableCopies) {
        ISBN = iSBN;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    boolean isAvailable(){
        if(availableCopies > 0)
            return true;
        return false;
    }

    String getTitle() {
        return title;
    }
    
    int getIsbn() {
    return ISBN;
    } 
    
    void borrowCopy(){
        availableCopies--;
    }

    void returnCopy(){
        availableCopies++;
    }
    
    
}
