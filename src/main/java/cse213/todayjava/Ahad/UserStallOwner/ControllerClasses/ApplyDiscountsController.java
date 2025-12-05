package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.Ahad.UserStallOwner.DiscountsApply;
import cse213.todayjava.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ApplyDiscountsController {
    // FXML elements - NOTE: Changed to match FXML spelling
    @FXML private TextField iteamNameField;  // Changed from itemNameField
    @FXML private TextField amountField;
    @FXML private ComboBox<String> discountTypeField;
    @FXML private TableView<DiscountsApply> tableView;

    // Table columns - NOTE: Changed to match FXML spelling
    @FXML private TableColumn<DiscountsApply, String> iteamNameView;  // Changed from itemNameView
    @FXML private TableColumn<DiscountsApply, String> amountView;
    @FXML private TableColumn<DiscountsApply, String> discountTypeView;

    // List to hold discounts for the table
    private ObservableList<DiscountsApply> discountList;

    @FXML
    public void initialize() {
        // Create an empty list for discounts
        discountList = FXCollections.observableArrayList();

        // Connect the table to our list
        tableView.setItems(discountList);

        // Setup table columns
        setupTableColumns();

        // Setup discount type dropdown
        setupDiscountTypes();

        // Add some sample discounts (optional)
        addSampleDiscounts();
    }

    private void setupTableColumns() {
        // Tell each column which property to show from DiscountsApply
        // NOTE: Property names in getters must match exactly
        iteamNameView.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        amountView.setCellValueFactory(new PropertyValueFactory<>("amountString"));
        discountTypeView.setCellValueFactory(new PropertyValueFactory<>("discountType"));
    }

    private void setupDiscountTypes() {
        // Add discount types to the dropdown
        discountTypeField.getItems().addAll(
                "Percentage Discount",
                "Fixed Amount Discount",
                "Buy One Get One Free",
                "Seasonal Discount",
                "Clearance Discount",
                "Member Discount"
        );
    }

    private void addSampleDiscounts() {
        // Add some sample discounts to show in the table
        discountList.add(new DiscountsApply("iPhone 15", 50.00, "Fixed Amount Discount"));
        discountList.add(new DiscountsApply("Samsung TV", 15.0, "Percentage Discount"));
        discountList.add(new DiscountsApply("Running Shoes", 20.00, "Member Discount"));
    }

    @FXML
    public void checkOnaction(ActionEvent actionEvent) {
        // Get values from the form - NOTE: Using iteamNameField
        String itemName = iteamNameField.getText().trim();
        String amountText = amountField.getText().trim();
        String discountType = discountTypeField.getValue();

        // Check if all fields are filled
        if (itemName.isEmpty() || amountText.isEmpty() || discountType == null) {
            return;
        }

        // Check if amount is a valid number
        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }

        // Create new discount
        DiscountsApply newDiscount = new DiscountsApply(itemName, amount, discountType);

        // Add to the table
        discountList.add(newDiscount);

        // Clear the form
        clearForm();
    }

    private void clearForm() {
        iteamNameField.clear();
        amountField.clear();
        discountTypeField.setValue(null); // Clear selection
    }

    @FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        // Go back to dashboard
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }

    private void showMessage(String message, String color) {
        // Create an alert to show messages
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Discount Manager");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}