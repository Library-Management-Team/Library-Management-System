package SystemCode;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private ArrayList<LibraryItem> libraryItems = new ArrayList<>();

    public void addItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public List<LibraryItem> getCatalogItems() {
        List<LibraryItem> items = new ArrayList<>();

        for (LibraryItem item : libraryItems) {
            items.add(item);
        }

        return items;
    }

    public List<LibraryItem> getAvailableItems() {
        List<LibraryItem> items = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.isAvailable())
                items.add(item);
        }
        return items;
    }

    public boolean containsItem(LibraryItem item) {
        for (LibraryItem currentItem : libraryItems) {
            if (currentItem == item) {
                return true;
            }
        }
        return false;
    }

}
