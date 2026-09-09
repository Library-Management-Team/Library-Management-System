package SystemCode;

import java.util.ArrayList;

public abstract class LibraryItem {
    private String title;
    private ArrayList<Copy> copies;

    public LibraryItem(String title) {
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