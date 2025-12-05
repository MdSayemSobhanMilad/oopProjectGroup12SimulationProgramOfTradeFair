package cse2131codeyjava.ahd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

public class ProcessSalesController {

    // Assuming these are your FXML components (adjust names as needed)
    @FXML private TextArea tickedDetailsTextArea;
    @FXML private TextField priceEachTextArea;
    @FXML private TextField totalTextField;

    // Variables to hold current sale data
    private String ticketType;
    private int quantity;
    private double pricePerTicket;
    private double total;

    // Decimal formatter for currency
    private static final DecimalFormat df = new DecimalFormat("$0.00");

    // Initialize method (optional)
    @FXML
    public void initialize() {
        // Initialization code if needed
    }

    // This method handles the "Omedian" button click (or similar action)
    public void clickOmedian(ActionEvent actionEvent) {
        try {
            // In a real scenario, these values would come from user input
            // For example, from text fields or dropdowns
            ticketType = "Standard"; // Example value
            quantity = 2; // Example value
            pricePerTicket = 25.00; // Example value

            // Calculate total
            total = calculateTotal(quantity, pricePerTicket);

            // Update the UI fields
            priceEachTextArea.setText(df.format(pricePerTicket));
            totalTextField.setText(df.format(total));

            // Build details string
            String details = buildTicketDetails(ticketType, quantity, pricePerTicket, total);

            // Set the details in the text area
            tickedDetailsTextArea.setText(details);

        } catch (Exception e) {
            // Handle exception appropriately
            System.err.println("Error in clickOmedian: " + e.getMessage());
            e.printStackTrace();
            tickedDetailsTextArea.setText("Error processing sale: " + e.getMessage());
        }
    }

    // Calculate total price
    private double calculateTotal(int quantity, double pricePerTicket) {
        return quantity * pricePerTicket;
    }

    // Build ticket details string
    private String buildTicketDetails(String type, int qty, double price, double total) {
        StringBuilder details = new StringBuilder();
        details.append("Ticket: ").append(type).append("\n");
        details.append("Quantity: ").append(qty).append("\n");
        details.append("Price: ").append(df.format(price)).append("\n");
        details.append("Total: ").append(df.format(total));
        return details.toString();
    }

    // Additional methods for other functionality

    // If you had a BALA class, here's what it might look like as an inner class
    public static class BALA {
        private double priceEach;
        private int quantity;

        public BALA(double priceEach, int quantity) {
            this.priceEach = priceEach;
            this.quantity = quantity;
        }

        public double getTotal() {
            return this.priceEach * this.quantity;
        }

        public void setPriceEach(double priceEach) {
            this.priceEach = priceEach;
        }

        public double getPriceEach() {
            return priceEach;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // Alternative method using BALA object
    public void processSaleWithBALA() {
        try {
            BALA bala = new BALA(25.00, 2); // Example values

            // If you want to use BALA object
            priceEachTextArea.setText("$" + bala.getPriceEach());
            totalTextField.setText("$" + bala.getTotal());

            String details = "Ticket: " + ticketType + "\n";
            details += "Quantity: " + bala.getQuantity() + "\n";
            details += "Price: $" + bala.getPriceEach() + "\n";
            details += "Total: $" + bala.getTotal();

            tickedDetailsTextArea.setText(details);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}