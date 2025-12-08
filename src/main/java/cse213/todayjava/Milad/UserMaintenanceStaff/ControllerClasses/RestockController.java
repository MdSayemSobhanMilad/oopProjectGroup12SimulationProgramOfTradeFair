package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.Inventory;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    List<Inventory> item = new ArrayList<>();

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
        Inventory selected = restockInfoTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            successMessegeLabel.setText("Please select an item to delete.");
            return;
        }

        item.remove(selected);
        restockInfoTableView.getItems().remove(selected);

        successMessegeLabel.setText("Item deleted successfully!");

        handleClearForm(null);
    }

    @javafx.fxml.FXML
    public void handleUpdateStock(ActionEvent actionEvent) {
        Inventory selected = restockInfoTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            successMessegeLabel.setText("Please select an item to update.");
            return;
        }

        if (!validateInputs()) {
            return;
        }

        selected.setItemId(itemidTextField.getText());
        selected.setItemName(itemComboBox.getValue());
        selected.setCurrentStock(Integer.parseInt(currentStock.getText()));
        selected.setLocation(locationTextField.getText());
        selected.setLastRestocked(restockDatePicker.getValue());

        restockInfoTableView.refresh();

        successMessegeLabel.setText("Item updated successfully!");

        handleClearForm(null);
    }

    @javafx.fxml.FXML
    public void handleClearForm(ActionEvent actionEvent) {
        itemComboBox.setValue(null);
        itemidTextField.clear();
        locationTextField.clear();
        currentStock.clear();
        restockDatePicker.setValue(null);
        successMessegeLabel.setText("");
    }

    @javafx.fxml.FXML
    public void handleLowStockReport(ActionEvent actionEvent) {
        List<Inventory> lowStockItems = new ArrayList<>();

        for (Inventory i: item){
            if(i.getCurrentStock() < 10){
                lowStockItems.add(i);
            }
        }
        restockInfoTableView.getItems().clear();
        restockInfoTableView.getItems().addAll(lowStockItems);

        successMessegeLabel.setText("Low stock report generated.");
    }

    @javafx.fxml.FXML
    public void handleAddRestock(ActionEvent actionEvent) {
        if (!validateInputs()) {
            return;
        }

        Inventory inv = new Inventory(
                itemidTextField.getText(),
                itemComboBox.getValue(),
                Integer.parseInt(currentStock.getText()),
                locationTextField.getText(),
                restockDatePicker.getValue()
        );

        item.add(inv);

        restockInfoTableView.getItems().clear();
        restockInfoTableView.getItems().addAll(item);

        successMessegeLabel.setText("Item restocked successfully!");

        handleClearForm(null);
    }

    @javafx.fxml.FXML
    public void handleLoadItem(ActionEvent actionEvent) {
        Inventory selected = restockInfoTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            successMessegeLabel.setText("Please select an item to load.");
            return;
        }

        itemidTextField.setText(selected.getItemId());
        itemComboBox.setValue(selected.getItemName());
        currentStock.setText(String.valueOf(selected.getCurrentStock()));
        locationTextField.setText(selected.getLocation());
        restockDatePicker.setValue(selected.getLastRestocked());
    }

    private boolean validateInputs() {

        successMessegeLabel.setText("");


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

        if (!errors.isEmpty()) {
            successMessegeLabel.setText(errors.toString());

            return false;
        }

        return true;
    }


    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}