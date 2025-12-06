package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.Ahad.UserTicketCounterStaff.CashflowManage;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;

public class ManageCashflowController {
    @javafx.fxml.FXML
    private TextField currentCashTextField;
    @javafx.fxml.FXML
    private TextField statusTextField;
    @javafx.fxml.FXML
    private TextField cashReceiveTextField;
    @javafx.fxml.FXML
    private TextField totalAmountTextField;
    @javafx.fxml.FXML
    private TextArea transactionTextArea;
    @javafx.fxml.FXML
    private TextField changeToGiveTextField;

    private CashflowManage cashflow;

    @javafx.fxml.FXML
    public void initialize() {
        cashflow = new CashflowManage();
        currentCashTextField.setText("$" + String.format("%.2f", cashflow.getCurrentCash()));
        statusTextField.setText("Enter amount due and cash received");
        changeToGiveTextField.setEditable(false);
        currentCashTextField.setEditable(false);

        // Auto-calculate when cash received changes
        cashReceiveTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            calculateChange();
        });
    }

    private void calculateChange() {
        try {
            double totalAmount = Double.parseDouble(totalAmountTextField.getText());
            double cashReceived = Double.parseDouble(cashReceiveTextField.getText());

            cashflow.setTotalAmountDue(totalAmount);
            cashflow.setCashReceived(cashReceived);

            changeToGiveTextField.setText("$" + String.format("%.2f", cashflow.getChangeToGive()));
            statusTextField.setText(cashflow.getStatus());

        } catch (NumberFormatException e) {
            // Do nothing - wait for valid input
        }
    }

    @javafx.fxml.FXML
    public void completeTransactionOnaction(ActionEvent actionEvent) {
        try {
            double totalAmount = Double.parseDouble(totalAmountTextField.getText());
            double cashReceived = Double.parseDouble(cashReceiveTextField.getText());

            if (totalAmount <= 0 || cashReceived <= 0) {
                statusTextField.setText("Enter valid amounts");
                return;
            }

            if (cashReceived < totalAmount) {
                statusTextField.setText("Cash received is less than amount due");
                return;
            }

            cashflow.setTotalAmountDue(totalAmount);
            cashflow.setCashReceived(cashReceived);
            cashflow.completeTransaction();

            // Update UI
            changeToGiveTextField.setText("$" + String.format("%.2f", cashflow.getChangeToGive()));
            currentCashTextField.setText("$" + String.format("%.2f", cashflow.getCurrentCash()));

            // Show transaction details
            transactionTextArea.setText(cashflow.getTransactionDetails());
            statusTextField.setText("Transaction completed");

            // Clear for next transaction
            totalAmountTextField.clear();
            cashReceiveTextField.clear();

        } catch (NumberFormatException e) {
            statusTextField.setText("Please enter valid numbers");
        }
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}