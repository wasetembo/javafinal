Credit Card Management System
Description
The Credit Card Management System is a Java application that helps users manage their credit cards by allowing them to:

Add credit card details.
View stored credit card information in a table.
Track payment due dates, balances, and credit limits.
Calculate available credit and monitor transactions.
The project is built using Java and JavaFX for the GUI and includes basic object-oriented principles with classes for CreditCard, Transaction, and UserAccount.

Features
Add Credit Cards: Users can input details such as:
Card ID
Card Name
Credit Limit
Balance
Interest Rate
Statement Close Date
Payment Due Date

View Stored Cards:
Displays all stored credit cards in a table.
Shows card ID, card name, credit limit, balance, interest rate, and payment due date.

Calculate Available Credit: Automatically calculates and displays available credit for each card.
Transaction Handling:

Record transactions associated with each credit card.
Adjust the balance dynamically.


Prerequisites
Java 17 or later.
JavaFX SDK 23.0.1 (ensure it is downloaded and set up).
An IDE like IntelliJ IDEA or a terminal for compiling and running the project.


Project Structure
Module08Final/
├── src/
│   ├── creditcardmanagement/
│   │   ├── CreditCard.java
│   │   ├── Transaction.java
│   │   ├── UserAccount.java
│   │   ├── CreditCardGUI.java
│   │   ├── TestCreditCard.java
│   │   └── TestUserAccount.java


How to Compile and Run


Step 1: Compile the Project
Ensure the JavaFX SDK is installed and the lib path is available.
Use the following command to compile all files:
javac --module-path /path/to/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml \
src/creditcardmanagement/*.java
Replace /path/to/javafx-sdk-23.0.1/lib with the actual path to your JavaFX lib folder.

Step 2: Run the Project
Run the main GUI class:
java --module-path /path/to/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml \
creditcardmanagement.CreditCardGUI


Example Usage
Launch the application.
Fill out the fields to add a new credit card.
Click "Add Credit Card" to save the details.
View the added card in the table.
Classes
1. CreditCard
Handles credit card attributes like ID, name, credit limit, balance, interest rate, payment due date, and transactions.
Provides methods for calculating available credit and managing transactions.
2. Transaction
Represents individual transactions associated with credit cards.
Includes details like amount, type (debit/credit), and description.
3. UserAccount
Represents a user managing multiple credit cards.
Includes methods to add cards, calculate total credit used, and view total available credit.
4. CreditCardGUI
Implements the graphical user interface using JavaFX.
Provides input fields, a table for displaying stored cards, and event handlers for adding new cards.
Future Enhancements
Implement detailed transaction views for each credit card.
Add features for editing or deleting cards.
Integrate with a database for persistent storage.
Add real-time notifications for payment due dates.
License
This project is open-source and available for educational purposes. Feel free to modify or enhance the system.

