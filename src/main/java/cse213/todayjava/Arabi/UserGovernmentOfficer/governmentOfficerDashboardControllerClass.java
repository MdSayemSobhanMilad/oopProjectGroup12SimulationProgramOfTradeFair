package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class governmentOfficerDashboardControllerClass
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void inspectExhibitorLicensesOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/inspectExhibitorLicenses.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logOutOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/login.fxml", actionEvent);


    }

    @javafx.fxml.FXML
    public void approveHealthAndSafetyChecksOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/approveHealthAndSafetyCheck.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void generateComplianceReportsOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/generateComplianceReport.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void monitorTaxCollectionOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/monitorTaxCollection.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void monitorPolicyComplianceOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/monitorPolicyCompliance.fxml", actionEvent);



    }


    @javafx.fxml.FXML
    public void handleExhibitorComplaintsOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/handleExhibitorComplaint.fxml", actionEvent);

    }



    @javafx.fxml.FXML
    public void verifyProductComplianceOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/verifyProductCompliance.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void ensureFoodSafetyOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/ensureFoodSafety.fxml", actionEvent);
    }
}