package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ticketCounterStaffDashboard
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logOutOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/login.fxml", actionEvent);



    }

    @javafx.fxml.FXML
    public void ticketingOperationsOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/start-ticketing.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void processTicketSalesOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/process-sales.fxml", actionEvent);

    }
}