package SystemCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanService {

    private ArrayList<Loan> loans = new ArrayList<>();
    private ReservationQueue reservationQueue;
    private MemberRegistry memberRegistry;
    private Catalog catalog;
    private FineCalculator fineCalculator;

    public LoanService(ReservationQueue reservationQueue, MemberRegistry memberRegistry, Catalog catalog,
            FineCalculator fineCalculator) {

        this.reservationQueue = reservationQueue;
        this.memberRegistry = memberRegistry;
        this.catalog = catalog;
        this.fineCalculator = fineCalculator;
    }

    public BorrowResult borrowItem(Member member, LibraryItem libraryItem) {

        if (!memberRegistry.isMemberRegistered(member))
            return new BorrowResult(null, "The member is not registered");

        if (!catalog.containsItem(libraryItem))
            return new BorrowResult(null, "This item does not exist.");

        if (member.getLoansCount() >= member.getTier().getBorrowingLimit())
            return new BorrowResult(null, "Member has reached the borrowing limit.");

        if (member.getOutstandingBalance().compareTo(MembershipLimits.MAX_OUTSTANDING_FINE) > 0)
            return new BorrowResult(null, "Member has outstanding fines over $10.");

        Reservation reservation = reservationQueue.getNextReservation(libraryItem);

        if (reservation != null) {

            if (reservation.getHoldDate() != null
                    && reservation.getHoldDate().plusDays(3).isBefore(LocalDate.now())) {

                Copy heldCopy = reservation.getHeldCopy();
                reservationQueue.removeReservation(reservation);

                reservation = reservationQueue.getNextReservation(libraryItem);

                if (reservation != null) {
                    reservation.setHoldDate(LocalDate.now());
                    reservation.setHeldCopy(heldCopy);
                }
            }

            if (reservation != null && reservation.getHoldDate() != null
                    && reservation.getMember() != member) {

                return new BorrowResult(null, "This item is reserved for another member.");
            }

        }
        Copy copy;
        if (reservation != null
                && reservation.getHoldDate() != null
                && reservation.getMember() == member) {

            copy = reservation.getHeldCopy();

        } else {
            copy = libraryItem.borrowCopy();
        }

        if (copy == null)
            return new BorrowResult(null, "There is no available copy.");

        Loan loan = new Loan(member, copy);
        loans.add(loan);

        member.incrementLoansCount();

        if (reservation != null
                && reservation.getMember() == member) {

            reservationQueue.removeReservation(reservation);
            copy.releaseHold();
        }

        return new BorrowResult(loan, "Borrow successful.");

    }

    public boolean reserveItem(Member member, LibraryItem libraryItem) {

        if (!memberRegistry.isMemberRegistered(member))
            return false;

        if (!catalog.containsItem(libraryItem))
            return false;

        if (libraryItem.isAvailable())
            return false;

        reservationQueue.addReservation(libraryItem, member);

        return true;
    }

    public boolean returnItem(Member member, Copy copy, String condition) {
        Loan loanToRemove = null;

        for (Loan loan : loans) {
            if (loan.getMember().getId().equals(member.getId())
                    && loan.getCopy().getCopyId().equals(copy.getCopyId())) {

                copy.getItem().returnCopy(copy, condition);
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
            loans.remove(loanToRemove);
            member.decrementLoansCount();
        } else
            return false;

        BigDecimal fine = fineCalculator.calculateFine(loanToRemove);

        if (fine.compareTo(BigDecimal.ZERO) > 0) {
            member.addFine(fine);
        }
        Reservation reservation = reservationQueue.getNextReservation(copy.getItem());

        if (reservation != null) {
            reservation.setHoldDate(LocalDate.now());
            reservation.setHeldCopy(copy);
            copy.markAsHeld();
        }

        return true;
    }

    public List<Copy> getCopiesBorrowedBy(Member member) {

        List<Copy> copies = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getMember().getId().equals(member.getId())) {
                copies.add(loan.getCopy());
            }
        }

        return copies;
    }

}
