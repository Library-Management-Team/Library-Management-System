package SystemCode;
import java.util.List;
public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        Member lana = library.registerMember("Lana", "lana@gmail.com");
        Member sara = library.registerMember("Sara", "sara@gmail.com");

        Book dataStrucBook = library.addBook(
                "1", "Data Structure", "Robert", 2);

        Book javaBook = library.addBook(
                "2", "Java", "John", 2);

        Book oopBook = library.addBook(
                "3", "Object Oriented Programming", "Martin", 2);

        List<Book> availableBooks = library.getAvailableBooks();

        if (!availableBooks.isEmpty()) {
            System.out.println("Available books:");

            for (Book book : availableBooks) {
                System.out.println(book.getTitle());
            }
        } else {
            System.out.println("There are no available books.");
        }

        library.borrowBook(lana.getId(), dataStrucBook.getIsbn());
        library.borrowBook(lana.getId(), javaBook.getIsbn());
        library.borrowBook(lana.getId(), oopBook.getIsbn());
        library.borrowBook(lana.getId(), dataStrucBook.getIsbn());
        library.borrowBook(lana.getId(), javaBook.getIsbn());

        List<Book> lanaBooks = library.getBooksBorrowedBy(lana);

        if (!lanaBooks.isEmpty()) {
            System.out.println("\nLana borrows : "
                    + lanaBooks.size() + " books.");
        } else {
            System.out.println("\nLana doesn't borrow any book yet.");
        }

        System.out.println("\nLana trying to borrow sixth book:");

        boolean result = library.borrowBook(
                lana.getId(), javaBook.getIsbn());

        if (!result) {
            System.out.println("Borrow failed.");
        } else {
            System.out.println("Borrow successful.");
        }

        System.out.println("\nSara tries to borrow Java book.");

        result = library.borrowBook(
                sara.getId(), javaBook.getIsbn());

        if (!result) {
            System.out.println("Borrow failed: no available copies.");
        } else {
            System.out.println("Borrow successful.");
        }

        System.out.println("\nLana returns Java book");

        result = library.returnBook(
                lana.getId(), javaBook.getIsbn());

        if (result) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Return failed.");
        }

        System.out.println("\nSara wants to borrow Java book.");

        result = library.borrowBook(
                sara.getId(), dataStrucBook.getIsbn());

        if (result) {
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Borrow failed: no available copies.");
        }

        System.out.println("\nAvailable books after all operations:");

        List<Book> availableBooksNow = library.getAvailableBooks();

        if (!availableBooksNow.isEmpty()) {
            System.out.println("Available books:");

            for (Book book : availableBooksNow) {
                System.out.println(book.getTitle());
            }
        } else {
            System.out.println("There are no available books.");
        }
    }
}
