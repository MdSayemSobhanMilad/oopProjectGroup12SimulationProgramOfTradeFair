package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.Inventory;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class RestockController
{
    @javafx.fxml.FXML
    private TableColumn<Inventory, Integer> currentStockColoumn;
    @javafx.fxml.FXML
    private ComboBox<String> itemComboBox;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> locationColoumn;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> itemIDColoumn;
    @javafx.fxml.FXML
    private TextField currentStock;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> itemNameColoumn;
    @javafx.fxml.FXML
    private TextField itemidTextField;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private DatePicker restockDatePicker;
    @javafx.fxml.FXML
    private Label successMessegeLabel;
    @javafx.fxml.FXML
    private TableColumn<Inventory, LocalDate> lastRestockColoumn;
    @javafx.fxml.FXML
    private TableView<Inventory> restockInfoTableView;

    @javafx.fxml.FXML
    public void initialize() {
        itemComboBox.getItems().addAll(
                "Toilet Paper",
                "Hand Soap",
                "Paper Towels",
                "Hand Sanitizer",
                "Air Freshener",
                "Trash Bags",
                "Disinfectant Spray",
                "Floor Cleaner",
                "Glass Cleaner",
                "Bleach",
                "Rubber Gloves",
                "Mop Heads",
                "Microfiber Cloths",
                "Toilet Bowl Cleaner",
                "Hand Dryer Paper"
        );

        itemIDColoumn.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemNameColoumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        currentStockColoumn.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        locationColoumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        lastRestockColoumn.setCellValueFactory(new PropertyValueFactory<>("lastRestocked"));

    }

    @javafx.fxml.FXML
    public void handleDeleteItem(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleUpdateStock(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleClearForm(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLowStockReport(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleAddRestock(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLoadItem(ActionEvent actionEvent) {
    }

    private boolean validateInputs() {

        successMessegeLabel.setText("");
        clearErrorStyles();


        StringBuilder errors = new StringBuilder();

        if (itemComboBox.getValue() == null || itemComboBox.getValue().trim().isEmpty()) {
            errors.append("Please select an item.\n");
        }

        if (itemidTextField.getText().trim().isEmpty()) {
            errors.append("Item ID cannot be empty.\n");
        }

        if (locationTextField.getText().trim().isEmpty()) {
            errors.append("Location cannot be empty.\n");
        }

        String stockText = currentStock.getText().trim();
        if (stockText.isEmpty()) {
            errors.append("Current stock cannot be empty.\n");
        } else {
            try {
                int value = Integer.parseInt(stockText);
                if (value < 0) {
                    errors.append("Stock must be a positive number.\n");

                }
            } catch (NumberFormatException e) {
                errors.append("Stock must be a valid integer.\n");

            }
        }

        LocalDate date = restockDatePicker.getValue();
        if (date == null) {
            errors.append("Please select a restock date.\n");

        } else if (date.isAfter(LocalDate.now())) {
            errors.append("Restock date cannot be in the future.\n");

        }

        if (errors.length() > 0) {
            successMessegeLabel.setText(errors.toString());

            return false;
        }

        return true;
    }

    private void clearErrorStyles() {
        itemComboBox.setValue(null);
        itemidTextField.clear();
        locationTextField.clear();
        currentStock.clear();
        restockDatePicker.setValue(null);
    }

}