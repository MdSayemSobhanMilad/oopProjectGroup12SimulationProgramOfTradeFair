package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cse213.todayjava.Milad.UserMaintenanceStaff.RoutineInspection;

public class InspectionController {

    @FXML
    private DatePicker inspectionDateDatePicker;
    @FXML
    private ComboBox<String> statusComboBox;
    @FXML
    private TextField issueFoundTextField;
    @FXML
    private TextField inspectionIdTextField;
    @FXML
    private TextField inspectedByTextField;
    @FXML
    private TextField equiomentIdTextField;
    @FXML
    private Label successeErorLabel;
    @FXML
    private ListView<RoutineInspection> inspectionListView;

    List<RoutineInspection> inspectionList = new ArrayList<>();

    @FXML
    public void initialize() {
        statusComboBox.getItems().addAll("Pending", "In Progress", "Completed");
    }

    private boolean validateInputs() {
        if (inspectionIdTextField.getText().isEmpty() || equiomentIdTextField.getText().isEmpty() || inspectedByTextField.getText().isEmpty() || inspectionDateDatePicker.getValue() == null || statusComboBox.getValue() == null) {
            successeErorLabel.setText("All fields must be filled!");
            return false;
        }
        return true;
    }


    @FXML
    public void addDataOnClick(ActionEvent actionEvent) {

        if (!validateInputs()){
            return;
        }

        RoutineInspection n = new RoutineInspection(inspectionIdTextField.getText(), equiomentIdTextField.getText(), inspectedByTextField.getText(), inspectionDateDatePicker.getValue(), statusComboBox.getValue(), issueFoundTextField.getText()
        );

        inspectionList.add(n);

        inspectionListView.getItems().clear();
        inspectionListView.getItems().addAll(inspectionList);

        successeErorLabel.setText("Record added successfully!");
        clearform();
    }

    @FXML
    public void loadDataOnClick(ActionEvent actionEvent) {

        inspectionListView.getItems().clear();
        inspectionListView.getItems().addAll(inspectionList);

        successeErorLabel.setText("Data loaded successfully!");
    }


    @FXML
    public void updateOnClick(ActionEvent actionEvent) {

        if (!validateInputs()){
            return;
        }

        RoutineInspection select = inspectionListView.getSelectionModel().getSelectedItem();

        if (select == null) {
            successeErorLabel.setText("Please Select an Object");
            return;
        }

        select.setInspectedBy(inspectedByTextField.getText());
        select.setInspectionDate(inspectionDateDatePicker.getValue());
        select.setInspectionId(inspectionIdTextField.getText());
        select.setStatus(statusComboBox.getValue());
        select.setEquipmentId(equiomentIdTextField.getText());
        select.setIssuesFound(issueFoundTextField.getText());


        inspectionListView.refresh();


        successeErorLabel.setText("updated successfully!");
        clearform();
    }


    @FXML
    public void deleteOnClick(ActionEvent actionEvent) {

        RoutineInspection select = inspectionListView.getSelectionModel().getSelectedItem();

        if (select == null) {
            successeErorLabel.setText("Please Select an Object");
            return;
        }

        inspectionList.remove(select);

        inspectionListView.getItems().clear();
        inspectionListView.getItems().addAll(inspectionList);
        clearform();
    }

    @FXML
    public void doneInspectionOnClick(ActionEvent actionEvent) {
        List<RoutineInspection> temp = new ArrayList<>();

        for (RoutineInspection ri : inspectionList) {
            if (ri.getStatus().equals("Completed")) {
                temp.add(ri);
            }
        }

        inspectionListView.getItems().clear();
        inspectionListView.getItems().addAll(temp);

        successeErorLabel.setText("Completed Tasks are showing!");

        clearform();
    }

    private void clearform(){
        equiomentIdTextField.clear();
        inspectedByTextField.clear();
        inspectionIdTextField.clear();
        issueFoundTextField.clear();
        statusComboBox.setValue(null);
        inspectionListView.getSelectionModel().clearSelection();
    }

    @FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
    }
}
