package cse213.todayjava.Arabi.UserGovernmentOfficer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class inspectExhibitorLicensesControllerClass {

    @FXML
    private TextField exhibitorNameTextFied;

    @FXML
    private TextField licenseNumberTextField;

    @FXML
    private TextField stallNoTextField;

    @FXML
    private TableView<ExhibitorLicense> inspectExhibitorLicensesTableView;

    @FXML
    private TableColumn<ExhibitorLicense, String> exhibitorNameTableColumn;

    @FXML
    private TableColumn<ExhibitorLicense, String> stallNoTableColumn;

    @FXML
    private TableColumn<ExhibitorLicense, String> licenseNumberTableColumn;

    @FXML
    private Label statusLabel;

    // নতুন ডেটার জন্য খালি লিস্ট
    private ObservableList<ExhibitorLicense> tempDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // টেবিলের কলাম সেট করা
        exhibitorNameTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getExhibitorName()));

        stallNoTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getStallNo()));

        licenseNumberTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getLicenseNumber()));

        // প্রথমে টেবিলে কিছুই দেখাবে না
        inspectExhibitorLicensesTableView.getItems().clear();
    }

    @FXML
    private void approveOnClick() {
        // সব ফিল্ড চেক করা
        String exhibitorName = exhibitorNameTextFied.getText();
        String stallNo = stallNoTextField.getText();
        String licenseNumber = licenseNumberTextField.getText();

        // সব ফিল্ড ভরা থাকলে
        if (!exhibitorName.isEmpty() && !stallNo.isEmpty() && !licenseNumber.isEmpty()) {
            // আগের সব ডেটা মুছে দিতে হবে (clear)
            tempDataList.clear();
            inspectExhibitorLicensesTableView.getItems().clear();

            // নতুন ডেটা তৈরি
            ExhibitorLicense newLicense = new ExhibitorLicense(exhibitorName, stallNo, licenseNumber);

            // খালি লিস্টে যোগ করা
            tempDataList.add(newLicense);

            // টেবিলে শুধু নতুন ডেটা যোগ করা
            inspectExhibitorLicensesTableView.getItems().add(newLicense);

            // স্ট্যাটাস লেবেলে Approved দেখানো
            statusLabel.setText("Approved");

            // ফিল্ডগুলো খালি করা
            exhibitorNameTextFied.clear();
            stallNoTextField.clear();
            licenseNumberTextField.clear();
        }
        // কোনো ফিল্ড খালি থাকলে
        else {
            // স্ট্যাটাস লেবেলে Failed দেখানো
            statusLabel.setText("Failed");

            // টেবিলে আগের ডেটা থাকলে সেটাও মুছে দেবে
            inspectExhibitorLicensesTableView.getItems().clear();
            tempDataList.clear();
        }
    }

    @FXML
    private void backOnClick() {
        // Back button এর কাজ
        System.out.println("Back button clicked");
    }
}