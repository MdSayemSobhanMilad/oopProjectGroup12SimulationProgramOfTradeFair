package cse213.todayjava.Arabi.UserGovernmentOfficer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

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

    // ToggleGroup for radio buttons
    private ToggleGroup complianceToggleGroup;

    // TableView এর জন্য ডেটা লিস্ট
    private ObservableList<ProductVerification> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Verify Product Compliance Controller Initialized!");

        // Radio buttons এর জন্য ToggleGroup সেট করা
        complianceToggleGroup = new ToggleGroup();
        compliantRadioButton.setToggleGroup(complianceToggleGroup);
        nonCompliantRadioButton.setToggleGroup(complianceToggleGroup);

        // টেবিলের কলাম সেট করা
        stallNoTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStallNo()));

        productNameTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getProductName()));

        officerStallNumberTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getOfficerStallNumber()));

        othersTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getComplianceStatus()));

        // টেবিলে ডেটা সেট করা
        verifyProductComplianceTableView.setItems(productList);

        // Status label প্রাথমিকভাবে খালি রাখা
        statusLabel.setText("");

        // Read data from file on initialization
        readFromFile();
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button clicked!");

        // সব ফিল্ড চেক করা
        String stallNo = stallNoTextField.getText();
        String productName = productNameTextField.getText();
        String officerStallNumber = officerStallNumberTextField.getText();

        // Radio button চেক করা
        String complianceStatus = "";
        if (compliantRadioButton.isSelected()) {
            complianceStatus = "Compliant";
        } else if (nonCompliantRadioButton.isSelected()) {
            complianceStatus = "Non-Compliant";
        }

        // সব ফিল্ড এবং radio button ভরা থাকলে
        if (!stallNo.isEmpty() && !productName.isEmpty() &&
                !officerStallNumber.isEmpty() && !complianceStatus.isEmpty()) {

            // আগের সব ডেটা মুছে দেয়া
            productList.clear();

            // নতুন ProductVerification object তৈরি
            ProductVerification newVerification = new ProductVerification(
                    stallNo, productName, officerStallNumber, complianceStatus);

            // টেবিলে শুধু নতুন ডেটা যোগ করা
            productList.add(newVerification);

            // Status label update - Successful Submit
            statusLabel.setText("Successful Submit");
            System.out.println("New data added to table!");

            // Write data to file
            writeToFile(newVerification);

            // ফিল্ডগুলো খালি করা
            clearFields();
        }
        // কোনো ফিল্ড খালি থাকলে
        else {
            // আগের ডেটাও মুছে দেবে
            productList.clear();

            // Status label update - Failed
            statusLabel.setText("Failed");
            System.out.println("Failed - some fields are empty or radio button not selected!");
        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button clicked!");

        // টেবিলের সব ডেটা মুছে দেবে (history clear)
        productList.clear();
        System.out.println("Table data cleared!");

        // ফাইল থেকে ডেটা মুছবে
        clearFile();

        // Status label clear করা
        statusLabel.setText("");

        // ফিল্ডগুলো খালি করবে
        clearFields();
    }

    @FXML
    private void backOnClick() {
        System.out.println("Back button clicked!");
        // Back button এর কাজ
    }

    private void clearFields() {
        stallNoTextField.clear();
        productNameTextField.clear();
        officerStallNumberTextField.clear();
        complianceToggleGroup.selectToggle(null);
    }

    // File Writing Method
    private void writeToFile(ProductVerification verification) {
        try {
            File file = new File("product_compliance_data.txt");
            FileWriter writer = new FileWriter(file, true); // append mode
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Write data to file
            bufferedWriter.write(verification.getStallNo() + "," +
                    verification.getProductName() + "," +
                    verification.getOfficerStallNumber() + "," +
                    verification.getComplianceStatus());
            bufferedWriter.newLine();

            bufferedWriter.close();
            writer.close();

            System.out.println("Data written to file successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // File Reading Method
    private void readFromFile() {
        try {
            File file = new File("product_compliance_data.txt");
            if (!file.exists()) {
                System.out.println("File does not exist. Creating new file.");
                return;
            }

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    ProductVerification verification = new ProductVerification(
                            data[0], data[1], data[2], data[3]);
                    productList.add(verification);
                }
            }

            bufferedReader.close();
            reader.close();

            System.out.println("Data read from file successfully! Total records: " + productList.size());

        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // File Clearing Method
    private void clearFile() {
        try {
            File file = new File("product_compliance_data.txt");
            if (file.exists()) {
                FileWriter writer = new FileWriter(file);
                writer.write(""); // Clear the file
                writer.close();
                System.out.println("File cleared successfully!");
            }
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}