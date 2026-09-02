package SystemCode;

import java.util.ArrayList;
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

    public BorrowDetails borrowItem(Member member, LibraryItem libraryItem) {
        boolean existFlag = false;

        for (Member currentMember : members) {
            if (currentMember.getId().equals(member.getId())) {
                existFlag = true;
                break;
            }
        }

        if (!existFlag) {
            return null;
        }
        existFlag = false;

        int borrowedItemsCount = 0;

        for (BorrowDetails loan : loans) {
            if (loan.getMember().getId().equals(member.getId())) {
                borrowedItemsCount++;
            }
        }

        if (borrowedItemsCount >= MAX_ITEMS_PER_MEMBER) {
            return null;
        }

        for (LibraryItem item : libraryItems) {
            if (item == libraryItem) {
                existFlag = true;
                break;
            }
        }

        if (!existFlag) {
            return null;
        }

        Copy copy = libraryItem.borrowCopy();

        if (copy == null) {
            return null;
        }

        BorrowDetails loan = new BorrowDetails(member, copy);

        loans.add(loan);

        return loan;
    }

    public boolean returnItem(Member member, Copy copy, String condition) {
        BorrowDetails loanToRemove = null;

        for (BorrowDetails loan : loans) {
            if (loan.getMember().getId().equals(member.getId())
                    && loan.getCopy().getCopyId().equals(copy.getCopyId())) {

                copy.getItem().returnCopy(copy, condition);
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
            loans.remove(loanToRemove);
            return true;
        }

        return false;
    }

    public List<Copy> getCopiesBorrowedBy(Member member) {
        List<Copy> copies = new ArrayList<>();

        for (BorrowDetails loan : loans) {
            if (loan.getMember().getId().equals(member.getId())) {
                copies.add(loan.getCopy());
            }
        }

        return copies;
    }

    public List<LibraryItem> getAvailableItems() {
        List<LibraryItem> items = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.isAvailable())
                items.add(item);
        }
        return items;
    }
}
