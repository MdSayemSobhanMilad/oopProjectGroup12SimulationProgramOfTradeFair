package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ProcessSalesController
{
    @javafx.fxml.FXML
    private ComboBox ticketTypeComboBox;
    @javafx.fxml.FXML
    private TextArea confirmCustomerTextArea;
    @javafx.fxml.FXML
    private TextArea priceEachTextArea;
    @javafx.fxml.FXML
    private TextArea confirmPaymentTextArea;
    @javafx.fxml.FXML
    private TextArea ticketDetailsTextArea;
    @javafx.fxml.FXML
    private TextField quantityTextField;
    @javafx.fxml.FXML
    private TextField totalTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void proceedPaymentOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmCustomerOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clickOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}