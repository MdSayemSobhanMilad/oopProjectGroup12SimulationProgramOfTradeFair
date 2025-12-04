package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.MaintenanceReport;
import cse213.todayjava.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class RepairController {

    @FXML
    private TableColumn<MaintenanceReport, LocalDate> generateDateTC;

    @FXML
    private TableColumn<MaintenanceReport, String> statusTC;

    @FXML
    private TableColumn<MaintenanceReport, String> reportTypeTC;

    @FXML
    private TableView<MaintenanceReport> repairTV;

    @FXML
    private TableColumn<MaintenanceReport, String> generateByTC;

    @FXML
    private TableColumn<MaintenanceReport, String> repairIDTC;

    private ObservableList<MaintenanceReport> itemList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Initialize called - Setting up table...");

        // Setup table columns
        repairIDTC.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportTypeTC.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        generateDateTC.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        generateByTC.setCellValueFactory(new PropertyValueFactory<>("generatedBy"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load initial data
        loadInitialData();

        // Set the items to TableView
        repairTV.setItems(itemList);

        System.out.println("Table setup complete. Items in table: " + repairTV.getItems().size());
    }

    private void loadInitialData() {
        itemList.clear();

        itemList.add(new MaintenanceReport("MR001", "Electrical Fault", LocalDate.of(2025, 1, 10), "Security Personnel", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR002", "Broken Stall Light", LocalDate.of(2025, 1, 11), "Vendor", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR003", "Water Leakage", LocalDate.of(2025, 1, 12), "Trade Fair Organizer", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR004", "Damaged Gate Lock", LocalDate.of(2025, 1, 13), "Security Personnel", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR005", "Sound System Issue", LocalDate.of(2025, 1, 14), "Event Manager", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR006", "Floor Damage", LocalDate.of(2025, 1, 15), "Vendor", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR007", "Air Cooling Failure", LocalDate.of(2025, 1, 16), "Maintenance Supervisor", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR008", "Broken Banner Stand", LocalDate.of(2025, 1, 17), "Marketing Staff", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR009", "CCTV Malfunction", LocalDate.of(2025, 1, 18), "Security Personnel", "Not Repaired"));
        itemList.add(new MaintenanceReport("MR010", "Generator Problem", LocalDate.of(2025, 1, 19), "Technical Operator", "Not Repaired"));

        System.out.println("Loaded " + itemList.size() + " items into the list");
    }

    @FXML
    public void doneRepairingRB(ActionEvent actionEvent) {
        MaintenanceReport selected = repairTV.getSelectionModel().getSelectedItem();

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
        ObservableList<MaintenanceReport> filteredList = FXCollections.observableArrayList();

        for (MaintenanceReport report : itemList) {
            if ("Done Repairing".equals(report.getStatus())) {
                filteredList.add(report);
            }
        }

        if (filteredList.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "No Repair",
                    "No unrepaired items found.");
            return;
        }

        repairTV.setItems(filteredList);

    }

    @FXML
    public void backClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
    }

    @FXML
    public void ReloadClick(ActionEvent actionEvent) {
        repairTV.setItems(itemList);

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}