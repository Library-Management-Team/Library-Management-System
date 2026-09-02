package SystemCode;

public class Copy {
    private static int nextCopyId = 1;

    private String copyId;
    private String condition;
    private boolean available;
    private LibraryItem item;

    public Copy(LibraryItem item) {
        this.item = item;
        copyId = String.valueOf(nextCopyId++);
        condition = "New";
        available = true;
    }
    
    public LibraryItem getItem() {
        return item;
    }

    public String getCopyId() {
        return copyId;
    }

    public String getCondition() {
        return condition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markAsBorrowed() {
        available = false;
    }

    public void markAsAvailable() {
        available = true;
    }
}