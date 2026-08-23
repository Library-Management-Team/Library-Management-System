## Step 1 — Analyze the requirements

1. **Entities/classes**
   - Library => Responsable for basic operations, such as adding new books or member...
   - Book => It holds the book information.
   - Member => It Records information about who borrow books from library.
   - BorrowDetailes => It contains lending information, such as the borrowing date and the return date for handle the system.

2. **Relationships**
   - A Member can have many Loans.
   - A book has many physical Copies.
   - A Book has one or more physical BookCopies.

3. **Business rules**
   - Member can borrow a maximum 5 books at once.
   - The borrowing term ends after 14 days from the date of the loan.
   - The copy of a book can not borrowed from several members at the same time.
   - Member can not borrow any book befor insure that is available or not.
   - A returned book copy becomes available for another member to borrow.

4. **Assumptions**
   - A member can not borrow any book before joining to the library.
   - I assume that all borrowed books are returned on or before the due date.
   - The system uses the current system date as the borrow date.

5. **Questions**
   - What if the borrowing term finished befor the member returns the book ?
   - Can the member buy books too ? 
   - Should I record the member information even if come without borrow any book ?

6. A simple **class diagram**
   - NOTE : "The Image At Images File".


