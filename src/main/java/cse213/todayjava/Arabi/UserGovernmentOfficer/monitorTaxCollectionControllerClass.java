package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

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
    private TableColumn<TaxCollection, String> totalTaxTableColumn;

    @FXML
    private TableColumn<TaxCollection, String> pendingTableColumn;

    @FXML
    private TableColumn<TaxCollection, String> statusTableColumn;

    @FXML
    private Label statusLabel;

    private ToggleGroup statusToggleGroup;
    private ObservableList<TaxCollection> taxList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Tax Collection Controller Started");


        statusToggleGroup = new ToggleGroup();
        allPaidRadioButton.setToggleGroup(statusToggleGroup);
        pendingRadioButton.setToggleGroup(statusToggleGroup);


        totalTaxTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getTotalTax()));

        pendingTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getPending()));

        statusTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStatus()));


        monitorTaxCollectionTableView.setItems(taxList);


        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button click!");


        String totalTax = totalTaxTextField.getText();
        String pending = pendingTextField.getText();


        String status = "";
        if (allPaidRadioButton.isSelected()) {
            status = "All Paid";
        } else if (pendingRadioButton.isSelected()) {
            status = "Pending";
        }


        if (totalTax.isEmpty() || pending.isEmpty() || status.isEmpty()) {

            statusLabel.setText("failed");
            System.out.println("Field khali ache!");
            return;
        }



        TaxCollection newTax = new TaxCollection(totalTax, pending, status);


        taxList.add(newTax);


        statusLabel.setText("successful");
        System.out.println("Table e data add hoise!");


        clearFields();
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button click!");


        taxList.clear();


        statusLabel.setText("");


        clearFields();

        System.out.println("Table history clear hoise!");
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        totalTaxTextField.clear();
        pendingTextField.clear();
        statusToggleGroup.selectToggle(null);
    }
}