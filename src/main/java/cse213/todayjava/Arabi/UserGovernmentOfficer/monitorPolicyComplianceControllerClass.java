package cse213.todayjava.Arabi.UserGovernmentOfficer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    // TableView এর জন্য ডেটা লিস্ট (শুধু বর্তমান ডেটা)
    private ObservableList<PolicyCompliance> currentDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Monitor Policy Compliance Controller Initialized!");

        // টেবিলের কলাম সেট করা
        stallNameTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStallName()));

        violenceDetailsTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getViolenceDetails()));

        // টেবিলে ডেটা সেট করা
        monitorPolicyComplianceTableView.setItems(currentDataList);

        // Status label প্রাথমিকভাবে খালি রাখা
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
        // সব ফিল্ড চেক করা
        String stallName = stallNameTextField.getText();
        String violenceDetails = violenceDetailsTextArea.getText();

        System.out.println("Stall Name: " + stallName);
        System.out.println("Violence Details: " + violenceDetails);

        // সব ফিল্ড ভরা থাকলে
        if (!stallName.isEmpty() && !violenceDetails.isEmpty()) {
            // আগের সব ডেটা মুছে দেয়া (history clear)
            currentDataList.clear();

            // নতুন PolicyCompliance object তৈরি
            PolicyCompliance newCompliance = new PolicyCompliance(stallName, violenceDetails);

            // টেবিলে শুধু নতুন ডেটা যোগ করা
            currentDataList.add(newCompliance);

            // Status label update - Successful Submit
            statusLabel.setText("Successful Submit");
            System.out.println("New data added to table!");

            // ফিল্ডগুলো খালি করা
            clearFields();
        }
        // কোনো ফিল্ড খালি থাকলে
        else {
            // আগের ডেটাও মুছে দেবে
            currentDataList.clear();

            // Status label update - Failed
            statusLabel.setText("Failed");
            System.out.println("Failed - some fields are empty!");
        }
    }

    @FXML
    private void backOnClick() {
        System.out.println("Back button clicked!");
        // Back button এর কাজ
    }

    private void clearFields() {
        stallNameTextField.clear();
        violenceDetailsTextArea.clear();
    }
}