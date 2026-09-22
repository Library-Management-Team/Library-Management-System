package SystemCode;

import java.math.BigDecimal;
import java.util.List;

public class Library {

    private Catalog catalog;
    private MemberRegistry memberRegistry;
    private ReservationQueue reservationQueue;
    private FineCalculator fineCalculator;
    private LoanService loanService;

    public Library() {

        catalog = new Catalog();
        memberRegistry = new MemberRegistry();
        reservationQueue = new ReservationQueue();
        fineCalculator = new FineCalculator();

        loanService = new LoanService(
                reservationQueue,
                memberRegistry,
                catalog,
                fineCalculator);
    }

    public Member registerMember(String name, String contactInfo, MembershipTier membershipTier) {
        return memberRegistry.registerMember(name, contactInfo, membershipTier);
    }

    public void addItem(LibraryItem item) {
        catalog.addItem(item);
    }

    public List<LibraryItem> getAvailableItems() {
        return catalog.getAvailableItems();
    }

    public List<LibraryItem> getCatalogItems() {
        return catalog.getCatalogItems();
    }

    public BorrowResult borrowItem(Member member, LibraryItem libraryItem) {
        return loanService.borrowItem(member, libraryItem);
    }

    public boolean returnItem(Member member, Copy copy, String condition) {
        return loanService.returnItem(member, copy, condition);
    }

    public boolean reserveItem(Member member, LibraryItem libraryItem) {
        return loanService.reserveItem(member, libraryItem);
    }

    public List<Copy> getCopiesBorrowedBy(Member member) {
        return loanService.getCopiesBorrowedBy(member);
    }

    public BigDecimal getOutstandingBalance(Member member) {
        return member.getOutstandingBalance();
    }

    public void payFine(Member member, BigDecimal amount) {
        member.payFine(amount);
    }
    
    public Reservation getNextReservation(LibraryItem item) {
        return reservationQueue.getNextReservation(item);
    }

}
