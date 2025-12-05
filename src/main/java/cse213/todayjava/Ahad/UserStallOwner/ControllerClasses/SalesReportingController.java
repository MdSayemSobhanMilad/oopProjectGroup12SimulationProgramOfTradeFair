package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.Ahad.UserStallOwner.ReportingSales;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class SalesReportingController {

    @FXML private TextField productFiled;
    @FXML private TextField quantityFiled;
    @FXML private TextField priceField;
    @FXML private ComboBox<String> paymenentMethodCB;
    @FXML private TextArea cashReceivedField;
    @FXML private TextArea changeDueField;
    @FXML private TextArea receiptTextArea;


    private ReportingSales currentSale;

    @FXML
    public void initialize() {

        setupPaymentMethods();


        clearAllFields();
    }

    private void setupPaymentMethods() {

        if (paymenentMethodCB != null) {
            paymenentMethodCB.getItems().addAll(
                    "Cash",
                    "Credit Card",
                    "Debit Card",
                    "Mobile Payment",
                    "Online Payment"
            );
        }
    }

    private void clearAllFields() {

        if (productFiled != null) productFiled.clear();
        if (quantityFiled != null) quantityFiled.clear();
        if (priceField != null) priceField.clear();
        if (paymenentMethodCB != null) paymenentMethodCB.setValue(null);
        if (cashReceivedField != null) cashReceivedField.clear();
        if (changeDueField != null) changeDueField.clear();
        if (receiptTextArea != null) receiptTextArea.clear();
        currentSale = null;
    }

    @FXML
    public void receiptInfoOnaction(ActionEvent actionEvent) {
        // STEP 1: Get all values from the form
        String productName = productFiled.getText().trim();
        String quantityText = quantityFiled.getText().trim();
        String priceText = priceField.getText().trim();
        String paymentMethod = paymenentMethodCB.getValue();
        String cashText = cashReceivedField.getText().trim();


        if (productName.isEmpty() || quantityText.isEmpty() ||
                priceText.isEmpty() || paymentMethod == null || cashText.isEmpty()) {
            showMessage("Please fill ALL fields first!", "red");
            return;
        }


        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }


        double price;
        try {
            price = Double.parseDouble(priceText);
            if (price <= 0) {
                return;
            }
        } catch (NumberFormatException e) {
            showMessage("Please enter valid price!", "red");
            return;
        }


        double cashReceived;
        try {
            cashReceived = Double.parseDouble(cashText);
            if (cashReceived <= 0) {
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }


        currentSale = new ReportingSales(productName, quantity, price, paymentMethod);


        double total = currentSale.getTotal();


        if (!currentSale.isCashEnough(cashReceived)) {
            double shortAmount = total - cashReceived;


            String errorMessage = "=== ERROR: INSUFFICIENT CASH ===\n" +
                    "==============================\n\n" +
                    "Product: " + productName + "\n" +
                    "Quantity: " + quantity + "\n" +
                    "Price: $" + String.format("%.2f", price) + " each\n" +
                    "Total: $" + String.format("%.2f", total) + "\n" +
                    "Cash Received: $" + String.format("%.2f", cashReceived) + "\n\n" +
                    "⚠️ SHORT BY: $" + String.format("%.2f", shortAmount) + " ⚠️\n\n" +
                    "Please collect more money from customer!";

            receiptTextArea.setText(errorMessage);
            changeDueField.setText("ERROR");
            return;
        }


        double changeDue = currentSale.calculateChange(cashReceived);


        changeDueField.setText("$" + String.format("%.2f", changeDue));


        generateReceipt(cashReceived, changeDue, total);
    }

    private void generateReceipt(double cashReceived, double changeDue, double total) {
        StringBuilder receipt = new StringBuilder();

        receipt.append("=== SALES RECEIPT ===\n");
        receipt.append("══════════════════════\n\n");

        receipt.append("Product: " + currentSale.getProductName() + "\n");
        receipt.append("Quantity: " + currentSale.getQuantity() + "\n");
        receipt.append("Unit Price: $" + String.format("%.2f", currentSale.getPrice()) + "\n");
        receipt.append("Payment Method: " + currentSale.getPaymentMethod() + "\n\n");

        receipt.append("══════════════════════\n");
        receipt.append("SUBTOTAL: $" + String.format("%.2f", total) + "\n");
        receipt.append("CASH PAID: $" + String.format("%.2f", cashReceived) + "\n");
        receipt.append("CHANGE DUE: $" + String.format("%.2f", changeDue) + "\n");
        receipt.append("══════════════════════\n\n");

        receipt.append("Thank you for your purchase!\n");
        receipt.append("Date: " + java.time.LocalDate.now() + "\n");
        receipt.append("Time: " + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("hh:mm a")));

        receiptTextArea.setText(receipt.toString());
    }

    @FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {

        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }

    private void showMessage(String message, String color) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Point of Sale");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}