package cse213.todayjava.Arabi.UserGovernmentOfficer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class handleExhibitorComplaintControllerClass {

    @FXML
    private TextField selectedComplaintTextField;

    @FXML
    private TextArea resolutionNotesTextArea;

    @FXML
    private TableView<ExhibitorComplaint> handleExhibitorComplaintTableView;

    @FXML
    private TableColumn<ExhibitorComplaint, String> selectedComplaintTableColumn;

    @FXML
    private TableColumn<ExhibitorComplaint, String> resolutionNotesTableColumn;

    @FXML
    private Label statusLabel;

    // TableView এর জন্য ডেটা লিস্ট
    private ObservableList<ExhibitorComplaint> complaintList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Handle Exhibitor Complaint Controller Initialized!");

        // টেবিলের কলাম সেট করা
        selectedComplaintTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getSelectedComplaint()));

        resolutionNotesTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getResolutionNotes()));

        // টেবিলে ডেটা সেট করা
        handleExhibitorComplaintTableView.setItems(complaintList);

        // Status label প্রাথমিকভাবে খালি রাখা
        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button clicked!");

        // সব ফিল্ড চেক করা
        String complaint = selectedComplaintTextField.getText();
        String notes = resolutionNotesTextArea.getText();

        // সব ফিল্ড ভরা থাকলে
        if (!complaint.isEmpty() && !notes.isEmpty()) {
            // নতুন ডেটা তৈরি
            ExhibitorComplaint newComplaint = new ExhibitorComplaint(complaint, notes);

            // টেবিলে যোগ করা
            complaintList.add(newComplaint);
            System.out.println("Data added to table: " + newComplaint);

            // Status label এ Successful Submit দেখানো
            statusLabel.setText("Successful Submit");

            // ফিল্ডগুলো খালি করা
            selectedComplaintTextField.clear();
            resolutionNotesTextArea.clear();
        }
        // কোনো ফিল্ড খালি থাকলে
        else {
            System.out.println("Some fields are empty. Not adding to table.");

            // Status label এ Failed দেখানো
            statusLabel.setText("Failed");

            // টেবিলে কিছু যোগ করবে না
        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button clicked!");

        // টেবিলের সব ডেটা মুছে দেবে (history clear)
        complaintList.clear();
        System.out.println("Table data cleared!");

        // Status label clear করা
        statusLabel.setText("");

        // ফিল্ডগুলো খালি করবে (ঐচ্ছিক)
        selectedComplaintTextField.clear();
        resolutionNotesTextArea.clear();
    }

    @FXML
    private void backOnClick() {
        System.out.println("Back button clicked!");
        // আপনার back navigation code এখানে যোগ করুন
    }
}