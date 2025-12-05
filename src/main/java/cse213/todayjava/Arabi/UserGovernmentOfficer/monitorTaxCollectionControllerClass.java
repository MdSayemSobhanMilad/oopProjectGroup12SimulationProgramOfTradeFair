package cse213.todayjava.Arabi.UserGovernmentOfficer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class monitorTaxCollectionControllerClass {

    @FXML
    private TextField totalTaxTextField;

    @FXML
    private TextField pendingTextField;

    @FXML
    private RadioButton allPaidRadioButton;

    @FXML
    private RadioButton pendingRadioButton;

    @FXML
    private TableView<TaxCollection> monitorTaxCollectionTableView;

    @FXML
    private TableColumn<TaxCollection, Double> totalTaxTableColumn;

    @FXML
    private TableColumn<TaxCollection, Double> pendingTableColumn;

    @FXML
    private TableColumn<TaxCollection, String> statusTableColumn;

    // List to store tax data
    private ObservableList<TaxCollection> taxList = FXCollections.observableArrayList();

    // Initialize method - This runs when the screen loads
    @FXML
    public void initialize() {
        // Set up the table columns
        totalTaxTableColumn.setCellValueFactory(cellData -> {
            TaxCollection tax = cellData.getValue();
            return new javafx.beans.property.SimpleDoubleProperty(tax.getTotalTax()).asObject();
        });

        pendingTableColumn.setCellValueFactory(cellData -> {
            TaxCollection tax = cellData.getValue();
            return new javafx.beans.property.SimpleDoubleProperty(tax.getPending()).asObject();
        });

        statusTableColumn.setCellValueFactory(cellData -> {
            TaxCollection tax = cellData.getValue();
            return new javafx.beans.property.SimpleStringProperty(tax.getStatus());
        });

        // Set the data to table
        monitorTaxCollectionTableView.setItems(taxList);
    }

    // Submit button action
    @FXML
    private void submitOnClick() {
        // Check if all fields are filled
        if (totalTaxTextField.getText().isEmpty() ||
                pendingTextField.getText().isEmpty() ||
                (!allPaidRadioButton.isSelected() && !pendingRadioButton.isSelected())) {

            // Don't show table if fields are empty
            return;
        }

        try {
            // Get values from text fields
            double totalTax = Double.parseDouble(totalTaxTextField.getText());
            double pending = Double.parseDouble(pendingTextField.getText());

            // Get status from radio buttons
            String status;
            if (allPaidRadioButton.isSelected()) {
                status = "All Paid";
            } else {
                status = "Pending";
            }

            // Create new TaxCollection object
            TaxCollection newTax = new TaxCollection(totalTax, pending, status);

            // Add to the table
            taxList.add(newTax);

            // Clear all fields after adding
            totalTaxTextField.clear();
            pendingTextField.clear();
            allPaidRadioButton.setSelected(false);
            pendingRadioButton.setSelected(false);

        } catch (NumberFormatException e) {
            // Do nothing if invalid numbers
            return;
        }
    }

    // Back button action
    @FXML
    private void backOnClick() {
        // You can add your back navigation logic here
        System.out.println("Back button clicked");
    }
}