package SystemCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();


        Member lana = library.registerMember(
                "Lana",
                "lana@email.com",
                MembershipTier.STANDARD
        );

        Member sara = library.registerMember(
                "Sara",
                "sara@email.com",
                MembershipTier.PREMIUM
        );

        System.out.println(lana.getName() + " " + lana.getContactInfo() + " " + lana.getTier());
        System.out.println(sara.getName() + " " + sara.getContactInfo() + " " + sara.getTier());

        Book java = new Book(
                "111",
                "Java",
                "John"
        );

        Copy javaCopy1 = new Copy(java);
        Copy javaCopy2 = new Copy(java);

        java.addCopy(javaCopy1);
        java.addCopy(javaCopy2);

        library.addItem(java);

        BorrowResult lanaJava = library.borrowItem(lana, java);
        BorrowResult saraJava = library.borrowItem(sara, java);

        if (lanaJava.isSuccess()) {
            System.out.println(lana.getName() + " "
                    + lana.getTier()
                    + " due date: "
                    + lanaJava.getLoan().getDueDate()
            );
        } else {
            System.out.println(
                    "Lana could not borrow Java: "
                    + lanaJava.getFailureReason()
            );
        }

        if (saraJava.isSuccess()) {
            System.out.println(sara.getName() + " "
                    + sara.getTier()
                    + " due date: "
                    + saraJava.getLoan().getDueDate()
            );
        } else {
            System.out.println(
                    "Sara could not borrow Java: "
                    + saraJava.getFailureReason()
            );
        }

        System.out.println("lana and sara borrows the same item\n");


        Book cpp = new Book("201", "C++", "Mike");
        Book oop = new Book("202", "OOP", "Tom");
        Book dsa = new Book("203", "DSA", "Alex");
        Book database = new Book("204", "Database", "Sam");
        Book html = new Book("205", "HTML", "Adam");
        Book css = new Book("206", "CSS", "Adam");

        Book[] premiumItems = {
                cpp, oop, dsa, database, html, css
        };

        for (Book item : premiumItems) {

            item.addCopy(new Copy(item));
            library.addItem(item);

            BorrowResult result =
                    library.borrowItem(sara, item);

            if (result.isSuccess()) {

                System.out.println(
                        "Sara successfully borrowed: "
                        + item.getTitle()
                );

            } else {

                System.out.println(
                        "Sara failed to borrow "
                        + item.getTitle()
                        + ": "
                        + result.getFailureReason()
                );
            }
        }

        System.out.println(
                "Sara currently has "
                + sara.getLoansCount()
                + " borrowed items."
        );

        if (sara.getLoansCount() >= 6) {

            System.out.println(
                    "PASS: Premium member can borrow 6+ items."
            );

        } else {

            System.out.println(
                    "FAIL: Premium member could not borrow 6 items."
            );
        }

                
        Book python = new Book("301", "Python", "John");
        Book javascript = new Book("302", "JavaScript", "John");
        Book algorithms = new Book("303", "Algorithms", "John");
        Book web = new Book("304", "Web", "John");

        Book[] lanaItems = {
                python, javascript, algorithms, web
        };

        for (Book item : lanaItems) {

            item.addCopy(new Copy(item));
            library.addItem(item);

            BorrowResult result =
                    library.borrowItem(lana, item);

            if (result.isSuccess()) {

                System.out.println(
                        "Lana successfully borrowed: "
                        + item.getTitle()
                );

            } else {

                System.out.println(
                        "Lana failed to borrow "
                        + item.getTitle()
                        + ": "
                        + result.getFailureReason()
                );
            }
        }

        System.out.println(
                "Lana currently has "
                + lana.getLoansCount()
                + " borrowed items."
        );

        // Lana already has 5 items
        Book sixthItem = new Book(
                "305",
                "Operating Systems",
                "John"
        );

        sixthItem.addCopy(new Copy(sixthItem));
        library.addItem(sixthItem);

        BorrowResult sixthResult =
                library.borrowItem(lana, sixthItem);

        if (sixthResult.isSuccess()) {

            System.out.println(
                    "Lana was allowed to borrow a sixth item."
            );

        } else {

            System.out.println(
                    "Lana was refused the sixth item."
            );

            System.out.println(
                    "Reason: "
                    + sixthResult.getFailureReason()
            );
        }

        Book reservedBook = new Book(
                "401",
                "C++ Basics",
                "Mike"
        );

        Copy reservedCopy1 = new Copy(reservedBook);
        Copy reservedCopy2 = new Copy(reservedBook);

        reservedBook.addCopy(reservedCopy1);
        reservedBook.addCopy(reservedCopy2);

        library.addItem(reservedBook);

          // Sara borrows first copy
        BorrowResult firstBorrow =
                library.borrowItem(sara, reservedBook);

        // Lana cannot borrow because she is already at her limit,
        // so use Sara for another item? Sara can borrow the second copy.
        BorrowResult secondBorrow =
                library.borrowItem(sara, reservedBook);

        System.out.println(
                "First copy borrowed: "
                + firstBorrow.isSuccess()
        );

        System.out.println(
                "Second copy borrowed: "
                + secondBorrow.isSuccess()
        );

         // Create another member so the reservation is genuinely
        // made by another member.
        Member reservationMember = library.registerMember(
                "Maya",
                "maya@email.com",
                MembershipTier.STANDARD
        );

        boolean reservation =
                library.reserveItem(
                        reservationMember,
                        reservedBook
                );

        if (reservation) {

            System.out.println(
                    "Maya successfully reserved C++ Basics."
            );

            System.out.println(
                    "Queue position: 1"
            );

        } else {

            System.out.println(
                    "Maya could not reserve C++ Basics."
            );
        }


        // RETURN → COPY IS HELD

        System.out.println("\nRETURNED COPY IS HELD BY MAYA\n");

        // Mohammed is the second member in the reservation queue
        Member mohammed = library.registerMember(
                "Mohammed",
                "mohammed@email.com",
                MembershipTier.STANDARD
        );

        // Mohammed reserves the same book
        library.reserveItem(mohammed, reservedBook);

        // Sara returns one copy
        List<Copy> saraCopies =
                library.getCopiesBorrowedBy(sara);

        Copy copyToReturn = null;

        for (Copy copy : saraCopies) {

            if (copy.getItem() == reservedBook) {
                copyToReturn = copy;
                break;
            }
        }

        if (copyToReturn != null) {

            boolean returned =
                    library.returnItem(
                            sara,
                            copyToReturn,
                            "Good"
                    );

            System.out.println(
                    "Return successful: " + returned
            );

            System.out.println(
                    "Copy is held: "
                    + copyToReturn.isHeld()
            );

            System.out.println(
                    "Copy is generally available: "
                    + copyToReturn.isAvailable()
            );

            if (returned
                    && copyToReturn.isHeld()
                    && !copyToReturn.isAvailable()) {

                System.out.println(
                        "Returned copy is held for Maya."
                );

            } else {

                System.out.println(
                        "Copy was not held correctly."
                );
            }

            // Make Maya's reservation expired
            Reservation mayaReservation =
                    library.getNextReservation(reservedBook);

            if (mayaReservation != null) {

                mayaReservation.setHoldDateForDemo(
                        LocalDate.now().minusDays(4)
                );

                System.out.println(
                        "Maya's reservation has expired."
                );
            }
            System.out.println("Mohammed reserved the C++ Basics\n");
            // Mohammed tries to borrow
            BorrowResult mohammedResult =
                    library.borrowItem(
                            mohammed,
                            reservedBook
                    );

            System.out.println(
                    "Mohammed borrow successful: "
                    + mohammedResult.isSuccess()
            );

            if (mohammedResult.isSuccess()) {

                System.out.println(
                        "Reservation moved from Maya to Mohammed."
                );

            } else {

                System.out.println(
                        "Mohammed could not borrow the item."
                );

                System.out.println(
                        "Reason: "
                        + mohammedResult.getFailureReason()
                );
            }

        } else {

            System.out.println(
                    "Could not find a copy to return."
            );
        }

        // Lana now has 5 loans, so we must return one first
        // because requirement #9 needs the borrow to genuinely succeed.

        List<Copy> lanaCopies =
                library.getCopiesBorrowedBy(lana);

        if (!lanaCopies.isEmpty()) {

            Copy copyToReturnForLimit =
                    lanaCopies.get(0);

            library.returnItem(
                    lana,
                    copyToReturnForLimit,
                    "Good"
            );
            System.out.println("lana returns one item");
        // We can genuinely create a balance > $10
        // using the current public API.
        lana.addFine(new BigDecimal("11.00"));

        System.out.println(
                "Lana outstanding balance: $"
                + library.getOutstandingBalance(lana)
        );

        Book fineBook = new Book(
                "801",
                "Fine Test",
                "John"
        );

        fineBook.addCopy(new Copy(fineBook));
        library.addItem(fineBook);

        System.out.println("\nlana want to borrow item: ");
        BorrowResult fineResult =
                library.borrowItem(lana, fineBook);

        if (fineResult.isSuccess()) {

            System.out.println(
                    "Lana was allowed to borrow."
            );

        } else {

            System.out.println(
                    "Reason: "
                    + fineResult.getFailureReason()
            );
        }

        library.payFine(
                lana,
                new BigDecimal("11.00")
        );

        System.out.println(
                "Lana outstanding balance after payment: $"
                + library.getOutstandingBalance(lana)
        );

        
        

        Book afterPaymentBook = new Book(
                "802",
                "After Payment",
                "John"
        );

        afterPaymentBook.addCopy(
                new Copy(afterPaymentBook)
        );

        library.addItem(afterPaymentBook);

        BorrowResult afterPaymentResult =
                library.borrowItem(
                        lana,
                        afterPaymentBook
                );

        if (afterPaymentResult.isSuccess()) {

            System.out.println(
                    "Lana paid the fine and borrowed successfully."
            );

        } else {

            System.out.println(
                    "Lana could not borrow after paying."
            );

            System.out.println(
                    "Reason: "
                    + afterPaymentResult.getFailureReason()
            );
        }


        try {

            Book invalidBook = new Book(
                    "999",
                    "Invalid Book",
                    "Unknown"
            );

            invalidBook.addCopies(-2);

            System.out.println(
                    "FAIL: Negative copies were accepted."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "PASS: Negative copies were rejected."
            );

            System.out.println(
                    "Reason: " + e.getMessage()
            );
        }


    }
}}