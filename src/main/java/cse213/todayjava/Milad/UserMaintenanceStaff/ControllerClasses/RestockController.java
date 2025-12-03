package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import javafx.scene.control.TableColumn;
import cse213.todayjava.Milad.UserMaintenanceStaff.Inventory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class RestockController implements Initializable {

    @FXML
    private TextField itemidTextField;

    @FXML
    private TextField currentStock;

    @FXML
    private TextField locationTextField;

    @FXML
    private DatePicker restockDatePicker;

    @FXML
    private ComboBox<String> itemComboBox;

    @FXML
    private Label successMessegeLabel;

    @FXML
    private TableView<Inventory> restockInfoTableView;

    @FXML
    private TableColumn<Inventory, String> itemIDColoumn;

    @FXML
    private TableColumn<Inventory, String> itemNameColoumn;

    @FXML
    private TableColumn<Inventory, Integer> currentStockColoumn;

    @FXML
    private TableColumn<Inventory, String> locationColoumn;

    @FXML
    private TableColumn<Inventory, String> lastRestockColoumn;

    private ObservableList<Inventory> inventoryList = FXCollections.observableArrayList();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize ComboBox with restroom supply items
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

        // Set up TableView columns
        itemIDColoumn.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemNameColoumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        currentStockColoumn.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        locationColoumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        lastRestockColoumn.setCellValueFactory(new PropertyValueFactory<>("lastRestocked"));

        // Custom cell factory for lastRestock column to format the date
        lastRestockColoumn.setCellFactory(column -> new TableCell<Inventory, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                }
            }
        });

        // Set items to TableView
        restockInfoTableView.setItems(inventoryList);

        // Set current date as default for restock date
        restockDatePicker.setValue(LocalDate.now());

        // Add listener to itemComboBox to auto-fill item ID based on selection
        itemComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Generate item ID based on item name
                String itemId = generateItemId(newValue);
                itemidTextField.setText(itemId);

                // Auto-suggest location based on item type
                suggestLocation(newValue);
            }
        });

        // Add listener to currentStock field for validation
        currentStock.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                currentStock.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // Auto-clear success message after 3 seconds
        successMessegeLabel.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                javafx.application.Platform.runLater(() -> successMessegeLabel.setText(""));
                            }
                        },
                        3000
                );
            }
        });

        // Load some sample data
        loadSampleData();
    }

    // Method to add/restock inventory item
    @FXML
    private void handleAddRestock() {
        if (!validateInput()) {
            return;
        }

        try {
            // Create LocalDateTime from DatePicker (using current time)
            LocalDateTime restockDateTime = LocalDateTime.of(
                    restockDatePicker.getValue(),
                    LocalTime.now()
            );

            // Check if item already exists
            String itemId = itemidTextField.getText().trim();
            Inventory existingItem = findItemById(itemId);

            if (existingItem != null) {
                // Update existing item
                existingItem.setCurrentStock(Integer.parseInt(currentStock.getText().trim()));
                existingItem.setLastRestocked(restockDateTime);
                existingItem.setLocation(locationTextField.getText().trim());
                showSuccessMessage("Item restocked successfully! Stock updated.");
            } else {
                // Create new inventory item
                Inventory newItem = new Inventory();
                newItem.setItemId(itemId);
                newItem.setItemName(itemComboBox.getValue());
                newItem.setCurrentStock(Integer.parseInt(currentStock.getText().trim()));
                newItem.setLocation(locationTextField.getText().trim());
                newItem.setLastRestocked(restockDateTime);

                inventoryList.add(newItem);
                showSuccessMessage("New item added to inventory successfully!");
            }

            // Refresh TableView
            restockInfoTableView.refresh();

            // Clear form for next entry
            clearForm();

        } catch (NumberFormatException e) {
            showErrorMessage("Invalid Stock Value", "Please enter a valid number for current stock.");
        } catch (Exception e) {
            showErrorMessage("Error", "Failed to process inventory item: " + e.getMessage());
        }
    }

    // Method to handle updating stock
    @FXML
    private void handleUpdateStock() {
        Inventory selectedItem = restockInfoTableView.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            showErrorMessage("No Selection", "Please select an item from the table to update.");
            return;
        }

        if (!validateInput()) {
            return;
        }

        try {
            // Update selected item
            selectedItem.setItemName(itemComboBox.getValue());
            selectedItem.setCurrentStock(Integer.parseInt(currentStock.getText().trim()));
            selectedItem.setLocation(locationTextField.getText().trim());
            selectedItem.setLastRestocked(LocalDateTime.of(
                    restockDatePicker.getValue(),
                    LocalTime.now()
            ));

            // Refresh TableView
            restockInfoTableView.refresh();
            showSuccessMessage("Item updated successfully!");

            // Clear form
            clearForm();

        } catch (NumberFormatException e) {
            showErrorMessage("Invalid Stock Value", "Please enter a valid number for current stock.");
        }
    }

    // Method to handle deleting an item
    @FXML
    private void handleDeleteItem() {
        Inventory selectedItem = restockInfoTableView.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            showErrorMessage("No Selection", "Please select an item from the table to delete.");
            return;
        }

        // Store item info before deletion
        String itemName = selectedItem.getItemName();
        String itemId = selectedItem.getItemId();

        // Delete the item
        inventoryList.remove(selectedItem);
        showSuccessMessage("Item '" + itemName + "' (ID: " + itemId + ") deleted successfully!");
        clearForm();
    }

    // Method to load selected item for editing
    @FXML
    private void handleLoadItem() {
        Inventory selectedItem = restockInfoTableView.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // Load item details into form
            itemidTextField.setText(selectedItem.getItemId());
            itemComboBox.setValue(selectedItem.getItemName());
            currentStock.setText(selectedItem.getCurrentStock().toString());
            locationTextField.setText(selectedItem.getLocation());

            if (selectedItem.getLastRestocked() != null) {
                restockDatePicker.setValue(selectedItem.getLastRestocked().toLocalDate());
            }

            showInfoMessage("Item loaded for editing. Click 'Update' to save changes.");
        }
    }

    // Method to generate low stock report
    @FXML
    private void handleLowStockReport() {
        if (inventoryList.isEmpty()) {
            showErrorMessage("No Items", "Inventory list is empty.");
            return;
        }

        StringBuilder report = new StringBuilder();
        report.append("LOW STOCK REPORT\n");
        report.append("================\n");

        int lowStockCount = 0;
        int criticalStockCount = 0;

        for (Inventory item : inventoryList) {
            if (item.getCurrentStock() < 10) { // Critical stock level
                report.append(String.format("CRITICAL: %s (ID: %s) - Stock: %d\n",
                        item.getItemName(), item.getItemId(), item.getCurrentStock()));
                criticalStockCount++;
            } else if (item.getCurrentStock() < 20) { // Low stock level
                report.append(String.format("LOW: %s (ID: %s) - Stock: %d\n",
                        item.getItemName(), item.getItemId(), item.getCurrentStock()));
                lowStockCount++;
            }
        }

        if (lowStockCount == 0 && criticalStockCount == 0) {
            report.append("All items have sufficient stock.\n");
        } else {
            report.append(String.format("\nTotal: %d low stock items, %d critical items",
                    lowStockCount, criticalStockCount));
        }

        showInfoMessage(report.toString());
    }

    // Method to clear the form
    @FXML
    private void handleClearForm() {
        clearForm();
        showInfoMessage("Form cleared.");
    }

    // Validation method
    private boolean validateInput() {
        StringBuilder errors = new StringBuilder();

        // Validate Item ID
        if (itemidTextField.getText() == null || itemidTextField.getText().trim().isEmpty()) {
            errors.append("• Item ID is required\n");
        }

        // Validate Item Name
        if (itemComboBox.getValue() == null || itemComboBox.getValue().trim().isEmpty()) {
            errors.append("• Item Name is required\n");
        }

        // Validate Current Stock
        if (currentStock.getText() == null || currentStock.getText().trim().isEmpty()) {
            errors.append("• Current Stock is required\n");
        } else {
            try {
                int stock = Integer.parseInt(currentStock.getText().trim());
                if (stock < 0) {
                    errors.append("• Current Stock cannot be negative\n");
                } else if (stock > 1000) {
                    errors.append("• Current Stock cannot exceed 1000 units\n");
                }
            } catch (NumberFormatException e) {
                errors.append("• Current Stock must be a valid number\n");
            }
        }

        // Validate Location
        if (locationTextField.getText() == null || locationTextField.getText().trim().isEmpty()) {
            errors.append("• Location is required\n");
        } else if (locationTextField.getText().trim().length() < 3) {
            errors.append("• Location must be at least 3 characters\n");
        }

        // Validate Restock Date
        if (restockDatePicker.getValue() == null) {
            errors.append("• Restock Date is required\n");
        } else if (restockDatePicker.getValue().isAfter(LocalDate.now())) {
            errors.append("• Restock Date cannot be in the future\n");
        }

        if (errors.length() > 0) {
            showErrorMessage("Validation Error", errors.toString());
            return false;
        }

        return true;
    }

    // Helper method to find item by ID
    private Inventory findItemById(String itemId) {
        for (Inventory item : inventoryList) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    // Helper method to generate item ID based on item name
    private String generateItemId(String itemName) {
        // Simple ID generation
        String prefix = "REST";
        String nameCode = itemName.substring(0, Math.min(3, itemName.length())).toUpperCase();
        int randomNum = (int) (Math.random() * 1000);
        return prefix + "-" + nameCode + "-" + String.format("%03d", randomNum);
    }

    // Helper method to suggest location based on item type
    private void suggestLocation(String itemName) {
        // Default location suggestions based on item type
        if (itemName.toLowerCase().contains("toilet") || itemName.toLowerCase().contains("paper")) {
            locationTextField.setText("Restroom Storage A");
        } else if (itemName.toLowerCase().contains("soap") || itemName.toLowerCase().contains("sanitizer")) {
            locationTextField.setText("Cleaning Supply Room");
        } else if (itemName.toLowerCase().contains("cleaner") || itemName.toLowerCase().contains("disinfectant")) {
            locationTextField.setText("Chemical Storage");
        } else {
            locationTextField.setText("Main Storage");
        }
    }

    // Method to clear form fields
    private void clearForm() {
        itemidTextField.clear();
        itemComboBox.setValue(null);
        currentStock.clear();
        locationTextField.clear();
        restockDatePicker.setValue(LocalDate.now());
        restockInfoTableView.getSelectionModel().clearSelection();
    }

    // Method to show success message
    private void showSuccessMessage(String message) {
        successMessegeLabel.setText(message);
        successMessegeLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
    }

    // Method to show error message
    private void showErrorMessage(String title, String message) {
        String fullMessage = "ERROR: " + title + "\n" + message;
        successMessegeLabel.setText(fullMessage);
        successMessegeLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold; -fx-font-size: 12px;");
    }

    // Method to show info message
    private void showInfoMessage(String message) {
        successMessegeLabel.setText(message);
        successMessegeLabel.setStyle("-fx-text-fill: blue; -fx-font-weight: bold; -fx-font-size: 12px;");
    }

    // Method to load sample data for testing
    private void loadSampleData() {
        try {
            // Add some sample inventory items
            Inventory item1 = new Inventory();
            item1.setItemId("REST-TP-001");
            item1.setItemName("Toilet Paper");
            item1.setCurrentStock(15);
            item1.setLocation("Restroom Storage A");
            item1.setLastRestocked(LocalDateTime.now().minusDays(5));

            Inventory item2 = new Inventory();
            item2.setItemId("REST-HS-002");
            item2.setItemName("Hand Soap");
            item2.setCurrentStock(8);
            item2.setLocation("Cleaning Supply Room");
            item2.setLastRestocked(LocalDateTime.now().minusDays(2));

            Inventory item3 = new Inventory();
            item3.setItemId("REST-PT-003");
            item3.setItemName("Paper Towels");
            item3.setCurrentStock(25);
            item3.setLocation("Main Storage");
            item3.setLastRestocked(LocalDateTime.now().minusDays(7));

            inventoryList.addAll(item1, item2, item3);

            // Refresh TableView
            restockInfoTableView.refresh();

            showInfoMessage("Sample data loaded. 3 items added to inventory.");

        } catch (Exception e) {
            showErrorMessage("Sample Data Error", "Failed to load sample data: " + e.getMessage());
        }
    }

    // Getter for inventory list
    public ObservableList<Inventory> getInventoryList() {
        return inventoryList;
    }
}