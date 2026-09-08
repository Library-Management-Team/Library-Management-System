package SystemCode;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        Member lana = library.registerMember("Lana", "lana@gmail.com");
        Member sara = library.registerMember("Sara", "sara@gmail.com");

        System.out.println("\nLibrary Members: ");

        System.out.println(lana.getName() + " - " + lana.getContactInfo());

        System.out.println(sara.getName() + " - " + sara.getContactInfo());

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

                System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Available copies: "
                        + book.getAvailableCopiesCount());

            }

        } else {

            System.out.println("There are no available books.");

        }

        BorrowDetails loan = library.borrowBook(lana.getId(), dataStrucBook.getIsbn());

        if (loan != null) {

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed.");

        }

        loan = library.borrowBook(lana.getId(), javaBook.getIsbn());

        if (loan != null) {

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed.");

        }

        loan = library.borrowBook(lana.getId(), oopBook.getIsbn());

        if (loan != null) {

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed.");

        }

        loan = library.borrowBook(lana.getId(), dataStrucBook.getIsbn());

        if (loan != null) {

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed.");

        }

        loan = library.borrowBook(lana.getId(), javaBook.getIsbn());

        if (loan != null) {

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed.");

        }

        List<Book> lanaBooks = library.getBooksBorrowedBy(lana);

        if (!lanaBooks.isEmpty()) {

            System.out.println("\n" + lana.getName() + " has borrowed " + lanaBooks.size() + " books.");

            for (Book book : lanaBooks) {

                System.out.println("  " + book.getTitle() + " by " + book.getAuthor());

            }

        } else {

            System.out.println("\nLana doesn't borrow any book yet.");

        }

        System.out.println("\nLana trying to borrow sixth book:");

        loan = library.borrowBook(
                lana.getId(), javaBook.getIsbn());

        if (loan != null) {

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed: Lana has reached the 5-book limit.");

        }

        System.out.println("\nSara tries to borrow Java book.");

        loan = library.borrowBook(
                sara.getId(), javaBook.getIsbn());

        if (loan != null) {

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed: no available copies.");

        }

        System.out.println("\nLana returns Java book");

        boolean result = library.returnBook(
                lana.getId(), javaBook.getIsbn());

        if (result) {

            System.out.println("Book returned successfully.");

        } else {

            System.out.println("Return failed.");

        }

        System.out.println("\nSara wants to borrow Java book.");

        loan = library.borrowBook(
                sara.getId(), javaBook.getIsbn());

        if (loan != null) {

            System.out.println("Book borrowed successfully.");

            System.out.println("Borrowed " + loan.getBook().getTitle() + " - due " + loan.getDueDate());

        } else {

            System.out.println("Borrow failed: no available copies.");

        }

        System.out.println("\nAvailable books after all operations:");

        List<Book> availableBooksNow = library.getAvailableBooks();

        if (!availableBooksNow.isEmpty()) {

            System.out.println("Available books:");

            for (Book book : availableBooksNow) {

                System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Available copies: "
                        + book.getAvailableCopiesCount());

            }

        } else {

            System.out.println("There are no available books.");

        }

    }

}
