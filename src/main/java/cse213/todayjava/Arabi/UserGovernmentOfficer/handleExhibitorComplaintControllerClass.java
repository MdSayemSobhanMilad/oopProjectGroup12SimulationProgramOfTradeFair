package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

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


    private ObservableList<ExhibitorComplaint> complaintList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Handle Exhibitor Complaint Controller Initialized!");


        selectedComplaintTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getSelectedComplaint()));

        resolutionNotesTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getResolutionNotes()));


        handleExhibitorComplaintTableView.setItems(complaintList);

        statusLabel.setText("");
    }

    @FXML
    private void submitOnClick() {
        System.out.println("Submit button clicked!");


        String complaint = selectedComplaintTextField.getText();
        String notes = resolutionNotesTextArea.getText();


        if (!complaint.isEmpty() && !notes.isEmpty()) {

            ExhibitorComplaint newComplaint = new ExhibitorComplaint(complaint, notes);


            complaintList.add(newComplaint);
            System.out.println("Data added to table: " + newComplaint);


            statusLabel.setText("Successful Submit");


            selectedComplaintTextField.clear();
            resolutionNotesTextArea.clear();
        }

        else {
            System.out.println("Some fields are empty. Not adding to table.");


            statusLabel.setText("Failed");


        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button clicked!");


        complaintList.clear();
        System.out.println("Table data cleared!");


        statusLabel.setText("");


        selectedComplaintTextField.clear();
        resolutionNotesTextArea.clear();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }
}