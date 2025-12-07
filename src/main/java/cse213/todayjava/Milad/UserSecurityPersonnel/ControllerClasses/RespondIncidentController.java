package cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;

import cse213.todayjava.Milad.UserSecurityPersonnel.IncidentReport;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RespondIncidentController {

    @FXML
    private TableColumn<IncidentReport, LocalDate> generateDateTC;

    @FXML
    private TableColumn<IncidentReport, String> statusTC;

    @FXML
    private TableColumn<IncidentReport, String> reportTypeTC;

    @FXML
    private TableView<IncidentReport> repairTV;

    @FXML
    private TableColumn<IncidentReport, String> generateByTC;

    @FXML
    private TableColumn<IncidentReport, String> repairIDTC;

    List<IncidentReport> itemList = new ArrayList<>();

    @FXML
    public void initialize() {
        System.out.println("Initialize called - Setting up table...");

        repairIDTC.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportTypeTC.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        generateDateTC.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        generateByTC.setCellValueFactory(new PropertyValueFactory<>("generatedBy"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        itemList.add(new IncidentReport("MR001", "Thief Alert", LocalDate.of(2025, 1, 10), "Event Manager", "Not inspected"));
        itemList.add(new IncidentReport("MR002", "Crowd Overload Problem", LocalDate.of(2025, 1, 11), "Vendor", "Not inspected"));
        itemList.add(new IncidentReport("MR003", "Media Promoter Security need", LocalDate.of(2025, 1, 12), "Trade Fair Organizer", "Not inspected"));
        itemList.add(new IncidentReport("MR004", "Unauthorized Access Attempt", LocalDate.of(2025, 1, 13), "Event Manager", "Not inspected"));
        itemList.add(new IncidentReport("MR005", "Suspicious Activity Observed", LocalDate.of(2025, 1, 14), "Event Manager", "Not inspected"));
        itemList.add(new IncidentReport("MR006", "Security Breach Detected", LocalDate.of(2025, 1, 15), "Vendor", "Not inspected"));
        itemList.add(new IncidentReport("MR007", "Failed Security Equipment", LocalDate.of(2025, 1, 16), "Maintenance Supervisor", "Not inspected"));
        itemList.add(new IncidentReport("MR008", "Prohibited Item Found", LocalDate.of(2025, 1, 17), "Marketing Staff", "Not inspected"));
        itemList.add(new IncidentReport("MR009", "Security Camera Offline", LocalDate.of(2025, 1, 18), "Vendor", "Not inspected"));
        itemList.add(new IncidentReport("MR010", "Fire Alarm Triggered", LocalDate.of(2025, 1, 19), "Technical Operator", "Not inspected"));

        repairTV.getItems().addAll(itemList);
    }


    @FXML
    public void doneRepairingRB(ActionEvent actionEvent) {
        IncidentReport selected = repairTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection",
                    "Please select a task from the list to mark as done.");
            return;
        }

        selected.setStatus("Done Repairing");
        repairTV.refresh();
    }

    @FXML
    public void loadDoneWorksClick(ActionEvent actionEvent) {
        List<IncidentReport> filteredList = new ArrayList<>();

        for (IncidentReport report : itemList) {
            if ("Done Repairing".equals(report.getStatus())) {
                filteredList.add(report);
            }
        }

        if (filteredList.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "No Repair",
                    "No unrepaired items found.");
            return;
        }

        repairTV.getItems().clear();
        repairTV.getItems().addAll(filteredList);

    }

    @FXML
    public void backClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/ControllerClasses/SecurityPersonnelDashboardController.java", actionEvent);
    }

    @FXML
    public void ReloadClick(ActionEvent actionEvent) {
        repairTV.getItems().clear();
        repairTV.getItems().addAll(itemList);

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}