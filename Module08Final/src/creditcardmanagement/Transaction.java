package creditcardmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String transactionID;
    private String cardID;
    private double amount;
    private String category;
    private Date transactionDate;
    private String description;
    private boolean isDebit;

    // Constructor
    public Transaction(String transactionID, String cardID, double amount, String category, Date transactionDate, String description, boolean isDebit) {
        this.transactionID = transactionID;
        this.cardID = cardID;
        this.amount = amount;
        this.category = category;
        this.transactionDate = transactionDate;
        this.description = description;
        this.isDebit = isDebit;
    }

    // Getters and Setters
    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean isDebit) {
        this.isDebit = isDebit;
    }

    // Method to get transaction details
    public String getTransactionDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Transaction ID: %s\nCard ID: %s\nAmount: %.2f\nCategory: %s\nDate: %s\nDescription: %s\nDebit: %b",
                transactionID, cardID, amount, category, sdf.format(transactionDate), description, isDebit);
    }

    @Override
    public String toString() {
        return getTransactionDetails();
    }
}
