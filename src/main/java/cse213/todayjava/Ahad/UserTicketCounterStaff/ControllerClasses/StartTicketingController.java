package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;



import cse213.todayjava.SceneSwitcher;
import cse213.todayjava.Ahad.UserTicketCounterStaff.TicketingStart;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.io.IOException;

public class StartTicketingController {

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

    private TicketingStart system;

    @javafx.fxml.FXML
    public void initialize() {
        system = new TicketingStart();

        loginTextField.setText(system.getLoginStatus());
        databaseTextField.setText(system.getDatabaseStatus());
        dailySetupTextField.setText(system.getDailySetupStatus());
        counterOpenTextField.setText(system.getCounterStatus());
        ticketTextField.setText(system.getFirstTicket());
    }

    @javafx.fxml.FXML
    public void salesOnaction(ActionEvent actionEvent) throws IOException {
        system.startSystem();

        loginTextField.setText(system.getLoginStatus());
        databaseTextField.setText(system.getDatabaseStatus());
        dailySetupTextField.setText(system.getDailySetupStatus());
        counterOpenTextField.setText(system.getCounterStatus());
        ticketTextField.setText(system.getFirstTicket());
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}