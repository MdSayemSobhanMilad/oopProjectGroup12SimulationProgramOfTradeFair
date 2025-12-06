package cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;

import cse213.todayjava.Milad.UserSecurityPersonnel.PatrolManagement;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PatrolController implements Initializable {

    @FXML
    private TextField taskIdTextField;

    @FXML
    private TextField descricptionTextField;

    @FXML
    private ComboBox<String> tastTypeComboBox;

    @FXML
    private ComboBox<String> statusCombobox;

    @FXML
    private DatePicker reportedTimeDatePicker;

    @FXML
    private DatePicker completedTimeDatePicker;

    @FXML
    private ListView<PatrolManagement> workDoneListView;

    @FXML
    private Label messegeForSuccess;

    List<PatrolManagement> maintenanceTasks = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tastTypeComboBox.getItems().addAll(
                "Unauthorized Access Attempt",
                "Suspicious Activity Observed",
                "Security Breach Detected",
                "Failed Security Equipment",
                "Access Control Failure",
                "Locked Door Malfunction",
                "Prohibited Item Found",
                "Security Camera Offline",
                "Employee Safety Incident",
                "Fire Alarm Triggered"
        );

        statusCombobox.getItems().addAll(
                "Pending",
                "In Progress",
                "Completed",
                "Cancelled"
        );


    }

    @FXML
    public void addMaintenanceTask(ActionEvent actionEvent) {
        if (!valid()){
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select all the fields");
            return;
        }

        try {
            PatrolManagement task = new PatrolManagement();

            task.setTaskId(taskIdTextField.getText());
            task.setTaskType(tastTypeComboBox.getValue());
            task.setDescription(descricptionTextField.getText());
            task.setStatus(statusCombobox.getValue());
            task.setReportedTime(reportedTimeDatePicker.getValue());
            task.setCompletedTime(completedTimeDatePicker.getValue());


            maintenanceTasks.add(task);

            showSuccessMessage("PatrolManagement task added successfully!");


            workDoneListView.getItems().clear();
            workDoneListView.getItems().addAll(maintenanceTasks);
            clearForm();


        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Failed to create maintenance task: " + e.getMessage());
        }
    }

    @FXML
    public void updateMaintenanceTask() {
        if (!valid()){
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select all the fields");
            return;
        }

        PatrolManagement selectedTask = workDoneListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select a task from the list to update.");
            return;
        }



        try {

            selectedTask.setTaskId(taskIdTextField.getText());
            selectedTask.setTaskType(tastTypeComboBox.getValue());
            selectedTask.setDescription(descricptionTextField.getText());
            selectedTask.setStatus(statusCombobox.getValue());


            if (reportedTimeDatePicker.getValue() != null) {
                selectedTask.setReportedTime(reportedTimeDatePicker.getValue());
            }

            if (completedTimeDatePicker.getValue() != null) {
                selectedTask.setCompletedTime(completedTimeDatePicker.getValue());
            }

            workDoneListView.refresh();


            showSuccessMessage("PatrolManagement task updated successfully!");


            clearForm();

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Failed to update PatrolManagement task: " + e.getMessage());
        }
    }


    @FXML
    public void deleteMaintenanceTask() {
        PatrolManagement selectedTask = workDoneListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select a task from the list to delete.");
            return;
        }


        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirm Deletion");
        confirmationAlert.setHeaderText("DelPatrolManagement Task");
        confirmationAlert.setContentText("Are you sure you want to delete this task?");

        if (confirmationAlert.showAndWait().get() == ButtonType.OK) {
            maintenanceTasks.remove(selectedTask);
            showSuccessMessage("PatrolManagement task deleted successfully!");
            clearForm();
        }
        workDoneListView.getItems().clear();
        workDoneListView.getItems().addAll(maintenanceTasks);

    }


    private void clearForm() {
        taskIdTextField.clear();
        tastTypeComboBox.setValue(null);
        descricptionTextField.clear();
        statusCombobox.setValue(null);
        reportedTimeDatePicker.setValue(null);
        completedTimeDatePicker.setValue(null);
        workDoneListView.getSelectionModel().clearSelection();
    }


    private void showSuccessMessage(String message) {
        messegeForSuccess.setText(message);

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    public void filterByStatus(ActionEvent actionEvent) {
        String selectedStatus = statusCombobox.getValue();
        if (selectedStatus == null || selectedStatus.isEmpty()) {
            workDoneListView.getItems().clear();
            workDoneListView.getItems().addAll(maintenanceTasks);
        } else {
            List<PatrolManagement> filteredList = new ArrayList<>();
            for (PatrolManagement i: maintenanceTasks) {
                if (i.getStatus().equals(selectedStatus)){
                    filteredList.add(i);
                }
            }
            workDoneListView.getItems().clear();
            workDoneListView.getItems().addAll(filteredList);
        }
    }


    @FXML
    public void clearFilter() {
        workDoneListView.getItems().clear();
        workDoneListView.getItems().addAll(maintenanceTasks);
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/securityPersonnelDashboard.fxml", actionEvent);
    }

    private Boolean valid(){
        String a = taskIdTextField.getText();
        String b = tastTypeComboBox.getValue();
        String c = descricptionTextField.getText();
        String d = statusCombobox.getValue();

        LocalDate e = reportedTimeDatePicker.getValue();
        LocalDate f = completedTimeDatePicker.getValue();

        if (a == null || b == null || c == null || d == null || e == null || f == null) {
            return false;
        }else {
            return true;
        }
    }
}