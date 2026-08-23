package SystemCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<BorrowDetails> loans = new ArrayList<>();

    public void addBook(int isbn, String title, String author, int availableCopies) {

        Book book = new Book(isbn, title, author, availableCopies);
        books.add(book);
    }

    public void registerMember(String name, String contactInfo) {

        Member member = new Member(name, contactInfo);
        members.add(member);
    }

    public void showAvailableBooks() {

        for (Book book : books) {

            if (book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }

    public boolean borrowBook(int memberId, int isbn) {

        Book requestedBook = null;
        Member member = null;

        for (Member currentMember : members) {

            if (currentMember.getId() == memberId) {
                member = currentMember;
                break;
            }
        }

        if (member == null) {
            return false;
        }

        
        int borrowedBooksCount = 0;

        for (BorrowDetails loan : loans) {

            if (loan.getMember().getId() == memberId) {
                borrowedBooksCount++;
            }
        }

        if (borrowedBooksCount >= 5) {
            return false;
        }

        for (Book book : books) {

            if (book.getIsbn() == isbn) {
                requestedBook = book;
                break;
            }
        }

        if (requestedBook == null || !requestedBook.isAvailable()) {
            return false;
        }

        LocalDate borrowDate = LocalDate.now();

        BorrowDetails loan = new BorrowDetails(member, requestedBook, borrowDate);

        requestedBook.borrowCopy();

        loans.add(loan);

        return true;
    }

    public boolean returnBook(int memberId, int isbn) {

        Iterator<BorrowDetails> iterator = loans.iterator();

        while (iterator.hasNext()) {

            BorrowDetails loan = iterator.next();

            if (loan.getMember().getId() == memberId && loan.getBook().getIsbn() == isbn) {

                loan.getBook().returnCopy();
                iterator.remove();

                return true;
            }
        }

        return false;
    }

    public void showMemberBooks(int memberId) {

        for (BorrowDetails loan : loans) {

            if (loan.getMember().getId() == memberId) {
                System.out.println(loan.getBook().getTitle());
            }
        }
    }
}