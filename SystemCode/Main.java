package SystemCode;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        
        library.registerMember("Lana", "lana@gmail.com");
        library.registerMember("Sara", "sara@gmail.com");

        
        library.addBook(1, "Five Feets Apart", "", 2);

        library.addBook(2, "First Head Design Patterns", "", 5);

        library.addBook(3, "The Maze Runner", "", 2);

        
        System.out.println("Available books:");
        library.showAvailableBooks();

        
        System.out.println("\nLana borrows 5 books");

        library.borrowBook(1, 1);
        library.borrowBook(1, 2);
        library.borrowBook(1, 3);
        library.borrowBook(1, 1);
        library.borrowBook(1, 2);

       
        System.out.println("\nTrying to borrow sixth book:");

        boolean result = library.borrowBook(1, 2);

        if (!result) {
            System.out.println("Borrow failed.");
        }

        
        System.out.println("\nLana's books:");

        library.showMemberBooks(1);

        System.out.println("\nSara tries to borrow Design Patterns:");

        result = library.borrowBook(2, 3);

        if (!result) {
            System.out.println("Borrow failed: no available copies.");
        }

    
        System.out.println("\nLana returns Five Feets Apart");

        result = library.returnBook(1, 1);

        if (result) {
            System.out.println("Book returned successfully.");
        }

        System.out.println("\nSara borrows Five Feets Apart");

        result = library.borrowBook(2, 1);

        if (result) {
            System.out.println("Book borrowed successfully.");
        }

        System.out.println("\nAvailable books after all operations:");

        library.showAvailableBooks();
    }
}
