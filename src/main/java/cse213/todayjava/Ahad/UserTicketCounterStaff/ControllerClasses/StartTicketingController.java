package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StartTicketingController
{
    @javafx.fxml.FXML
    private TextField counterOpenTextField;
    @javafx.fxml.FXML
    private TextField ticketTextField;
    @javafx.fxml.FXML
    private TextField databaseTextField;
    @javafx.fxml.FXML
    private TextField dailySetupTextField;
    @javafx.fxml.FXML
    private TextField loginTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void salesOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}