# Library Management System

## Project Description

> This project is a simple in-memory Library Management System developed using Java and Object-Oriented Programming.

> Our small library needs software to manage lending operations.

>The system allows the library to:

- Register members.
- Add books, magazines, and DVDs.
- Borrow and return different types of library items.
- Manage different membership levels.
- Reserve unavailable items.
- Manage reservations using a queue.
- Calculate and manage overdue fines.
- Return a list of items currently borrowed by a specific member.
- Return a list of items that are currently available.
- Return the due date based on the item and membership rules.

## Entities/classes

- Library => Coordinates the main library operations.
- Catalog => Manages the library items and their copies.
- LibraryItem => Contains the common attributes and methods for library items.
- Book => Represents a book and holds its information.
- Magazine => Represents a magazine and holds its information.
- DVD => Represents a DVD and holds its information.
- Copy => Represents one physical copy of a library item and stores its copy ID and condition.
- Member => Records information about library members.
- MembershipTier => Represents the membership level of a member.
- MembershipLimits => Stores the borrowing limits and additional loan days for each membership tier.
- Loan => Contains lending information, such as the borrowing date and due date.
- Reservation => Represents a member's request for an unavailable item.
- ReservationQueue => Manages reservations for unavailable items.
- FineCalculator => Calculates overdue fines.
- LoanService => Handles borrowing, returning, and reservation operations.
- BorrowResult => Stores the result of a borrowing attempt.
- MemberRegistry => Manages registered members.

## How To Run / Requirements

- Java JDK 17 or later.
- Visual Studio Code or another program that can run Java files.

## Run Commands

> Open the terminal in the project root folder and run:

- javac SystemCode/*.java
- java SystemCode.Main

# Testing

> The project uses the Main class as a demo to test the main system operations.

>> Demo scenario :

1. Register members with different membership levels.
2. Borrow the same item and show their due dates based on membership level.
3. Show that another member can borrow more items according to their membership level.
4. Borrow all copies of an item and create reservations for it.
5. Return a copy and show that it is held for the first reserver.
6. Expire the first reservation and show that the next member in the queue gets the opportunity to borrow.
7. Add fine aver than 10$ for an member.
8. Try to borrow while having an outstanding fine above the allowed amount.
9. Pay the fine and show that borrowing is possible again.
10. Try to add a negative number of copies and show that the operation is rejected.

# Design Principles

> The project follows basic Object-Oriented Programming principles, including:

- Encapsulation
- Abstraction
- Polymorphism
- Single Responsibility Principle
- Meaningful naming

### ***Abstract class or interface?***

1. We chose an abstract class for `LibraryItem` because Books, Magazines, and DVDs share common data and behavior.

2. The abstract class allows us to store common fields and implemented methods in one place. We also use an abstract `getLoanPeriodDays()` method because each item type can have a different loan period, so each subclass must provide its own implementation.

3. An interface is better for a capability or behavior. If we used an interface for `LibraryItem`, each item would need to manage its own fields and common methods, which would cause duplicated code.

