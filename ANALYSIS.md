## Analyze the requirements

>> For Milestone 1:

1. **Entities/classes**

- Library => Responsible for basic operations, such as adding new books or members.
- Book => It holds the book's information.
- Member => It records information about who borrows books from the library.
- BorrowDetails => It contains lending information, such as the borrowing date and the due date, to handle the borrowing process.

2. **Relationships**

- A Member can have many Loans.
- A book has many physical Copies.

3. **Business rules**

- A Member can borrow a maximum of 5 books at once.
- The borrowing term ends after 14 days from the date of the loan.
- A copy of a book cannot be borrowed by several members at the same time.
- A Member can borrow a book only if at least one physical copy is available.
- A returned book copy becomes available for another member to borrow.

4. **Assumptions**

- A Member cannot borrow any book before joining the library.
- I assume that all borrowed books are returned on or before the due date.
- The system uses the current system date as the borrow date.

5. **Questions**

- What happens if the borrowing term ends before the member returns the book?
- Can the member buy books too?
- Should I record the member's information even if they come without borrowing any book?

6. A simple **class diagram**

- ![Milestone 1 class diagram](images/milestone-1.jpg)

## Analyze the requirements

>> For Milestone 2:

1. **Entities/classes**

- Library => Responsible for basic operations, such as adding new books or members.
- LibraryItem => Contains the common attributes and methods for any item in the library, such as the title.

  - Book => Represents a library item and holds the book's information.
  - Magazine => Represents a library item and holds the magazine's information.
  - DVD => Represents a library item and holds the DVD's information.

- Copy => Represents one physical copy of a library item and stores its copy ID and condition.
- Member => Records information about who borrows books from the library.
- BorrowDetails => Contains lending information, such as the borrowing date and due date, to handle the borrowing process.

2. **Relationships**

- A Loan belongs to one Member.
- A Loan refers to one Copy, not directly to a LibraryItem.
- An item has one or more physical Copies.
- A Copy belongs to one LibraryItem.
- A Library has many LibraryItems.
- A Library has many Members.

3. **Business rules**

- A Member can borrow a maximum of 5 items at once, counting books, magazines, and DVDs together.
- The borrowing term ends after a certain number of days from the date of the loan, according to the item type (14 for books, 7 for magazines, and 3 for DVDs).
- A copy of an item cannot be borrowed by several members at the same time.
- A Member can borrow an item only if at least one physical copy is available.
- A returned item copy becomes available for another member to borrow.
- Each physical copy has a condition: new, good, or worn. Its condition can be updated when the copy is returned damaged.

4. **Assumptions**

- A Member cannot borrow any item before joining the library.
- I assume that the system does not apply fines for overdue items.
- The system uses the current system date as the borrow date.

5. **Questions**

- What happens if the borrowing term ends before the member returns the item?
- Can a worn copy be borrowed again, or should it be removed?
- Should I record the member's information even if they come without borrowing any item?

6. A simple **class diagram**

- ![Milestone 2 class diagram](images/milestone-2.jpg)

### **Changes from Milestone 1**

>> In Milestone 2, the system became able to support different types of library items, including Books, Magazines, and DVDs.

>> An abstract `LibraryItem` class was introduced to contain shared information and behavior, such as the title and copies.

### **Abstract class or interface?**

1. We chose an abstract class for `LibraryItem` because Books, Magazines, and DVDs share common data and behavior.

2. The abstract class allows us to store common fields and implemented methods in one place. We also use an abstract `getLoanPeriodDays()` method because each item type can have a different loan period, so each subclass must provide its own implementation.

3. An interface is better for a capability or behavior. If we used an interface for `LibraryItem`, each item would need to manage its own fields and common methods, which would cause duplicated code.

## Analyze the requirements

>> For Milestone 3:

1. **New entities/classes and their responsibilities**

- MembershipTier => Represents the membership level of a member and defines the borrowing limit and any additional loan period.

- MembershipLimits => Stores the borrowing limits and extra loan days associated with each membership tier.

- Reservation => Represents a member's request to borrow an unavailable library item and stores the reservation date and held copy.

- ReservationQueue => Manages reservations for unavailable library items in first-in, first-out order.

- FineCalculator => Calculates the fine for an overdue loan based on the number of late days and the member's membership tier.

- LoanService => Handles the main borrowing, returning, and reservation business rules instead of keeping all of them inside Library.

- BorrowResult => Stores the result of a borrowing attempt and explains the reason when the borrowing operation fails.

- MemberRegistry => Manages registered members and checks whether a member is registered in the library.

2. **Relationships**

- A Member has one MembershipTier.

- A Reservation belongs to one Member and one LibraryItem.

- A LibraryItem can have multiple Reservations.

- A ReservationQueue contains multiple Reservations and processes them in FIFO order.

- A Loan belongs to one Member and one Copy.

- A BorrowResult contains either a successful Loan or a failure reason.

3. **Business rules**

- A Standard member can borrow a maximum of 5 items at once.

- A Premium member can borrow a maximum of 10 items at once.

- Premium members receive 7 additional loan days compared with the normal item loan period.

- A member cannot borrow an item if their outstanding fines are more than $10.00.

- A member can reserve an item only when no copy is currently available.

- When a returned copy has a reservation, it is held for the next member in the reservation queue instead of becoming generally available.

- A reservation expires after 3 days if the member does not collect the held copy.

- When a reservation expires, the held copy is passed to the next member in the queue.

- A late return creates a fine based on the number of overdue days.

- Premium members pay half of the calculated fine.

- A member with an outstanding fine can pay the balance before borrowing again.

4. **Assumptions**

- Membership tiers are represented using an enum because the system has just two of membership levels.

- BigDecimal is used to represent money instead of double because floating-point arithmetic can produce precision errors. For example, 0.1 + 0.2 using double does not produce exactly 0.3.

- The borrowing operation uses a result object instead of exceptions for normal borrowing failures because failures are expected from rules, not exceptional program errors.

5. **What is different at Library class?**

The Library class is becoming a god class because it currently handles too many responsibilities, including:

- Registering members.

- Adding library items.

- Managing the catalog.

- Checking available items.

- Borrowing items.

- Returning items.

- Creating and managing reservations.

- Managing reservation queues.

- Calculating overdue fines.

- Storing and checking member fine balances.

- Processing fine payments.

To reduce these responsibilities, the work is divided into specialized classes:

- Catalog => Manages library items, their copies, and availability.

- MemberRegistry => Handles member registration and membership lookup.

- LoanService => Handles borrowing, returning, and the related business rules.

- ReservationQueue => Handles the reservation queue and the order of reservations.

- FineCalculator => Calculates overdue fines.

- Library => Acts as a simpler entry point that coordinates these services instead of implementing all business rules itself.

6. **Membership tier design: Why an enum?**

>We chose an enum for MembershipTier instead of a class hierarchy because the system currently has a small number of membership levels: STANDARD and PREMIUM.

An enum also makes the code simpler and avoids creating unnecessary subclasses such as StandardMember and PremiumMember.

7. **How will money be represented?**

We will use BigDecimal to represent money.

When testing floating-point arithmetic with:

System.out.println(0.1 + 0.2);

the output is: 0.30000000000000004

This happens because double uses binary floating-point representation and cannot represent some decimal values exactly.

For this reason, the system uses BigDecimal for fines and balances so that monetary calculations maintain decimal precision.

8. **Updated class diagram**