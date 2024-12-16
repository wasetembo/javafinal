package creditcardmanagement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreditCard {
    private String cardID;
    private String cardName;
    private double creditLimit;
    private double balance;
    private double interestRate;
    private Date statementCloseDate;
    private Date paymentDueDate;
    private int gracePeriod;
    private double amountDue;
    private String userID;
    private List<Transaction> transactionList;

    // Full Constructor
    public CreditCard(String cardID, String cardName, double creditLimit, double balance,
                      double interestRate, Date statementCloseDate, Date paymentDueDate,
                      int gracePeriod, double amountDue, String userID) {
        this.cardID = cardID;
        this.cardName = cardName;
        this.creditLimit = creditLimit;
        this.balance = balance;
        this.interestRate = interestRate;
        this.statementCloseDate = statementCloseDate;
        this.paymentDueDate = paymentDueDate;
        this.gracePeriod = gracePeriod;
        this.amountDue = amountDue;
        this.userID = userID;
        this.transactionList = new ArrayList<>();
    }

    // Default Constructor (Optional)
    public CreditCard() {
        this.transactionList = new ArrayList<>();
    }

    // Grace Period Calculation
    private void calculateGracePeriod() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(statementCloseDate);
        calendar.add(Calendar.DAY_OF_MONTH, 30); // Example: Assume 30 days for grace period
        paymentDueDate = calendar.getTime();
        this.gracePeriod = 30; // Fixed value, modify as per requirements
    }

    // Getters and Setters
    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Date getStatementCloseDate() {
        return statementCloseDate;
    }

    public void setStatementCloseDate(Date statementCloseDate) {
        this.statementCloseDate = statementCloseDate;
        calculateGracePeriod();
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public int getGracePeriod() {
        return gracePeriod;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Transaction> getTransactions() {
        return transactionList;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
        if (transaction.isDebit()) {
            this.balance += transaction.getAmount();
        } else {
            this.balance -= transaction.getAmount();
        }
    }

    public double calculateAvailableCredit() {
        return creditLimit - balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardID='" + cardID + '\'' +
                ", cardName='" + cardName + '\'' +
                ", creditLimit=" + creditLimit +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                ", statementCloseDate=" + statementCloseDate +
                ", paymentDueDate=" + paymentDueDate +
                ", gracePeriod=" + gracePeriod +
                ", amountDue=" + amountDue +
                ", userID='" + userID + '\'' +
                '}';
    }
}
