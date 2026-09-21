package SystemCode;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {
    private static final double FINE_PER_DAY = 0.50;

    public double calculateFine(Loan loan) {

        LocalDate dueDate = loan.getDueDate();
        LocalDate returnDate = LocalDate.now();

        if (!returnDate.isAfter(dueDate)) {
            return 0.0;
        }

        long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);

        double fine = lateDays * FINE_PER_DAY;

        if (loan.getMember().getTier() == MembershipTier.PREMIUM) {
            fine = fine / 2;
        }

        return fine;

    }
}
