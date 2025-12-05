package cse213.todayjava.Ahad.UserStallOwner.ControllerClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

public class MaintainStallController {


    @FXML private CheckBox powerSupplayWorkingCheckBox;
    @FXML private CheckBox lightningFunctionalCheckBox;
    @FXML private CheckBox equipmentCleanCheckBox;
    @FXML private CheckBox safetyEquipmentOkCheckBox;


    @FXML private ComboBox<String> issueTypeComboBox;
    @FXML private TextArea isseTypeTextArea;


    @FXML private TableView<TicketData> tableView;
    @FXML private TableColumn<TicketData, String> ticketTableView;
    @FXML private TableColumn<TicketData, String> issueTableView;
    @FXML private TableColumn<TicketData, String> assigntoTableView;
    @FXML private TableColumn<TicketData, String> statusTableView;

    @FXML private TextField lastFixedField;
    @FXML private TextArea markAsFixedTextArea;


    private ObservableList<TicketData> ticketList;
    private Random random = new Random();
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static class TicketData {
        private String ticketId;
        private String issueType;
        private String description;
        private String assignedTo;
        private String status;
        private LocalDateTime reportedDate;
        private LocalDateTime fixedDate;
        private String stallId;

        public TicketData() {}

        public TicketData(String ticketId, String issueType, String description,
                          String assignedTo, String status, String stallId) {
            this.ticketId = ticketId;
            this.issueType = issueType;
            this.description = description;
            this.assignedTo = assignedTo;
            this.status = status;
            this.stallId = stallId;
            this.reportedDate = LocalDateTime.now();
        }


        public String getTicketId() { return ticketId; }
        public String getIssueType() { return issueType; }
        public String getDescription() { return description; }
        public String getAssignedTo() { return assignedTo; }
        public String getStatus() { return status; }
        public LocalDateTime getReportedDate() { return reportedDate; }
        public LocalDateTime getFixedDate() { return fixedDate; }
        public String getStallId() { return stallId; }


        public void setTicketId(String ticketId) { this.ticketId = ticketId; }
        public void setIssueType(String issueType) { this.issueType = issueType; }
        public void setDescription(String description) { this.description = description; }
        public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
        public void setStatus(String status) { this.status = status; }
        public void setFixedDate(LocalDateTime fixedDate) { this.fixedDate = fixedDate; }

        @Override
        public String toString() {
            return ticketId + " - " + issueType;
        }
    }

    @FXML
    public void initialize() {

        ticketList = FXCollections.observableArrayList();


        issueTypeComboBox.setItems(FXCollections.observableArrayList(
                "Electrical Issue", "Plumbing Issue", "Equipment Failure",
                "Structural Damage", "Safety Hazard", "Cleaning Required", "Other"
        ));


        setupTable();


        loadInitialData();
    }

    private void setupTable() {
        ticketTableView.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        issueTableView.setCellValueFactory(new PropertyValueFactory<>("issueType"));
        assigntoTableView.setCellValueFactory(new PropertyValueFactory<>("assignedTo"));
        statusTableView.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableView.setItems(ticketList);
    }

    private void loadInitialData() {

        ticketList.add(new TicketData("TKT-001", "Electrical Issue",
                "Power outlet not working", "Maintenance Team A", "In Progress", "STALL-001"));
        ticketList.add(new TicketData("TKT-002", "Plumbing Issue",
                "Water leakage", "Plumber", "Pending", "STALL-001"));


        lastFixedField.setText(LocalDateTime.now().minusDays(1).format(dateFormatter));
    }

    @FXML
    private void completeChecklistOnaction(ActionEvent event) {
        boolean allChecked = powerSupplayWorkingCheckBox.isSelected() &&
                lightningFunctionalCheckBox.isSelected() &&
                equipmentCleanCheckBox.isSelected() &&
                safetyEquipmentOkCheckBox.isSelected();

        if (allChecked) {

            TicketData checklist = new TicketData(
                    "CHK-" + generateId(),
                    "Daily Checklist",
                    "All daily checks completed successfully",
                    "Self",
                    "Completed",
                    "STALL-001"
            );
            checklist.setFixedDate(LocalDateTime.now());
            ticketList.add(checklist);


            lastFixedField.setText(LocalDateTime.now().format(dateFormatter));


            resetCheckboxes();

            showAlert("Success", "Daily checklist completed!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Incomplete", "Please check all items first.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void submitTicketOnaction(ActionEvent event) {
        String issueType = issueTypeComboBox.getValue();
        String description = isseTypeTextArea.getText().trim();

        if (issueType == null || issueType.isEmpty()) {
            showAlert("Error", "Select an issue type.", Alert.AlertType.WARNING);
            return;
        }

        if (description.isEmpty()) {
            showAlert("Error", "Enter issue description.", Alert.AlertType.WARNING);
            return;
        }


        TicketData newTicket = new TicketData(
                "TKT-" + generateId(),
                issueType,
                description,
                "Not Assigned",
                "Pending",
                "STALL-001"
        );

        ticketList.add(newTicket);


        issueTypeComboBox.setValue(null);
        isseTypeTextArea.clear();

        showAlert("Submitted", "Ticket #" + newTicket.getTicketId() + " created.", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void markasFixedOnaction(ActionEvent event) {
        TicketData selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a ticket first.", Alert.AlertType.WARNING);
            return;
        }

        String notes = markAsFixedTextArea.getText().trim();


        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Fix");
        confirm.setHeaderText("Mark as Fixed");
        confirm.setContentText("Mark ticket " + selected.getTicketId() + " as fixed?");

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            selected.setStatus("Fixed");
            selected.setFixedDate(LocalDateTime.now());

            if (!notes.isEmpty()) {
                selected.setDescription(selected.getDescription() + "\nFix Notes: " + notes);
            }


            tableView.refresh();
            lastFixedField.setText(LocalDateTime.now().format(dateFormatter));
            markAsFixedTextArea.clear();

            showAlert("Fixed", "Ticket marked as fixed.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void backOnaction(ActionEvent event) {
        try {

            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();


            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/cse213/todayjava/Ahad/UserStallOwner/StallOwnerDashboard.fxml"
            ));

            Parent root = loader.load();


            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error",
                    "Cannot load dashboard.\n" +
                            "Make sure StallOwnerDashboard.fxml exists in the correct location.\n" +
                            "Error: " + e.getMessage(),
                    Alert.AlertType.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Navigation failed: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }


    private void backOnactionAlternative(ActionEvent event) {
        try {

            String[] pathsToTry = {
                    "/cse213/todayjava/Ahad/UserStallOwner/StallOwnerDashboard.fxml",
                    "/StallOwnerDashboard.fxml",
                    "../StallOwnerDashboard.fxml",
                    "StallOwnerDashboard.fxml"
            };

            FXMLLoader loader = null;
            Parent root = null;


            for (String path : pathsToTry) {
                try {
                    System.out.println("Trying path: " + path);
                    loader = new FXMLLoader(getClass().getResource(path));
                    root = loader.load();
                    System.out.println("Success with path: " + path);
                    break;
                } catch (Exception ex) {
                    System.out.println("Failed with path: " + path);
                    continue;
                }
            }

            if (root != null) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {

                showAlert("Info",
                        "Dashboard not found. Closing window.\n" +
                                "Please check your FXML file location.",
                        Alert.AlertType.INFORMATION);

                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Navigation failed: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void resetCheckboxes() {
        powerSupplayWorkingCheckBox.setSelected(false);
        lightningFunctionalCheckBox.setSelected(false);
        equipmentCleanCheckBox.setSelected(false);
        safetyEquipmentOkCheckBox.setSelected(false);
    }

    private String generateId() {
        return String.format("%03d", random.nextInt(1000));
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public ObservableList<TicketData> getTicketList() {
        return ticketList;
    }
}