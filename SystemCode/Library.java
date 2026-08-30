package SystemCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Library {

    private static final int MAX_BOOKS_PER_MEMBER = 5;

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<BorrowDetails> loans = new ArrayList<>();

    public Book addBook(String isbn, String title, String author, int availableCopies) {
        Book book = new Book(isbn, title, author, availableCopies);
        books.add(book);
        return book;
    }

    public Member registerMember(String name, String contactInfo) {
        Member member = new Member(name, contactInfo);
        members.add(member);
        return member;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    public boolean borrowBook(int memberId, String isbn) {
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

        if (borrowedBooksCount >= MAX_BOOKS_PER_MEMBER) {
            return false;
        }

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
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

    public boolean returnBook(int memberId, String isbn) {
        Iterator<BorrowDetails> iterator = loans.iterator();

        while (iterator.hasNext()) {
            BorrowDetails loan = iterator.next();

            if (loan.getMember().getId() == memberId
                    && loan.getBook().getIsbn().equals(isbn)) {

                loan.getBook().returnCopy();
                iterator.remove();

                return true;
            }
        }

        return false;
    }

    public List<Book> getBooksBorrowedBy(Member member) {
        List<Book> memberBooks = new ArrayList<>();

        for (BorrowDetails loan : loans) {
            if (loan.getMember().getId() == member.getId()) {
                memberBooks.add(loan.getBook());
            }
        }

        return memberBooks;
    }
}
