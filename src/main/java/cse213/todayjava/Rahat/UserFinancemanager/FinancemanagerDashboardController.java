package cse213.todayjava.Rahat.UserFinancemanager;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import java.io.IOException;

public class FinancemanagerDashboardController {

    @FXML
    void annualdataButton(ActionEvent event) {

    }

    @FXML
    void forecastfuturecostButton(ActionEvent event) {

    }

    @FXML
    void generatefinancialreportButton(ActionEvent event) throws IOException{
        SceneSwitcher.switchTo("/cse213/todayjava/Rahat/UserFinancemanager/generatefinancialreport.fxml", event);
    }

    @FXML
    void managepaymentButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Rahat/UserFinancemanager/monitorbudget.fxml", event);
    }

    @FXML
    void managesalaryButton(ActionEvent event){

    }

    @FXML
    void monitorbudgetButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Rahat/UserFinancemanager/FinancemanagerDashboard.fxml", event);
    }

    @FXML
    void revenuerecordButton(ActionEvent event) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Rahat/UserFinancemanager/revenuerecord.fxml", event);
    }

    @FXML
    void trackvendorcontractButton(ActionEvent event) {

    }

}
