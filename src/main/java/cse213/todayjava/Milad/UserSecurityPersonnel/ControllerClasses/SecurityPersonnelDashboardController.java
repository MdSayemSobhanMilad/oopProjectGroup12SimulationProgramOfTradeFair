package cse213.todayjava.Milad.UserSecurityPersonnel.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class SecurityPersonnelDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logoutOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/login.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void manageSecurityOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/watchlist.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void respondIncidentOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/respondIncident.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void reportMaintenanceIssueOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/reportmaintenanceIssue.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void patrolOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/patrol.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void exportIncidentOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/salaryPDF.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void verifyMediaOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/verifyMediaPromoter.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void validOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/validateAttandee.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logShiftOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserSecurityPersonnel/logComplete.fxml", actionEvent);
    }
}