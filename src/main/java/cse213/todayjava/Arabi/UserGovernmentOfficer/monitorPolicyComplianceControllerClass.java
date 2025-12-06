package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class monitorPolicyComplianceControllerClass {

    @FXML
    private TextField stallNameTextField;

    @FXML
    private TextArea violenceDetailsTextArea;

    @FXML
    private TableView<PolicyCompliance> monitorPolicyComplianceTableView;

    @FXML
    private TableColumn<PolicyCompliance, String> stallNameTableColumn;

    @FXML
    private TableColumn<PolicyCompliance, String> violenceDetailsTableColumn;

    @FXML
    private Label statusLabel;


    private ObservableList<PolicyCompliance> currentDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Monitor Policy Compliance Controller Initialized!");


        stallNameTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStallName()));

        violenceDetailsTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getViolenceDetails()));


        monitorPolicyComplianceTableView.setItems(currentDataList);


        statusLabel.setText("");
    }

    @FXML
    private void uploadOnClick() {
        System.out.println("Upload button clicked!");
        processData();
    }

    @FXML
    private void saveOnClick() {
        System.out.println("Save button clicked!");
        processData();
    }

    private void processData() {

        String stallName = stallNameTextField.getText();
        String violenceDetails = violenceDetailsTextArea.getText();

        System.out.println("Stall Name: " + stallName);
        System.out.println("Violence Details: " + violenceDetails);


        if (!stallName.isEmpty() && !violenceDetails.isEmpty()) {

            currentDataList.clear();


            PolicyCompliance newCompliance = new PolicyCompliance(stallName, violenceDetails);


            currentDataList.add(newCompliance);


            statusLabel.setText("Successful Submit");
            System.out.println("New data added to table!");


            clearFields();
        }

        else {

            currentDataList.clear();


            statusLabel.setText("Failed");
            System.out.println("Failed - some fields are empty!");
        }
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }

    private void clearFields() {
        stallNameTextField.clear();
        violenceDetailsTextArea.clear();
    }
}