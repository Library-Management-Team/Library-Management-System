package SystemCode;

import java.time.LocalDate;

public class Reservation {
    private LibraryItem libraryItem;
    private Member member;
    private LocalDate holdDate;
    private Copy heldCopy;

    public Reservation(LibraryItem libraryItem, Member member) {
        if (libraryItem == null || member == null) {
            throw new IllegalArgumentException("Library item and member cannot be null.");
        }
        this.libraryItem = libraryItem;
        this.member = member;
    }

    public LibraryItem getLibraryItem() {
        return libraryItem;
    }

    public Member getMember() {
        return member;
    }

    public void setHoldDate(LocalDate holdDate){
        this.holdDate = holdDate;
    }

    public LocalDate getHoldDate(){
        return holdDate;
    }

    public Copy getHeldCopy() {
        return heldCopy;
    }

    public void setHeldCopy(Copy heldCopy) {
        this.heldCopy = heldCopy;
    }

}
