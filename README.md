## Library Management System

# Project Description:

> This project is a simple in-memory Library Management System developed using Java and Object-Oriented Programming.

> Our small library wants software to manage lending

The system allows the library to:

Register members.
Add books with a set number of available copies.
Borrow books while enforcing a maximum of 5 borrowed books per member.
Return books.
Return available books as a list.
Return books currently borrowed by a specific member as a list.

# Entities/classes

- Library => Responsable for basic operations, such as adding new books or member...
- Book => Holds the book information.
- Member => Records information about who borrow books from library.
- BorrowDetails => Contains lending information, such as the borrowing date and due date, to help manage the lending process.

# How To Run\Requirements

- Java JDK 17 or later
- Visual Studio Code or another program that can run Java files.

# Run Commands

Open the terminal in the project root folder and run:

javac SystemCode/*.java
java SystemCode.Main

# Testing

> The project uses the Main class as a demo to test the main system operations.

- The demo checks:

Member registration.
Book availability.
Borrowing books.
The 5-book limit.
Returning books.
Returning a member's borrowed books.

# Design Principles

> The project follows basic Object-Oriented Programming principles, including:

- Encapsulation
- Single Responsibility Principle
- Meaningful naming