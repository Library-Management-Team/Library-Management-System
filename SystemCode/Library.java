package SystemCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {

    private static final int MAX_ITEMS_PER_MEMBER = 5;

    private ArrayList<LibraryItem> libraryItems = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<BorrowDetails> loans = new ArrayList<>();

    public void addItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public Member registerMember(String name, String contactInfo) {
        Member member = new Member(name, contactInfo);
        members.add(member);
        return member;
    }

    public List<LibraryItem> getLibraryItems() {
        List<LibraryItem> items = new ArrayList<>();

        for (LibraryItem item : libraryItems) {
            items.add(item);
        }

        return items;
    }

    public boolean borrowItem(Member member, LibraryItem libraryItem) {
        boolean existFlag = false;

        for (Member currentMember : members) {
            if (currentMember.getId().equals(member.getId())) {
                existFlag = true;
                break;
            }
        }

        if (!xistFlag) {
            return false;
        }
        existFlag = false;

        int borrowedItemsCount = 0;

        for (BorrowDetails loan : loans) {
            if (loan.getMember().getId().equals(member.getId())) {
                borrowedItemsCount++;
            }
        }

        if (borrowedItemsCount >= MAX_ITEMS_PER_MEMBER) {
            return false;
        }

        for (LibraryItem item : libraryItems) {
            if (item == libraryItem) {
                existFlag = true;
                break;
            }
        }

        if (!xistFlag) {
            return false;
        }

        Copy copy = null;
        copy = libraryItem.borrowCopy();

        if (copy == null) {
            return false;
        }

        BorrowDetails loan = new BorrowDetails(member, copy);

        loans.add(loan);

        return true;
    }

    public boolean returnBook(int memberId, String isbn) {
        Iterator<BorrowDetails> iterator = loans.iterator();

        while (iterator.hasNext()) {
            BorrowDetails loan = iterator.next();

            if (loan.getMember().getId() == memberId
                    && loan.getBook().getIsbn().equals(isbn)) {

                loan.getBook().returnCopy();
                iterator.remove();

                return true;
            }
        }

        return false;
    }

    public List<Book> getBooksBorrowedBy(Member member) {
        List<Book> memberBooks = new ArrayList<>();

        for (BorrowDetails loan : loans) {
            if (loan.getMember().getId() == member.getId()) {
                memberBooks.add(loan.getBook());
            }
        }

        return memberBooks;
    }
}
