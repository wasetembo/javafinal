package creditcardmanagement;


import java.util.Date;

public class TestTransaction {
    public static void main(String[] args) {
        Transaction transaction = new Transaction("T001", "C001", 50, "Groceries", new Date(), "Walmart Purchase", true);

        System.out.println(transaction.getTransactionDetails());
    }
}
