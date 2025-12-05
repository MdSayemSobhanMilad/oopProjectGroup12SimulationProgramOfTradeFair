package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.Ahad.UserStallOwner.InformationProduct;
import cse213.todayjava.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ProductInformationController {
    // FXML elements
    @FXML private TextField productIdField;
    @FXML private TableView<InformationProduct> tableView;
    @FXML private TextArea featuresArea;
    @FXML private TextArea inquiryNotesField;

    // Table columns
    @FXML private TableColumn<InformationProduct, String> productNameView;
    @FXML private TableColumn<InformationProduct, String> priceView;
    @FXML private TableColumn<InformationProduct, String> categoryView;
    @FXML private TableColumn<InformationProduct, String> descriptionView;
    @FXML private TableColumn<InformationProduct, String> stockStatusView;

    // List to hold products for the table
    private ObservableList<InformationProduct> productList;

    // Store the current product being viewed
    private InformationProduct currentProduct;

    @FXML
    public void initialize() {
        // Create an empty list for products
        productList = FXCollections.observableArrayList();

        // Connect the table to our list
        tableView.setItems(productList);

        // Setup table columns
        setupTableColumns();

        // Clear any initial data
        clearAllFields();
    }

    private void setupTableColumns() {
        // Tell each column which property to show from InformationProduct
        productNameView.setCellValueFactory(new PropertyValueFactory<>("productName"));
        priceView.setCellValueFactory(new PropertyValueFactory<>("priceString"));
        categoryView.setCellValueFactory(new PropertyValueFactory<>("category"));
        descriptionView.setCellValueFactory(new PropertyValueFactory<>("description"));
        stockStatusView.setCellValueFactory(new PropertyValueFactory<>("stockStatus"));
    }

    @FXML
    public void searchProductOnaction(ActionEvent actionEvent) {
        // Get the product ID entered by user
        String productId = productIdField.getText().trim();

        // Check if user entered something
        if (productId.isEmpty()) {
            return;
        }

        // Clear previous search results
        productList.clear();
        featuresArea.clear();
        currentProduct = null;

        // Search for product based on ID
        InformationProduct foundProduct = findProductById(productId);

        if (foundProduct != null) {
            // Add found product to table
            productList.add(foundProduct);
            currentProduct = foundProduct;

            // Show product features
            featuresArea.setText(foundProduct.getFeatures());


        }
    }

    private InformationProduct findProductById(String productId) {

        if (productId.equals("1")) {
            return new InformationProduct("iPhone 15", 999.99, "Electronics",
                    "Latest smartphone with advanced camera", "In Stock",
                    "6.7-inch display\n48MP camera\n5G support\n256GB storage");
        }
        else if (productId.equals("2")) {
            return new InformationProduct("Samsung TV", 799.50, "Electronics",
                    "55-inch 4K Smart TV", "Low Stock",
                    "4K UHD resolution\nSmart TV features\nHDR support\nBuilt-in apps");
        }
        else if (productId.equals("3")) {
            return new InformationProduct("Running Shoes", 129.99, "Footwear",
                    "Comfortable running shoes", "In Stock",
                    "Lightweight design\nCushioned soles\nBreathable material\nSize: 7-12");
        }
        else if (productId.equals("4")) {
            return new InformationProduct("Coffee Maker", 89.99, "Home Appliances",
                    "Automatic coffee machine", "Out of Stock",
                    "12-cup capacity\nProgrammable timer\nKeep-warm function\nFilter included");
        }
        else if (productId.equals("5")) {
            return new InformationProduct("Book Set", 149.99, "Books",
                    "Complete 7-book collection", "In Stock",
                    "Hardcover edition\nIllustrated pages\nCollector's edition\nGift box included");
        }

        // If no product matches the ID
        return null;
    }

    @FXML
    public void saveInquiryOnaction(ActionEvent actionEvent) {
        // Get the inquiry notes
        String inquiry = inquiryNotesField.getText().trim();

        // Check if there's something to save
        if (inquiry.isEmpty()) {
            return;
        }

        // Check if a product is selected
        if (currentProduct == null) {
            return;
        }

        // Create inquiry summary
        String summary = "=== INQUIRY SAVED ===\n\n";
        summary += "Product: " + currentProduct.getProductName() + "\n";
        summary += "Inquiry Date: Today\n";
        summary += "Customer Notes:\n" + inquiry + "\n\n";
        summary += "Inquiry saved successfully!";


        // Clear the inquiry field
        inquiryNotesField.clear();

        // Optionally, you could show the summary in a dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inquiry Saved");
        alert.setHeaderText("Customer inquiry has been saved");
        alert.setContentText("Product: " + currentProduct.getProductName() +
                "\nInquiry notes saved successfully!");
        alert.showAndWait();
    }

    @FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        // Go back to dashboard
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }

    private void clearAllFields() {
        productIdField.clear();
        featuresArea.clear();
        inquiryNotesField.clear();
        productList.clear();
    }

    private void showMessage(String message, String color) {
        // Create an alert to show messages
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Product Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}