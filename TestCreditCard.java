package creditcardmanagement;

import java.util.Date;

public class TestCreditCard {
    public static void main(String[] args) {
        // Create a CreditCard
        CreditCard card = new CreditCard(
                "12345", "Visa Platinum", 5000.0, 2000.0,
                12.5, new Date(), new Date(), 21, 100.0, "user123"
        );

        // Create a Transaction
        Transaction transaction = new Transaction(
                "txn001", "12345", 150.0, "Groceries",
                new Date(), "Walmart Purchase", true
        );

        // Add Transaction to the CreditCard
        card.addTransaction(transaction);

        // Print Transactions
        System.out.println("Transactions for Card: " + card.getCardName());
        for (Transaction t : card.getTransactions()) {
            System.out.println("Transaction ID: " + t.getTransactionID() +
                    ", Amount: " + t.getAmount() +
                    ", Category: " + t.getCategory());
        }

        // Calculate and print available credit
        System.out.println("Available Credit: " + card.calculateAvailableCredit());
    }
}