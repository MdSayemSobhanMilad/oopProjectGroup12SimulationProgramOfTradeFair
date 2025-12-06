package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

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

        reportIdTableColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getReportId()));
        safetyStatusTableColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getSafetyStatus()));
    }

    @FXML
    private void submitOnClick() {

        String reportId = reportIdTextField.getText();
        String safetyStatus = safetyStatusTextArea.getText();


        if (reportId.isEmpty() || safetyStatus.isEmpty()) {
            return;
        }


        HealthAndSafetyCheck newCheck = new HealthAndSafetyCheck(reportId, safetyStatus);


        approveHealthAndSafetyCheckTableView.getItems().add(newCheck);


        reportIdTextField.clear();
        safetyStatusTextArea.clear();
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }
}

