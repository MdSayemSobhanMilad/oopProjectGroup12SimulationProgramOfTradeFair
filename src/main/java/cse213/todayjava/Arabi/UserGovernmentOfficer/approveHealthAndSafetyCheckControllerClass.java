package cse213.todayjava.Arabi.UserGovernmentOfficer;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class approveHealthAndSafetyCheckControllerClass {

    @FXML
    private TextField reportIdTextField;

    @FXML
    private TextArea safetyStatusTextArea;

    @FXML
    private TableView<HealthAndSafetyCheck> approveHealthAndSafetyCheckTableView;

    @FXML
    private TableColumn<HealthAndSafetyCheck, String> reportIdTableColumn;

    @FXML
    private TableColumn<HealthAndSafetyCheck, String> safetyStatusTableColumn;

    @FXML
    public void initialize() {
        // টেবিলের কলাম সেট করা
        reportIdTableColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getReportId()));
        safetyStatusTableColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getSafetyStatus()));
    }

    @FXML
    private void submitOnClick() {
        // সব ফিল্ড চেক করা
        String reportId = reportIdTextField.getText();
        String safetyStatus = safetyStatusTextArea.getText();

        // দুটি ফিল্ডই ভরা থাকতে হবে
        if (reportId.isEmpty() || safetyStatus.isEmpty()) {
            return;
        }

        // নতুন ডেটা তৈরি
        HealthAndSafetyCheck newCheck = new HealthAndSafetyCheck(reportId, safetyStatus);

        // টেবিলে যোগ করা
        approveHealthAndSafetyCheckTableView.getItems().add(newCheck);

        // ফিল্ড খালি করা
        reportIdTextField.clear();
        safetyStatusTextArea.clear();
    }

    @FXML
    private void backOnClick() {
        // Back button এর কাজ
        System.out.println("Back button clicked");
    }
}