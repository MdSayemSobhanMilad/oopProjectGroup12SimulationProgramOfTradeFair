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

    @Deprecated
    public void processTicketSalesOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/process-sales.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void finalizeTransactionsOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/finalize-transactions.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void provideTicketsOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/provide-ticket.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void processSalesOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/process-sales.fxml", actionEvent);

    }

    @javafx.fxml.FXML
    public void visitorRegulationsOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/inform-regulations.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void cashFlowManagementOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/manage-cashflow.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void salesRecordOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/maintain-records.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void ConcludeOperationOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/conclude-ticketing.fxml", actionEvent);

    }
}