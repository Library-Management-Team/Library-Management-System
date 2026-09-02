## Library Management System

# Project Description:

> This project is a simple in-memory Library Management System developed using Java and Object-Oriented Programming.

> Our small library wants software to manage lending

The system allows the library to:

Register members.
Add books, Magazines, DVDs.
Borrow item while enforcing a maximum of 5 borrowed items per member.
Return items of certain type.
Return items currently borrowed by a specific member as a list.
Return list of items showing everything currently available.
Return the due date, and that due date depends on the type of item.

# Entities/classes

- Library => Responsible for basic operations, such as adding new books or member...
- LibraryItem => Contains the common attributes and methods for any item at library, like title. 
- Book => Represent a library item, holds the book information.
- Magazine => Represent a library item, hold the magazine information.
- DVD => Represent a library item, hold the DVD information.
- Copy => Represents one physical copy of a library item and stores its copy ID and condition.
- Member => Records information about who borrows books from library.
- BorrowDetails => Contains lending information, such as the borrowing date and due date, to help manage the lending process.

# How To Run / Requirements

- Java JDK 17 or later
- Visual Studio Code or another program that can run Java files.

# Run Commands

Open the terminal in the project root folder and run:

javac SystemCode/*.java
java SystemCode.Main

# Testing

> The project uses the Main class as a demo to test the main system operations.

>> Demo scenario :

1. Add a book with 3 copies, a magazine with 1 copy, and a DVD with 2 copies.
2. Register 2 members.
3. Borrow one of each type and print the due date for each — the output must visibly show 14, 7 and 3 days.
4. Print the full available-items list, showing title and type.
5. Borrow until a member hits the 5-item limit, then attempt one more and print the refusal.
6. Borrow every copy of the magazine, then try again and print the refusal. (Make sure this case genuinely has no copies free — that's what went wrong last time.)
7. Return a specific copy, mark it worn, and print the item's copies with their conditions so the change is visible.
8. Print the available list again so the difference before/after is obvious.

# Design Principles

> The project follows basic Object-Oriented Programming principles, including:

- Encapsulation
- Abstraction
- Polymorphism
- Single Responsibility Principle
- Meaningful naming