package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.MaintenanceTask;
import cse213.todayjava.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CleaningController implements Initializable {

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
    private ListView<MaintenanceTask> workDoneListView;

    @FXML
    private Label messegeForSuccess;

    private ObservableList<MaintenanceTask> maintenanceTasks = FXCollections.observableArrayList();

    // Formatters for date and time display
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize ComboBoxes with options
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
                "In Progress",
                "Completed",
                "Cancelled"
        );

        // Set up ListView cell factory to display MaintenanceTask objects properly
        workDoneListView.setCellFactory(lv -> new ListCell<MaintenanceTask>() {
            @Override
            protected void updateItem(MaintenanceTask task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                } else {
                    String reportedTime = task.getReportedTime() != null ?
                            task.getReportedTime().format(dateTimeFormatter) : "N/A";
                    String completedTime = task.getCompletedTime() != null ?
                            task.getCompletedTime().format(dateTimeFormatter) : "N/A";

                    setText(String.format("Task ID: %s | Type: %s | Status: %s\nDescription: %s\nReported: %s | Completed: %s",
                            task.getTaskId(),
                            task.getTaskType(),
                            task.getStatus(),
                            task.getDescription(),
                            reportedTime,
                            completedTime
                    ));
                }
            }
        });

        // Set the items for ListView
        workDoneListView.setItems(maintenanceTasks);

        // Clear success message after 3 seconds
        messegeForSuccess.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                javafx.application.Platform.runLater(() -> messegeForSuccess.setText(""));
                            }
                        },
                        3000
                );
            }
        });
    }

    // Method to handle adding a maintenance task
    @FXML
    public void addMaintenanceTask() {
        // Validate all fields
        if (!validateInput()) {
            return;
        }

        try {
            // Create LocalDateTime objects from DatePickers (using current time for time portion)
            LocalDateTime reportedDateTime = null;
            if (reportedTimeDatePicker.getValue() != null) {
                reportedDateTime = LocalDateTime.of(reportedTimeDatePicker.getValue(), LocalTime.now());
            }

            LocalDateTime completedDateTime = null;
            if (completedTimeDatePicker.getValue() != null) {
                completedDateTime = LocalDateTime.of(completedTimeDatePicker.getValue(), LocalTime.now());
            }

            // Create new MaintenanceTask object
            MaintenanceTask task = new MaintenanceTask();
            task.setTaskId(taskIdTextField.getText().trim());
            task.setTaskType(tastTypeComboBox.getValue());
            task.setDescription(descricptionTextField.getText().trim());
            task.setStatus(statusCombobox.getValue());
            task.setReportedTime(reportedDateTime);
            task.setCompletedTime(completedDateTime);

            // Add to the list
            maintenanceTasks.add(task);

            // Show success message
            showSuccessMessage("Maintenance task added successfully!");

            // Clear form fields
            clearForm();

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Failed to create maintenance task: " + e.getMessage());
        }
    }

    // Method to handle updating a maintenance task
    @FXML
    public void updateMaintenanceTask() {
        MaintenanceTask selectedTask = workDoneListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select a task from the list to update.");
            return;
        }

        if (!validateInput()) {
            return;
        }

        try {
            // Update selected task with new values
            selectedTask.setTaskId(taskIdTextField.getText().trim());
            selectedTask.setTaskType(tastTypeComboBox.getValue());
            selectedTask.setDescription(descricptionTextField.getText().trim());
            selectedTask.setStatus(statusCombobox.getValue());

            // Update date times
            if (reportedTimeDatePicker.getValue() != null) {
                LocalDateTime reportedDateTime = LocalDateTime.of(
                        reportedTimeDatePicker.getValue(),
                        selectedTask.getReportedTime() != null ?
                                selectedTask.getReportedTime().toLocalTime() : LocalTime.now()
                );
                selectedTask.setReportedTime(reportedDateTime);
            }

            if (completedTimeDatePicker.getValue() != null) {
                LocalDateTime completedDateTime = LocalDateTime.of(
                        completedTimeDatePicker.getValue(),
                        selectedTask.getCompletedTime() != null ?
                                selectedTask.getCompletedTime().toLocalTime() : LocalTime.now()
                );
                selectedTask.setCompletedTime(completedDateTime);
            }

            // Refresh ListView
            workDoneListView.refresh();

            // Show success message
            showSuccessMessage("Maintenance task updated successfully!");

            // Clear form fields
            clearForm();

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Failed to update maintenance task: " + e.getMessage());
        }
    }

    // Method to handle deleting a maintenance task
    @FXML
    public void deleteMaintenanceTask() {
        MaintenanceTask selectedTask = workDoneListView.getSelectionModel().getSelectedItem();

        if (selectedTask == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select a task from the list to delete.");
            return;
        }

        // Confirm deletion
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirm Deletion");
        confirmationAlert.setHeaderText("Delete Maintenance Task");
        confirmationAlert.setContentText("Are you sure you want to delete this task?\nTask ID: " + selectedTask.getTaskId());

        if (confirmationAlert.showAndWait().get() == ButtonType.OK) {
            maintenanceTasks.remove(selectedTask);
            showSuccessMessage("Maintenance task deleted successfully!");
            clearForm();
        }
    }

    // Method to load selected task details into form for editing
    @FXML
    public void loadTaskDetails() {
        MaintenanceTask selectedTask = workDoneListView.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            // Load task details into form fields
            taskIdTextField.setText(selectedTask.getTaskId());
            tastTypeComboBox.setValue(selectedTask.getTaskType());
            descricptionTextField.setText(selectedTask.getDescription());
            statusCombobox.setValue(selectedTask.getStatus());

            // Set DatePicker values
            if (selectedTask.getReportedTime() != null) {
                reportedTimeDatePicker.setValue(selectedTask.getReportedTime().toLocalDate());
            } else {
                reportedTimeDatePicker.setValue(null);
            }

            if (selectedTask.getCompletedTime() != null) {
                completedTimeDatePicker.setValue(selectedTask.getCompletedTime().toLocalDate());
            } else {
                completedTimeDatePicker.setValue(null);
            }

            messegeForSuccess.setText("Task loaded for editing. Click 'Update' to save changes.");
        }
    }

    // Validation method
    private boolean validateInput() {
        StringBuilder errorMessage = new StringBuilder();

        // Validate Task ID
        if (taskIdTextField.getText() == null || taskIdTextField.getText().trim().isEmpty()) {
            errorMessage.append("• Task ID is required\n");
        }

        // Validate Task Type
        if (tastTypeComboBox.getValue() == null || tastTypeComboBox.getValue().trim().isEmpty()) {
            errorMessage.append("• Task Type is required\n");
        }

        // Validate Description
        if (descricptionTextField.getText() == null || descricptionTextField.getText().trim().isEmpty()) {
            errorMessage.append("• Description is required\n");
        } else if (descricptionTextField.getText().trim().length() < 5) {
            errorMessage.append("• Description must be at least 5 characters\n");
        }

        // Validate Status
        if (statusCombobox.getValue() == null || statusCombobox.getValue().trim().isEmpty()) {
            errorMessage.append("• Status is required\n");
        }

        // Validate Reported Time
        if (reportedTimeDatePicker.getValue() == null) {
            errorMessage.append("• Reported Time is required\n");
        } else if (reportedTimeDatePicker.getValue().isAfter(LocalDate.now())) {
            errorMessage.append("• Reported Time cannot be in the future\n");
        }

        // Validate Completed Time if status is "Completed"
        if ("Completed".equals(statusCombobox.getValue())) {
            if (completedTimeDatePicker.getValue() == null) {
                errorMessage.append("• Completed Time is required when status is 'Completed'\n");
            } else if (reportedTimeDatePicker.getValue() != null &&
                    completedTimeDatePicker.getValue().isBefore(reportedTimeDatePicker.getValue())) {
                errorMessage.append("• Completed Time cannot be before Reported Time\n");
            }
        }

        // Check if task ID already exists (for new tasks)
        boolean isNewTask = workDoneListView.getItems().stream()
                .noneMatch(task -> task.getTaskId().equals(taskIdTextField.getText().trim()));

        MaintenanceTask selectedTask = workDoneListView.getSelectionModel().getSelectedItem();
        if (selectedTask == null && !isNewTask) {
            errorMessage.append("• Task ID already exists\n");
        }

        // Show error message if any validation failed
        if (errorMessage.length() > 0) {
            showAlert(Alert.AlertType.ERROR, "Validation Error",
                    "Please correct the following errors:\n\n" + errorMessage.toString());
            return false;
        }

        return true;
    }

    // Method to clear form fields
    private void clearForm() {
        taskIdTextField.clear();
        tastTypeComboBox.setValue(null);
        descricptionTextField.clear();
        statusCombobox.setValue(null);
        reportedTimeDatePicker.setValue(null);
        completedTimeDatePicker.setValue(null);
        workDoneListView.getSelectionModel().clearSelection();
    }

    // Method to show success message
    private void showSuccessMessage(String message) {
        messegeForSuccess.setText(message);
        messegeForSuccess.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
    }

    // Method to show alert dialog
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to filter tasks by status
    @FXML
    public void filterByStatus() {
        String selectedStatus = statusCombobox.getValue();
        if (selectedStatus == null || selectedStatus.isEmpty()) {
            workDoneListView.setItems(maintenanceTasks);
        } else {
            ObservableList<MaintenanceTask> filteredList = maintenanceTasks.filtered(
                    task -> task.getStatus().equals(selectedStatus)
            );
            workDoneListView.setItems(filteredList);
        }
    }

    // Method to clear filter
    @FXML
    public void clearFilter() {
        workDoneListView.setItems(maintenanceTasks);
        messegeForSuccess.setText("Filter cleared. Showing all tasks.");
    }

    // Getter for maintenance tasks (optional, for testing or other uses)
    public ObservableList<MaintenanceTask> getMaintenanceTasks() {
        return maintenanceTasks;
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
    }
}