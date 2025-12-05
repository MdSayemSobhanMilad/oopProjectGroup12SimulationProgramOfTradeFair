package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.SceneSwitcher;
import cse213.todayjava.Ahad.UserTicketCounterStaff.TicketProvider;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.IOException;

public class ProvideTicketController {

    @javafx.fxml.FXML
    private TextField statusTextField;
    @javafx.fxml.FXML
    private TextArea ticketDetailsTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> passTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> getTicketComboBox;
    @javafx.fxml.FXML
    private TextField ticketCodeTextField;
    @javafx.fxml.FXML
    private TextField visitorNameTextField;

    private TicketProvider currentTicket;
    private int ticketCounter = 1;

    @javafx.fxml.FXML
    public void initialize() {
        passTypeComboBox.getItems().addAll("Single Day", "Multi-Day", "VIP", "Exhibitor");
        getTicketComboBox.getItems().addAll("Print Ticket", "Email Ticket", "SMS Ticket");

        statusTextField.setText("Ready");
    }

    @javafx.fxml.FXML
    public void creatTicketOnaction(ActionEvent actionEvent) {
        String visitorName = visitorNameTextField.getText();
        String passType = passTypeComboBox.getValue();
        String deliveryMethod = getTicketComboBox.getValue();

        if (visitorName.isEmpty() || passType == null || deliveryMethod == null) {
            return;
        }

        String ticketCode = "FAIR-" + String.format("%03d", ticketCounter);
        ticketCounter++;

        currentTicket = new TicketProvider(ticketCode, visitorName);
        currentTicket.setPassType(passType);
        currentTicket.setDeliveryMethod(deliveryMethod);
        currentTicket.setStatus("Created");

        ticketCodeTextField.setText(ticketCode);
        statusTextField.setText("Ticket Created");

        String details = currentTicket.getTicketDetails();
        ticketDetailsTextArea.setText(details);
    }

    @javafx.fxml.FXML
    public void giveVisitorOnaction(ActionEvent actionEvent) {
        if (currentTicket == null) {
            return;
        }

        currentTicket.setStatus("Issued to Visitor");
        statusTextField.setText("Ticket Issued");

        String details = currentTicket.getTicketDetails();
        ticketDetailsTextArea.setText(details);

        visitorNameTextField.clear();
        passTypeComboBox.setValue(null);
        getTicketComboBox.setValue(null);
        ticketCodeTextField.clear();

        currentTicket = null;
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}