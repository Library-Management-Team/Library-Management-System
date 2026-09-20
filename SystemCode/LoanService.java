package SystemCode;

import java.time.LocalDate;
import java.util.ArrayList;

public class LoanService {

    private ArrayList<Loan> loans = new ArrayList<>();
    private ReservationQueue reservationQueue = new ReservationQueue();

    private MemberRegistry memberRegistry = new MemberRegistry();
    private Catalog catalog = new Catalog();

    public BorrowResult borrowItem(Member member, LibraryItem libraryItem) {

        if (!memberRegistry.isMemberRegistered(member))
            return new BorrowResult(null, "The member is not registered");

        if (!catalog.containsItem(libraryItem))
            return new BorrowResult(null, "This item does not exist.");

        if (member.getLoansCount() >= member.getTier().getBorrowingLimit())
            return new BorrowResult(null, "Member has reached the borrowing limit.");

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

        Reservation reservation = reservationQueue.getNextReservation(copy.getItem());

        if (reservation != null) {
            reservation.setHoldDate(LocalDate.now());
            reservation.setHeldCopy(copy);
            copy.markAsHeld();
        }

        return true;
    }

}
