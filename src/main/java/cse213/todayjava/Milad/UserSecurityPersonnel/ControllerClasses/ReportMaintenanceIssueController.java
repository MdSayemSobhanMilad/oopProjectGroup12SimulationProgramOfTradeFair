package cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.MaintenanceTask;
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
import java.util.Locale;
import java.util.ResourceBundle;

public class ReportMaintenanceIssueController implements Initializable {

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
    private ListView<MaintenanceTask> workDoneListView;

    @FXML
    private Label messegeForSuccess;

    List<MaintenanceTask> maintenanceTasks = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tastTypeComboBox.getItems().addAll(
                "Cleaning",
                "Sanitization",
                "Waste Disposal",
                "Floor Maintenance",
                "Restroom Cleaning",
                "Window Cleaning",
                "Equipment Cleaning"
        );

        statusCombobox.getItems().addAll(
                "Pending",
                "Immediate need assistance"
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
            MaintenanceTask task = new MaintenanceTask();

            task.setTaskId(taskIdTextField.getText());
            task.setTaskType(tastTypeComboBox.getValue());
            task.setDescription(descricptionTextField.getText());
            task.setStatus(statusCombobox.getValue());
            task.setReportedTime(reportedTimeDatePicker.getValue());


            maintenanceTasks.add(task);

            showSuccessMessage("Maintenance task added successfully!");


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

        MaintenanceTask selectedTask = workDoneListView.getSelectionModel().getSelectedItem();

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

            workDoneListView.refresh();


            showSuccessMessage("Maintenance task updated successfully!");


            clearForm();

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Failed to update maintenance task: " + e.getMessage());
        }
    }


    @FXML
    public void deleteMaintenanceTask() {
        MaintenanceTask selectedTask = workDoneListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select a task from the list to delete.");
            return;
        }


        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirm Deletion");
        confirmationAlert.setHeaderText("Delete Maintenance Task");
        confirmationAlert.setContentText("Are you sure you want to delete this task?");

        if (confirmationAlert.showAndWait().get() == ButtonType.OK) {
            maintenanceTasks.remove(selectedTask);
            showSuccessMessage("Maintenance task deleted successfully!");
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
            List<MaintenanceTask> filteredList = new ArrayList<>();
            for (MaintenanceTask i: maintenanceTasks) {
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


        if (a == null || b == null || c == null || d == null || e == null) {
            return false;
        }else {
            return true;
        }
    }
}