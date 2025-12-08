package cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;

import cse213.todayjava.Milad.UserSecurityPersonnel.TaskLog;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LogCompleteController
{
    @javafx.fxml.FXML
    private ToggleGroup presentStatus;
    @javafx.fxml.FXML
    private TextField logidTextField;
    @javafx.fxml.FXML
    private RadioButton absentRadioButton;
    @javafx.fxml.FXML
    private TextField stuffIDtextField;
    @javafx.fxml.FXML
    private Label successErrorLabel;
    @javafx.fxml.FXML
    private TableView<TaskLog> shiftTableView;
    @javafx.fxml.FXML
    private TableColumn<TaskLog, String> logIdColoumn;
    @javafx.fxml.FXML
    private TextField summeryTextField;
    @javafx.fxml.FXML
    private TableColumn<TaskLog, String> presentStatusColoumn;
    @javafx.fxml.FXML
    private TableColumn<TaskLog, LocalDate> dateColoumn;
    @javafx.fxml.FXML
    private RadioButton presentRadioButtorn;

    List<TaskLog> tasks = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        dateColoumn.setCellValueFactory(new PropertyValueFactory<>("todayDate"));
        logIdColoumn.setCellValueFactory(new PropertyValueFactory<>("logId"));
        presentStatusColoumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TaskLog log1 = new TaskLog("L001", "STF101", LocalDate.of(2025, 12, 1), "Checked all equipment in Zone A", "Present");
        TaskLog log2 = new TaskLog("L002", "STF102", LocalDate.of(2025, 12, 2),  "Reviewed security requests", "Absent");
        TaskLog log3 = new TaskLog("L003", "STF103", LocalDate.of(2025, 12, 3),  "Completed routine inspection for HVAC", "Present");
        TaskLog log4 = new TaskLog("L004", "STF104", LocalDate.of(2025, 12, 4),  "Updated previous irregular security issues", "Present");
        TaskLog log5 = new TaskLog("L005", "STF105", LocalDate.of(2025, 12, 5),  "Filed thief detection report", "Absent");

        tasks.add(log1);
        tasks.add(log2);
        tasks.add(log3);
        tasks.add(log4);
        tasks.add(log5);

        shiftTableView.getItems().addAll(tasks);
    }

    @javafx.fxml.FXML
    public void addPresentOnClick(ActionEvent actionEvent) {

        if (!validateInputs()) {
            return;
        }

        for (TaskLog i: tasks){
            if (i.getTodayDate().equals(LocalDate.now())){
                successErrorLabel.setText("Already Attendance is recorded for Today");
                return;
            }
        }

        RadioButton selectedRadio = (RadioButton) presentStatus.getSelectedToggle();
        String status = selectedRadio.getText();

        TaskLog log = new TaskLog(
                logidTextField.getText(),
                stuffIDtextField.getText(),
                LocalDate.now(),
                summeryTextField.getText(),
                status
        );

        tasks.add(log);

        shiftTableView.getItems().clear();
        shiftTableView.getItems().addAll(tasks);

        successErrorLabel.setText("Log added successfully!");
    }

    private boolean validateInputs() {
        successErrorLabel.setText("");

        StringBuilder error = new StringBuilder();

        if (logidTextField.getText().trim().isEmpty()) {
            error.append("Log ID cannot be empty! \n");
        }

        if (stuffIDtextField.getText().trim().isEmpty()) {
            error.append("Staff ID cannot be empty! \n");
        }

        if (summeryTextField.getText().trim().isEmpty()) {
            error.append("Summary cannot be empty! \n");
        }

        if (presentStatus.getSelectedToggle() == null) {
            error.append("Please select Present or Absent!");
        }

        if (!error.isEmpty()){
            successErrorLabel.setText(error.toString());
            return false;
        }
        else{
            return true;
        }
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/securityPersonnelDashboard.fxml", actionEvent);
    }
}