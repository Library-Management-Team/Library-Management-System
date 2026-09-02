## Analyze the requirements 
>> For Milestone 1:

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

NOTE : "The Image At Images File".

## Analyze the requirements 
>> For Milestone 2:

1. **Entities/classes**
   - Library => Responsable for basic operations, such as adding new books or member...
   - LibraryItem => cotains the common attributes and methods for any item at library, like title. 
      . Book => reprisent a library item, holds the book information.
      . Magazine => reprisent a library item, hold the magazine information.
      . DVD => reprisent a library item, hold the DVD information.
   - Copy => Represents one physical copy of a library item and stores its copy ID and condition.
   - Member => Records information about who borrow books from library.
   - BorrowDetailes => Contains lending information, such as the borrowing date and the return date for handle the system.

2. **Relationships**
   - A Loan belongs to one Member.
   - A Loan refers to one Copy, not directly to a LibraryItem.
   - An item has one or many physical Copies.
   - A Copy belongs to one LibraryItem.
   - A Library has many LibraryItems.
   - A Library has many Members.

3. **Business rules**
   - Member can borrow a maximum 5 items at once, counting books, magazines and DVDs together..
   - The borrowing term ends after certain days from the date of the loan according to item type(14 for book, 7 for magazine and 3 for DVD).
   - The copy of an item can not borrowed from several members at the same time.
   - A member can borrow an item only if at least one physical copy is available
   - A returned item copy becomes available for another member to borrow.
   - Each physical copy has a condition: new, good, or worn. Its condition can be updated when the copy is returned damaged.

4. **Assumptions**
   - A member can not borrow any item before joining to the library.
   - I assume that the system does not apply fines for overdue items.
   - The system uses the current system date as the borrow date.

5. **Questions**
   - What should be happend if the borrowing term finished befor the member returns the item ?
   - Can a worn copy be borrowed again, or should it be removed ?
   - Should I record the member information even if come without borrow any item ?

6. A simple **class diagram**
   - NOTE : "The Image At Images File".

***Changes from Milestone 1***
>> In Milestone 2, the system become support different types of library items, including Books, Magazines, and DVDs. 
>> Added common abstract LibraryItem class introduced to contain the shared information and behavior, like title. 
>> Physical copies are now represented by the Copy class instead of treating copies only as a count.
>> BorrowDetailes now refers to a member and a specific physical Copy, which allows the system to track the exact copy that is borrowed and its condition. 
>> The loan period is also determined by each item type class through polymorphism instead of having the Library check the item type.


