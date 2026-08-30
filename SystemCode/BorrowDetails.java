package SystemCode;
import java.time.LocalDate;
public class BorrowDetails {

    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BorrowDetails(Member member, Book book, LocalDate borrowDate) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusDays(14);
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate(){
        return borrowDate;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }

}
