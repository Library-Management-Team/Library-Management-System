package SystemCode;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // Add a book with 3 copies.
        Book dataStructureBook = new Book("1", "Data Structure", "Robert");
        library.addItem(dataStructureBook);
        Copy bookCopy1 = new Copy(dataStructureBook);
        Copy bookCopy2 = new Copy(dataStructureBook);
        Copy bookCopy3 = new Copy(dataStructureBook);
        dataStructureBook.addCopy(bookCopy1);
        dataStructureBook.addCopy(bookCopy2);
        dataStructureBook.addCopy(bookCopy3);

        // Add a magazine with 1 copy.
        Magazine magazine = new Magazine("Science Magazine", "10", "August 2026");
        library.addItem(magazine);
        Copy magazineCopy = new Copy(magazine);
        magazine.addCopy(magazineCopy);

        // Add a DVD with 2 copies.
        DVD dvd = new DVD("The Matrix", "Lana", 136);
        library.addItem(dvd);
        Copy dvdCopy1 = new Copy(dvd);
        Copy dvdCopy2 = new Copy(dvd);
        dvd.addCopy(dvdCopy1);
        dvd.addCopy(dvdCopy2);

        // Register 2 members.
        Member lana = library.registerMember("Lana", "lana@gmail.com");
        Member sara = library.registerMember("Sara", "sara@gmail.com");

        System.out.println("\nLibrary Members: ");
        System.out.println(lana.getName() + " - " + lana.getContactInfo());
        System.out.println(sara.getName() + " - " + sara.getContactInfo());

        // Borrow one of each type and print the due date for each.
        System.out.println("--- Borrow one of each type ---");

        BorrowDetails loan = library.borrowItem(lana, dataStructureBook);
        if (loan != null) {
            System.out.println(loan.getMember().getName()
                    + " borrowed: " + loan.getCopy().getItem().getTitle()
                    + " at " + loan.getBorrowDate()
                    + " - Book due date: " + loan.getDueDate());
        } else {
            System.out.println("Book borrow failed.");
        }

        loan = library.borrowItem(lana, magazine);
        if (loan != null) {
            System.out.println(loan.getMember().getName()
                    + " borrowed: " + loan.getCopy().getItem().getTitle()
                    + " at " + loan.getBorrowDate()
                    + " - Magazine due date: " + loan.getDueDate());
        } else {
            System.out.println("Magazine borrow failed.");
        }

        BorrowDetails loan3 = library.borrowItem(lana, dvd);
        if (loan3 != null) {
            System.out.println(loan3.getMember().getName()
                    + " borrowed: " + loan3.getCopy().getItem().getTitle()
                    + " at " + loan3.getBorrowDate()
                    + " - DVD due date: " + loan3.getDueDate());
        } else {
            System.out.println("DVD borrow failed.");
        }

        // Print the available items.
        System.out.println("\n--- Available items ---");

        List<LibraryItem> availableItems = library.getAvailableItems();
        if (!availableItems.isEmpty()) {
            System.out.println("Available items:");
            for (LibraryItem item : availableItems) {
                System.out.println(item.getTitle()
                        + " - " + item.getClass().getSimpleName());
            }
        } else {
            System.out.println("There are no available items.");
        }

        // Test the 5-item limit.
        System.out.println("\n--- Testing the 5-item limit ---");

        loan = library.borrowItem(lana, dataStructureBook);
        if (loan != null) {
            System.out.println("Second book copy borrowed successfully.");
        } else {
            System.out.println("Borrow failed.");
        }

        loan = library.borrowItem(lana, dataStructureBook);
        if (loan != null) {
            System.out.println("Third book copy borrowed successfully.");
        } else {
            System.out.println("Borrow failed.");
        }

        System.out.println("Lana has borrowed "
                + library.getCopiesBorrowedBy(lana).size()
                + " items.");

        System.out.println("\nLana tries to borrow a sixth item:");

        loan = library.borrowItem(lana, dvd);
        if (loan != null) {
            System.out.println("Borrow successful.");
        } else {
            System.out.println("Borrow failed: Lana has reached the 5-item limit.");
        }

        // Test unavailable magazine copy.
        System.out.println("\n--- Testing unavailable magazine copy ---");
        System.out.println("Magazine available: " + magazine.isAvailable());

        // Return Lana's magazine copy.
        List<Copy> lanaCopies = library.getCopiesBorrowedBy(lana);
        Copy borrowedMagazineCopy = null;

        for (Copy copy : lanaCopies) {
            if (copy.getItem() == magazine) {
                borrowedMagazineCopy = copy;
                break;
            }
        }

        if (borrowedMagazineCopy != null) {
            boolean result = library.returnItem(lana, borrowedMagazineCopy, "Worn");
            if (result) {
                System.out.println("Magazine copy returned successfully.");
            } else {
                System.out.println("Magazine return failed.");
            }
        }

        BorrowDetails loan4 = library.borrowItem(sara, magazine);
        if (loan4 != null) {
            System.out.println("Sara borrowed the magazine.");
        } else {
            System.out.println("Magazine borrow failed.");
        }

        // Print the item's copies with their conditions.
        System.out.println("\n--- Items and their copies ---");

        for (LibraryItem item : library.getLibraryItems()) {
            System.out.println(item.getTitle()
                    + " - " + item.getClass().getSimpleName());

            for (Copy copy : item.getCopies()) {
                System.out.println("  Copy ID: " + copy.getCopyId()
                        + " - Condition: " + copy.getCondition());
            }
        }

        // Print the available items again.
        System.out.println("\n--- Available items after return ---");

        availableItems = library.getAvailableItems();
        if (!availableItems.isEmpty()) {
            System.out.println("Available items:");

            for (LibraryItem item : availableItems) {
                System.out.println(item.getTitle()
                        + " - " + item.getClass().getSimpleName());
            }
        } else {
            System.out.println("There are no available items.");
        }
    }
}