package SystemCode;

import java.time.LocalDate;

public class Loan {

    private Member member;
    private Copy copy;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public Loan(Member member, Copy copy) {

        if (member == null || copy == null) {
            throw new IllegalArgumentException("Member and copy cannot be null.");
        }
        
        this.member = member;
        this.copy = copy;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(copy.getItem().getLoanPeriodDays());
    }

    public Member getMember() {
        return member;
    }

    public Copy getCopy() {
        return copy;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}
