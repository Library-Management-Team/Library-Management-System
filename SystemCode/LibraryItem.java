package SystemCode;

import java.util.ArrayList;

public abstract class LibraryItem {
    private String title;
    private ArrayList<Copy> copies;

    public LibraryItem(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
        this.copies = new ArrayList<>();
    }

    public boolean isAvailable() {
        for (Copy copy : copies) {
            if (copy.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public Copy borrowCopy() {
        for (Copy copy : copies) {
            if (copy.isAvailable()) {
                copy.markAsBorrowed();
                return copy;
            }
        }

        return null;
    }

    public void returnCopy(Copy copy, String condition) {
        copy.markAsAvailable();
        copy.setCondition(condition);

    }

    public String getTitle() {
        return title;
    }

    public void addCopy(Copy copy) {
        copies.add(copy);
    }

    public void addCopies(int numberOfCopies) {

        if (numberOfCopies < 0) {
            throw new IllegalArgumentException(
                    "Number of copies cannot be negative."
            );
        }

        for (int i = 0; i < numberOfCopies; i++) {
            addCopy(new Copy(this));
        }
    }

    public ArrayList<Copy> getCopies() {
        ArrayList<Copy> copyList = new ArrayList<>();

        for (Copy copy : copies) {
            copyList.add(copy);
        }

        return copyList;
    }

    public abstract int getLoanPeriodDays();

    public abstract String getItemType();

}