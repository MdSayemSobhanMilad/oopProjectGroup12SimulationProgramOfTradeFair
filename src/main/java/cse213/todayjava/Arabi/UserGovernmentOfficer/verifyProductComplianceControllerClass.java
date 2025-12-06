package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class verifyProductComplianceControllerClass {

    @FXML
    private TextField stallNoTextField;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TextField officerStallNumberTextField;

    @FXML
    private RadioButton compliantRadioButton;

    @FXML
    private RadioButton nonCompliantRadioButton;

    @FXML
    private TableView<ProductVerification> verifyProductComplianceTableView;

    @FXML
    private TableColumn<ProductVerification, String> stallNoTableColumn;

    @FXML
    private TableColumn<ProductVerification, String> productNameTableColumn;

    @FXML
    private TableColumn<ProductVerification, String> officerStallNumberTableColumn;

    @FXML
    private TableColumn<ProductVerification, String> othersTableColumn;

    @FXML
    private Label statusLabel;

    private ToggleGroup complianceToggleGroup;
    private ObservableList<ProductVerification> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Controller Started");

        complianceToggleGroup = new ToggleGroup();
        compliantRadioButton.setToggleGroup(complianceToggleGroup);
        nonCompliantRadioButton.setToggleGroup(complianceToggleGroup);

        stallNoTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStallNo()));

        productNameTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getProductName()));

        officerStallNumberTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getOfficerStallNumber()));

        othersTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getComplianceStatus()));

        verifyProductComplianceTableView.setItems(productList);
        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button click!");

        String stallNo = stallNoTextField.getText();
        String productName = productNameTextField.getText();
        String officerStallNumber = officerStallNumberTextField.getText();

        String complianceStatus = "";
        if (compliantRadioButton.isSelected()) {
            complianceStatus = "Compliant";
        } else if (nonCompliantRadioButton.isSelected()) {
            complianceStatus = "Non Compliant";
        }

        if (stallNo.isEmpty() || productName.isEmpty() ||
                officerStallNumber.isEmpty() || complianceStatus.isEmpty()) {
            statusLabel.setText("failed");
            System.out.println("Field empty");
            return;
        }

        ProductVerification newVerification = new ProductVerification(
                stallNo, productName, officerStallNumber, complianceStatus);

        productList.add(newVerification);
        statusLabel.setText("successful");
        System.out.println("Table added data");

        clearFields();
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button click");

        productList.clear();
        statusLabel.setText("");
        clearFields();
        System.out.println("Table history clear");
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        stallNoTextField.clear();
        productNameTextField.clear();
        officerStallNumberTextField.clear();
        complianceToggleGroup.selectToggle(null);
    }
}