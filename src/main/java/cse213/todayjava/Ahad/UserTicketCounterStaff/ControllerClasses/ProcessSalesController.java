package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.Ahad.UserTicketCounterStaff.SalesProcess;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class ProcessSalesController {

    @FXML private ComboBox<String> ticketTypeComboBox;
    @FXML private TextField quantityTextField;
    @FXML private TextArea priceEachTextArea;
    @FXML private TextField totalTextField;
    @FXML private TextArea ticketDetailsTextArea;
    @FXML private TextArea confirmCustomerTextArea;
    @FXML private TextArea confirmPaymentTextArea;
    @FXML private TextArea sucessPaymentTextArea;

    private SalesProcess sale;

    @FXML
    public void initialize() {
        ticketTypeComboBox.getItems().addAll("Standard", "VIP", "Student", "Senior", "Child");
        clearAll();
    }

    @FXML
    private void clickOnaction(ActionEvent event) {
        try {
            String ticketType = ticketTypeComboBox.getValue();
            if (ticketType == null || ticketType.isEmpty()) {
                // No error shown - just do nothing
                return;
            }

            String qtyText = quantityTextField.getText();
            if (qtyText == null || qtyText.isEmpty()) {
                // No error shown - just do nothing
                return;
            }

            int quantity = Integer.parseInt(qtyText);
            if (quantity < 1) {
                // No error shown - just reset
                quantityTextField.setText("1");
                quantity = 1;
            }

            double price = getPrice(ticketType);

            sale = new SalesProcess(ticketType, quantity, price);

            priceEachTextArea.setText("$" + String.format("%.2f", sale.getPriceEach()));
            totalTextField.setText("$" + String.format("%.2f", sale.getTotalPrice()));
            ticketDetailsTextArea.setText(sale.getDetails());

            confirmCustomerTextArea.setText("Ready to confirm");

        } catch (NumberFormatException e) {
            // No error shown - just reset to default
            quantityTextField.setText("1");
        }
    }

    @FXML
    private void confirmCustomerOnaction(ActionEvent event) {
        if (sale == null) {
            // No error shown - just clear the text area
            confirmCustomerTextArea.clear();
            return;
        }

        confirmCustomerTextArea.setText("CONFIRMED\n");
        confirmCustomerTextArea.appendText("Ticket: " + sale.getTicketType() + "\n");
        confirmCustomerTextArea.appendText("Quantity: " + sale.getQuantity() + "\n");
        confirmCustomerTextArea.appendText("Total: $" + String.format("%.2f", sale.getTotalPrice()) + "\n");
        confirmCustomerTextArea.appendText("Ready for payment");
    }

    @FXML
    private void proceedPaymentOnaction(ActionEvent event) {
        String transId = "TX" + System.currentTimeMillis();

        if (sale != null) {
            confirmPaymentTextArea.setText("PAYMENT DONE\n");
            confirmPaymentTextArea.appendText("Amount: $" + String.format("%.2f", sale.getTotalPrice()) + "\n");
            confirmPaymentTextArea.appendText("ID: " + transId + "\n");
            confirmPaymentTextArea.appendText("Status: Paid");

            sucessPaymentTextArea.setText("SUCCESS!\n");
            sucessPaymentTextArea.appendText("ID: " + transId);
        } else {
            confirmPaymentTextArea.setText("PAYMENT DONE\n");
            confirmPaymentTextArea.appendText("ID: " + transId + "\n");
            confirmPaymentTextArea.appendText("Status: Paid");

            sucessPaymentTextArea.setText("SUCCESS!\n");
            sucessPaymentTextArea.appendText("ID: " + transId);
        }

        clearForNext();
    }

    @Deprecated
    private void BackbuttonOnaction(ActionEvent event) {
        // Back button action - no errors shown
    }

    private double getPrice(String type) {
        switch (type) {
            case "VIP": return 50.0;
            case "Student": return 18.0;
            case "Senior": return 20.0;
            case "Child": return 12.0;
            default: return 25.0;
        }
    }

    private void clearAll() {
        quantityTextField.clear();
        ticketTypeComboBox.setValue(null);
        priceEachTextArea.clear();
        totalTextField.clear();
        ticketDetailsTextArea.clear();
        confirmCustomerTextArea.clear();
        confirmPaymentTextArea.clear();
        sucessPaymentTextArea.clear();
        sale = null;
    }

    private void clearForNext() {
        quantityTextField.clear();
        ticketTypeComboBox.setValue(null);
        ticketDetailsTextArea.clear();
        confirmCustomerTextArea.clear();
        sale = null;
    }

    @FXML
    public void backButtonOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}