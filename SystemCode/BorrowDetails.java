package SystemCode;
import java.time.LocalDate;
public class BorrowDetails {

    private Member member;
    private Copy copy;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BorrowDetails(Member member, Copy copy, LocalDate borrowDate) {
        this.member = member;
        this.copy = copy;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusDays(copy.getTtem().getLoanPeriodDays());
    }

    public Member getMember() {
        return member;
    }

    public Copy getCopy() {
        return copy;
    }

    public LocalDate getBorrowDate(){
        return borrowDate;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }

}
