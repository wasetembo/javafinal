package creditcardmanagement;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String userID;
    private String username;
    private String email;
    private String passwordHash;
    private List<CreditCard> creditCardList;

    // Constructor
    public UserAccount(String userID, String username, String email, String passwordHash) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.creditCardList = new ArrayList<>();
    }

    // Getters and Setters
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }

    // Alias method to avoid errors in CreditCardGUI.java
    public List<CreditCard> getCreditCards() {
        return getCreditCardList();
    }

    public void setCreditCardList(List<CreditCard> creditCardList) {
        this.creditCardList = creditCardList;
    }

    // Method to add a credit card
    public void addCreditCard(CreditCard creditCard) {
        this.creditCardList.add(creditCard);
    }

    // Calculate total credit used
    public double getTotalCreditUsed() {
        return creditCardList.stream()
                .mapToDouble(CreditCard::getBalance)
                .sum();
    }

    // Calculate total available credit
    public double getTotalCreditAvailable() {
        return creditCardList.stream()
                .mapToDouble(CreditCard::calculateAvailableCredit)
                .sum();
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", totalCreditUsed=" + getTotalCreditUsed() +
                ", totalCreditAvailable=" + getTotalCreditAvailable() +
                '}';
    }
}
