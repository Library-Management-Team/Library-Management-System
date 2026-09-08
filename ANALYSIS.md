## Step 1 — Analyze the requirements

1. **Entities/classes**
   - Library => Responsible for basic operations, such as adding new books or members...
   - Book => It holds the book information.
   - Member => It records information about who borrows books from library.
   - BorrowDetails => It contains lending information, such as the borrowing date and the due date for handle the system.

2. **Relationships**
   - A Member can have many Loans.
   - A book has many physical Copies.
   - A Book has one or more physical BookCopies.

3. **Business rules**
   - Member can borrow a maximum 5 books at once.
   - The borrowing term ends after 14 days from the date of the loan.
   - The copy of a book cannot borrowed by several members at the same time.
   - Member cannot borrow any book before ensure that it is available.
   - A returned book copy becomes available for another member to borrow.

4. **Assumptions**
   - A member can not borrow any book before joining the library.
   - I assume that all borrowed books are returned on or before the due date.
   - The system uses the current system date as the borrow date.

5. **Questions**
   - What if the borrowing term finishes before the member returns the book ?
   - Can the member buy books too ? 
   - Should I record the members information even if they come without borrowing any book ?

6. A simple **class diagram**
   - NOTE : "The Image At Images File".


