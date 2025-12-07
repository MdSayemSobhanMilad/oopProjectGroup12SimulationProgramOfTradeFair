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

    @FXML private TextField iteamNameField;
    @FXML private TextField amountField;
    @FXML private ComboBox<String> discountTypeField;
    @FXML private TableView<DiscountsApply> tableView;


    @FXML private TableColumn<DiscountsApply, String> iteamNameView;  // Changed from itemNameView
    @FXML private TableColumn<DiscountsApply, String> amountView;
    @FXML private TableColumn<DiscountsApply, String> discountTypeView;


    private ObservableList<DiscountsApply> discountList;

    @FXML
    public void initialize() {

        discountList = FXCollections.observableArrayList();


        tableView.setItems(discountList);


        setupTableColumns();


        setupDiscountTypes();


        addSampleDiscounts();
    }

    private void setupTableColumns() {
        iteamNameView.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        amountView.setCellValueFactory(new PropertyValueFactory<>("amountString"));
        discountTypeView.setCellValueFactory(new PropertyValueFactory<>("discountType"));
    }

    private void setupDiscountTypes() {

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

        discountList.add(new DiscountsApply("iPhone 15", 50.00, "Fixed Amount Discount"));
        discountList.add(new DiscountsApply("Samsung TV", 15.0, "Percentage Discount"));
        discountList.add(new DiscountsApply("Running Shoes", 20.00, "Member Discount"));
    }

    @FXML
    public void checkOnaction(ActionEvent actionEvent) {

        String itemName = iteamNameField.getText().trim();
        String amountText = amountField.getText().trim();
        String discountType = discountTypeField.getValue();


        if (itemName.isEmpty() || amountText.isEmpty() || discountType == null) {
            return;
        }


        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }


        DiscountsApply newDiscount = new DiscountsApply(itemName, amount, discountType);


        discountList.add(newDiscount);


        clearForm();
    }

    private void clearForm() {
        iteamNameField.clear();
        amountField.clear();
        discountTypeField.setValue(null); // Clear selection
    }

    @FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {

        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }

    private void showMessage(String message, String color) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Discount Manager");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}