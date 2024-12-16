package creditcardmanagement;

import java.util.Date;

public class TestUserAccount {
    public static void main(String[] args) {
        // Create a new user account
        UserAccount userAccount = new UserAccount("user123", "John Doe", "john.doe@example.com", "hashedpassword123");

        // Create a credit card with complete arguments (including paymentDueDate)
        CreditCard card = new CreditCard(
                "12345",
                "Visa Platinum",
                5000.0,
                2000.0,
                12.5,
                new Date(),
                new Date(),  // Add paymentDueDate (using a new Date object)
                21,
                100.0,
                "user123"
        );

        // Add the credit card to the user account
        userAccount.addCreditCard(card);

        // Display user account details
        System.out.println("User ID: " + userAccount.getUserID());
        System.out.println("Username: " + userAccount.getUsername());
        System.out.println("Email: " + userAccount.getEmail());
        System.out.println("Credit Cards:");
        for (CreditCard creditCard : userAccount.getCreditCards()) {
            System.out.println(" - " + creditCard.getCardName() + " (Balance: " + creditCard.getBalance() + ")");
        }
    }
}