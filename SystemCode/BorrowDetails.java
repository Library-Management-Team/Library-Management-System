package SystemCode;
import java.time.LocalDate;
public class BorrowDetails {

    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    BorrowDetails(Member member, Book book, LocalDate borrowDate) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusDays(14);
    }

    Member getMember() {
        return member;
    }

    Book getBook() {
        return book;
    }

}
