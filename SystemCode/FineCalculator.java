package SystemCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {
    private static final BigDecimal FINE_PER_DAY = new BigDecimal("0.50");

    public BigDecimal calculateFine(Loan loan) {

        LocalDate dueDate = loan.getDueDate();
        LocalDate returnDate = LocalDate.now();

        if (!returnDate.isAfter(dueDate)) {
            return BigDecimal.ZERO;
        }

        long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);

        BigDecimal fine = FINE_PER_DAY.multiply(BigDecimal.valueOf(lateDays));

        if (loan.getMember().getTier() == MembershipTier.PREMIUM) {
            fine = fine.divide(BigDecimal.valueOf(2));
        }

        return fine;

    
    }
}
