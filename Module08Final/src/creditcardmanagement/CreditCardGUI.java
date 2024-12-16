package creditcardmanagement;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;

public class CreditCardGUI extends Application {

    private UserAccount userAccount; // UserAccount object to hold credit cards
    private ObservableList<CreditCard> creditCardList; // Observable list for TableView

    public CreditCardGUI() {
        // Initialize the UserAccount
        userAccount = new UserAccount("user123", "JohnDoe", "john@example.com", "hashedPassword");
        creditCardList = FXCollections.observableArrayList(userAccount.getCreditCards());
    }

    @Override
    public void start(Stage primaryStage) {
        // Create input fields
        TextField cardIDField = new TextField();
        TextField cardNameField = new TextField();
        TextField creditLimitField = new TextField();
        TextField balanceField = new TextField();
        TextField interestRateField = new TextField();
        DatePicker statementCloseDatePicker = new DatePicker();
        DatePicker paymentDueDatePicker = new DatePicker();

        // Labels for input fields
        Label cardIDLabel = new Label("Card ID:");
        Label cardNameLabel = new Label("Card Name:");
        Label creditLimitLabel = new Label("Credit Limit:");
        Label balanceLabel = new Label("Balance:");
        Label interestRateLabel = new Label("Interest Rate:");
        Label statementCloseDateLabel = new Label("Statement Close Date:");
        Label paymentDueDateLabel = new Label("Payment Due Date:");

        // Buttons
        Button addButton = new Button("Add Credit Card");
        Button resetButton = new Button("Reset Fields");

        // TableView for displaying credit card information
        TableView<CreditCard> tableView = new TableView<>();
        tableView.setItems(creditCardList);

        // Define TableView columns
        TableColumn<CreditCard, String> cardIDColumn = new TableColumn<>("Card ID");
        cardIDColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCardID()));

        TableColumn<CreditCard, String> cardNameColumn = new TableColumn<>("Card Name");
        cardNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCardName()));

        TableColumn<CreditCard, Double> creditLimitColumn = new TableColumn<>("Credit Limit");
        creditLimitColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getCreditLimit()).asObject());

        TableColumn<CreditCard, Double> balanceColumn = new TableColumn<>("Balance");
        balanceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getBalance()).asObject());

        TableColumn<CreditCard, Double> interestRateColumn = new TableColumn<>("Interest Rate");
        interestRateColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getInterestRate()).asObject());

        TableColumn<CreditCard, String> paymentDueDateColumn = new TableColumn<>("Payment Due Date");
        paymentDueDateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPaymentDueDate().toString()));

        TableColumn<CreditCard, Double> amountDueColumn = new TableColumn<>("Amount Due");
        amountDueColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAmountDue()).asObject());

        TableColumn<CreditCard, Integer> gracePeriodColumn = new TableColumn<>("Grace Period");
        gracePeriodColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getGracePeriod()).asObject());

        // Add columns to the TableView
        tableView.getColumns().addAll(
                cardIDColumn,
                cardNameColumn,
                creditLimitColumn,
                balanceColumn,
                interestRateColumn,
                paymentDueDateColumn,
                amountDueColumn,
                gracePeriodColumn
        );
//
//        tableView.getColumns().addAll(
//                cardIDColumn, cardNameColumn, creditLimitColumn, balanceColumn, interestRateColumn, paymentDueDateColumn,
//                amountDueColumn, gracePeriodColumn
//
//
//        );

        // Layout setup using GridPane for input fields
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Arrange labels and input fields
        gridPane.add(cardIDLabel, 0, 0);
        gridPane.add(cardIDField, 1, 0);
        gridPane.add(cardNameLabel, 0, 1);
        gridPane.add(cardNameField, 1, 1);
        gridPane.add(creditLimitLabel, 0, 2);
        gridPane.add(creditLimitField, 1, 2);
        gridPane.add(balanceLabel, 0, 3);
        gridPane.add(balanceField, 1, 3);
        gridPane.add(interestRateLabel, 0, 4);
        gridPane.add(interestRateField, 1, 4);
        gridPane.add(statementCloseDateLabel, 0, 5);
        gridPane.add(statementCloseDatePicker, 1, 5);
        gridPane.add(paymentDueDateLabel, 0, 6);
        gridPane.add(paymentDueDatePicker, 1, 6);
        gridPane.add(addButton, 1, 7);
        gridPane.add(resetButton, 2, 7);

        // Event handler for Add Button
        addButton.setOnAction(e -> {
            try {
                // Fetch user input and create a new CreditCard object
                String cardID = cardIDField.getText();
                String cardName = cardNameField.getText();
                double creditLimit = Double.parseDouble(creditLimitField.getText());
                double balance = Double.parseDouble(balanceField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText());
                Date statementCloseDate = java.sql.Date.valueOf(statementCloseDatePicker.getValue());
                Date paymentDueDate = java.sql.Date.valueOf(paymentDueDatePicker.getValue());

                // Create a new CreditCard object
                CreditCard newCard = new CreditCard(
                        cardID, cardName, creditLimit, balance, interestRate, statementCloseDate, paymentDueDate, 0, 0.0, userAccount.getUserID()
                );

                // Add the new card to the UserAccount's credit card list
                userAccount.addCreditCard(newCard);

                // Update the TableView
                creditCardList.add(newCard);

                // Confirmation Alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Credit Card Added Successfully!");
                alert.showAndWait();

                // Clear input fields
                resetFields(cardIDField, cardNameField, creditLimitField, balanceField, interestRateField, statementCloseDatePicker, paymentDueDatePicker);

            } catch (Exception ex) {
                // Error Alert for invalid input
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid input values.");
                alert.showAndWait();
            }
        });

        // Event handler for Reset Button
        resetButton.setOnAction(e -> resetFields(cardIDField, cardNameField, creditLimitField, balanceField, interestRateField, statementCloseDatePicker, paymentDueDatePicker));

        // Set up the main scene
        VBox root = new VBox(10, gridPane, tableView);
        Scene scene = new Scene(root, 900, 700);

        primaryStage.setTitle("Credit Card Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void resetFields(TextField cardIDField, TextField cardNameField, TextField creditLimitField, TextField balanceField,
                             TextField interestRateField, DatePicker statementCloseDatePicker, DatePicker paymentDueDatePicker) {
        cardIDField.clear();
        cardNameField.clear();
        creditLimitField.clear();
        balanceField.clear();
        interestRateField.clear();
        statementCloseDatePicker.setValue(null);
        paymentDueDatePicker.setValue(null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
