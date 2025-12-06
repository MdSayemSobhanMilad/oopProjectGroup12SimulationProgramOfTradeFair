package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import cse213.todayjava.Ahad.UserTicketCounterStaff.TransactionLog;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.IOException;

public class FinalizeTransactionsController {

    @javafx.fxml.FXML
    private TextField amountDueTextField;
    @javafx.fxml.FXML
    private ComboBox<String> choosePaymentComboBox;
    @javafx.fxml.FXML
    private TextArea receiptTextArea;
    @javafx.fxml.FXML
    private TextArea viewReportTextArea;
    @javafx.fxml.FXML
    private TextField todaysSalesTextField;

    private double dailyTotal = 0.0;

    @javafx.fxml.FXML
    public void initialize() {
        choosePaymentComboBox.getItems().addAll("Cash", "Card", "Mobile Money");
        todaysSalesTextField.setText("$0.00");
    }

    @javafx.fxml.FXML
    public void processPaymentOnaction(ActionEvent actionEvent) {
        String paymentMethod = choosePaymentComboBox.getValue();
        String amountText = amountDueTextField.getText();

        if (paymentMethod == null || amountText.isEmpty()) {
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            TransactionLog transaction = new TransactionLog(paymentMethod, amount);
            transaction.setSuccessful(true);

            dailyTotal += amount;
            todaysSalesTextField.setText("$" + String.format("%.2f", dailyTotal));

            String receipt = transaction.generateReceipt();
            receiptTextArea.setText(receipt);

            amountDueTextField.clear();
            choosePaymentComboBox.setValue(null);

        } catch (NumberFormatException e) {
        }
    }

    @javafx.fxml.FXML
    public void viewReportOnaction(ActionEvent actionEvent) {
        String currentTime = java.time.LocalTime.now().toString().substring(0, 8);
        String report = "=== SALES REPORT ===\n";
        report += "Time: " + currentTime + "\n";
        report += "Daily Total: $" + String.format("%.2f", dailyTotal) + "\n";
        report += "End of Report";

        viewReportTextArea.setText(report);
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}