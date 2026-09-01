package SystemCode;
import java.util.ArrayList;
public abstract class LibraryItem {
    private String title;
    private ArrayList<Copy> copies;

    public LibraryItem(String title) {
        this.title = title;
        this.copies = new ArrayList<>();
    }
    public String getTitle(){
        return title;
    }
    public abstract int getLoanPeriodDays();

}