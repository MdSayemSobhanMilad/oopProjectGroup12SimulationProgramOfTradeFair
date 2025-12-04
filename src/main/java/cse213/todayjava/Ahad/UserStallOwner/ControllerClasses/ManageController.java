package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import cse213.todayjava.Ahad.UserStallOwner.ProductManages;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.IOException;

public class ManageController {

    @javafx.fxml.FXML
    private TextField productNameField;
    @javafx.fxml.FXML
    private TableColumn quantityColumn;
    @javafx.fxml.FXML
    private TableColumn nameColumn;
    @javafx.fxml.FXML
    private TextField priceField;
    @javafx.fxml.FXML
    private TableView productTable;
    @javafx.fxml.FXML
    private TextField quantityField;
    @javafx.fxml.FXML
    private TableColumn priceColumn;

    @javafx.fxml.FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("productName"));
        priceColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("quantity"));
    }

    @javafx.fxml.FXML
    public void addOnaction(ActionEvent actionEvent) {
        String name = productNameField.getText();
        String priceStr = priceField.getText();
        String quantityStr = quantityField.getText();

        if (name.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            ProductManages product = new ProductManages(name, price, quantity);
            productTable.getItems().add(product);

            productNameField.clear();
            priceField.clear();
            quantityField.clear();

        } catch (NumberFormatException e) {
            // Do nothing
        }
    }

    @javafx.fxml.FXML
    public void editOnaction(ActionEvent actionEvent) {
        ProductManages selectedProduct = (ProductManages) productTable.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            return;
        }

        String name = productNameField.getText();
        String priceStr = priceField.getText();
        String quantityStr = quantityField.getText();

        if (name.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            return;
        }

        try {
            selectedProduct.setProductName(name);
            selectedProduct.setPrice(Double.parseDouble(priceStr));
            selectedProduct.setQuantity(Integer.parseInt(quantityStr));

            productTable.refresh();

        } catch (NumberFormatException e) {
            // Do nothing
        }
    }

    @javafx.fxml.FXML
    public void removeOnaction(ActionEvent actionEvent) {
        ProductManages selectedProduct = (ProductManages) productTable.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            return;
        }

        productTable.getItems().remove(selectedProduct);
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }
}