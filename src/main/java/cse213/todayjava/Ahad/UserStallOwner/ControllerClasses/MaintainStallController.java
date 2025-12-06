package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import cse213.todayjava.Ahad.UserStallOwner.StallMaintain;
import cse213.todayjava.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class MaintainStallController {
    // FXML elements - Daily Checklist
    @FXML private CheckBox powerSupplayWorkingCheckBox;
    @FXML private CheckBox lightningFunctionalCheckBox;
    @FXML private CheckBox equipmentCleanCheckBox;
    @FXML private CheckBox safetyEquipmentOkCheckBox;

    // FXML elements - Report Issue
    @FXML private ComboBox<String> issueTypeComboBox;
    @FXML private TextArea isseTypeTextArea;

    // FXML elements - Maintenance Status
    @FXML private TableView<StallMaintain> tableView;
    @FXML private TableColumn<StallMaintain, String> ticketTableView;
    @FXML private TableColumn<StallMaintain, String> issueTableView;
    @FXML private TableColumn<StallMaintain, String> assigntoTableView;
    @FXML private TableColumn<StallMaintain, String> statusTableView;

    // FXML elements - Last Fixed
    @FXML private TextField lastFixedField;
    @FXML private TextArea markAsFixedTextArea;

    // List to hold maintenance tickets
    private ObservableList<StallMaintain> ticketList;

    // Counter for ticket IDs
    private int ticketCounter = 1;

    @FXML
    public void initialize() {
        // Create list for tickets
        ticketList = FXCollections.observableArrayList();

        // Connect table to our list
        tableView.setItems(ticketList);

        // Setup table columns
        setupTableColumns();

        // Setup issue types dropdown
        setupIssueTypes();

        // Add some sample tickets
        addSampleTickets();

        // Clear text areas
        isseTypeTextArea.clear();
        markAsFixedTextArea.clear();
        lastFixedField.clear();
    }

    private void setupTableColumns() {
        // Connect each column to StallMaintain properties
        ticketTableView.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        issueTableView.setCellValueFactory(new PropertyValueFactory<>("issue"));
        assigntoTableView.setCellValueFactory(new PropertyValueFactory<>("assignedTo"));
        statusTableView.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void setupIssueTypes() {
        // Add issue types to dropdown
        issueTypeComboBox.getItems().addAll(
                "Electrical Issue",
                "Lighting Problem",
                "Equipment Failure",
                "Safety Concern",
                "Cleaning Required",
                "Structural Damage",
                "Plumbing Issue",
                "Other"
        );
    }

    private void addSampleTickets() {
        // Add some sample maintenance tickets
        ticketList.add(new StallMaintain("T001", "Light bulb needs replacement", "Maintenance Team", "Pending"));
        ticketList.add(new StallMaintain("T002", "Power outlet not working", "Electrician", "In Progress"));
        ticketList.add(new StallMaintain("T003", "Clean equipment needed", "Cleaning Staff", "Completed"));
    }

    @FXML
    public void completeChecklistOnaction(ActionEvent actionEvent) {
        // Check which checklist items are completed
        boolean powerOk = powerSupplayWorkingCheckBox.isSelected();
        boolean lightingOk = lightningFunctionalCheckBox.isSelected();
        boolean equipmentOk = equipmentCleanCheckBox.isSelected();
        boolean safetyOk = safetyEquipmentOkCheckBox.isSelected();

        // Create checklist summary
        StringBuilder checklistSummary = new StringBuilder();
        checklistSummary.append("=== DAILY CHECKLIST SUMMARY ===\n");
        checklistSummary.append("══════════════════════════════\n\n");

        checklistSummary.append("1. Power Supply: " + (powerOk ? "✓ OK" : "✗ NEEDS CHECK") + "\n");
        checklistSummary.append("2. Lighting: " + (lightingOk ? "✓ OK" : "✗ NEEDS CHECK") + "\n");
        checklistSummary.append("3. Equipment Clean: " + (equipmentOk ? "✓ OK" : "✗ NEEDS CHECK") + "\n");
        checklistSummary.append("4. Safety Equipment: " + (safetyOk ? "✓ OK" : "✗ NEEDS CHECK") + "\n\n");

        // Count completed items
        int completedCount = 0;
        if (powerOk) completedCount++;
        if (lightingOk) completedCount++;
        if (equipmentOk) completedCount++;
        if (safetyOk) completedCount++;

        checklistSummary.append("Completed: " + completedCount + "/4 items\n");

        if (completedCount == 4) {
            checklistSummary.append("✅ ALL CHECKS COMPLETE - STALL READY ✅");
        } else {
            checklistSummary.append("⚠️ ATTENTION NEEDED: " + (4 - completedCount) + " item(s) to check");
        }

        // Show in the "Mark as Fixed" text area
        markAsFixedTextArea.setText(checklistSummary.toString());

        // Show message
        showMessage("Daily checklist completed!\n" + completedCount + "/4 items checked", "green");
    }

    @FXML
    public void submitTicketOnaction(ActionEvent actionEvent) {
        // Get issue type and description
        String issueType = issueTypeComboBox.getValue();
        String issueDescription = isseTypeTextArea.getText().trim();

        // Check if both fields are filled
        if (issueType == null || issueDescription.isEmpty()) {
            showMessage("Please select issue type and describe the problem!", "red");
            return;
        }

        // Create new ticket ID
        String ticketId = "T" + String.format("%03d", ticketCounter);
        ticketCounter++;

        // Create new maintenance ticket
        StallMaintain newTicket = new StallMaintain(
                ticketId,
                issueType + ": " + issueDescription,
                "Not Assigned Yet",
                "New"
        );

        // Add to table
        ticketList.add(newTicket);

        // Clear the form
        issueTypeComboBox.setValue(null);
        isseTypeTextArea.clear();

        // Show success message
        showMessage("Ticket #" + ticketId + " submitted successfully!", "green");
    }

    @FXML
    public void markasFixedOnaction(ActionEvent actionEvent) {
        // Get selected ticket from table
        StallMaintain selectedTicket = tableView.getSelectionModel().getSelectedItem();

        if (selectedTicket == null) {
            showMessage("Please select a ticket from the table first!", "red");
            return;
        }

        // Get what was last fixed
        String lastFixed = lastFixedField.getText().trim();

        if (lastFixed.isEmpty()) {
            showMessage("Please enter what was fixed in 'Last Fixed' field!", "red");
            return;
        }

        // Update ticket status
        selectedTicket.setStatus("Fixed");

        // Refresh table
        tableView.refresh();

        // Create fixed report
        String fixedReport = "=== MAINTENANCE COMPLETED ===\n";
        fixedReport += "════════════════════════════\n\n";
        fixedReport += "Ticket ID: " + selectedTicket.getTicketId() + "\n";
        fixedReport += "Issue: " + selectedTicket.getIssue() + "\n";
        fixedReport += "Assigned To: " + selectedTicket.getAssignedTo() + "\n";
        fixedReport += "Status: ✅ FIXED ✅\n\n";
        fixedReport += "Work Done: " + lastFixed + "\n\n";
        fixedReport += "Date Fixed: Today\n";
        fixedReport += "Maintenance Complete!";

        // Show in text area
        markAsFixedTextArea.setText(fixedReport);

        // Clear last fixed field
        lastFixedField.clear();

        showMessage("Ticket #" + selectedTicket.getTicketId() + " marked as fixed!", "green");
    }

    @FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        // Go back to dashboard
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserStallOwner/stallOwnerDashboard.fxml", actionEvent);
    }

    private void showMessage(String message, String color) {
        // Create an alert to show messages
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Stall Maintenance");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}