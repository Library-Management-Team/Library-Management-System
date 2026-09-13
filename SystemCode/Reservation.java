package SystemCode;

public class Reservation {
    private LibraryItem libraryItem;
    private Member member;

    public Reservation(LibraryItem libraryItem, Member member) {
        this.libraryItem = libraryItem;
        this.member = member;
    }

    public LibraryItem getLibraryItem() {
        return libraryItem;
    }

    public Member getMember() {
        return member;
    }


}
