package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.Ahad.UserTicketCounterStaff.TicketingConclude;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.time.LocalDate;

public class ConcludeTicketingController {
    @FXML private TextField totalTicketSoldTextField;
    @FXML private TextField totalRevenueTextField;
    @FXML private ComboBox<String> ticketTyprComboBox;
    @FXML private CheckBox confirmCheckBox;
    @FXML private DatePicker todaysDatePicker;
    @FXML private TextArea securityNotificationTextArea;
    @FXML private TextField statusTextField;
    @FXML private TextArea endOfDaysReportTextArea;
    @FXML private TextField staffNameTextField;
    @FXML private ComboBox<String> shiftComboBox;
    @FXML private TextArea dailySalesSummaryTextArea;

    private TicketingConclude ticketing;

    @FXML
    public void initialize() {
        ticketing = new TicketingConclude();

        // Initialize comboboxes
        shiftComboBox.getItems().addAll("Morning", "Afternoon", "Evening");
        ticketTyprComboBox.getItems().addAll("Standard", "VIP", "Student");

        // Set today's date
        LocalDate today = LocalDate.now();
        todaysDatePicker.setValue(today);

        statusTextField.setText("Ready");

        // Set initial text for daily sales summary
        dailySalesSummaryTextArea.setText("so far everything was good and the growth of sale is also great\n" +
                "hope tomorrow also the sales growth will be like today'.");
    }

    @FXML
    public void calculateDailyTotalsOnaction(ActionEvent actionEvent) {
        String staffName = staffNameTextField.getText();
        String shift = shiftComboBox.getValue();
        String ticketType = ticketTyprComboBox.getValue();

        if (staffName.isEmpty() || shift == null || ticketType == null) {
            statusTextField.setText("Fill all fields");
            return;
        }

        int tickets = 0;
        double revenue = 0.0;

        switch (ticketType) {
            case "Standard":
                tickets = 25;
                revenue = 625.00;
                break;
            case "VIP":
                tickets = 10;
                revenue = 500.00;
                break;
            case "Student":
                tickets = 12;
                revenue = 216.00;
                break;
        }

        ticketing.addSale(shift, ticketType, tickets, revenue);

        totalTicketSoldTextField.setText(String.valueOf(ticketing.getTicketsSold()));
        totalRevenueTextField.setText("$" + String.format("%.2f", ticketing.getTotalRevenue()));

        // Update the daily sales summary in the TextArea
        String summary = "DAILY SALES SUMMARY\n" +
                "===================\n\n" +
                "Total Tickets Sold: " + tickets + "\n" +
                "Total Revenue: $" + String.format("%.2f", revenue) + "\n" +
                "Shift: " + shift + "\n" +
                "Ticket Type: " + ticketType + "\n" +
                "Staff Name: " + staffName + "\n" +
                "Date: " + todaysDatePicker.getValue();

        dailySalesSummaryTextArea.setText(summary);
        statusTextField.setText("Totals calculated");
    }

    @FXML
    public void clickOnaction(ActionEvent actionEvent) {
        if (ticketing.getTicketsSold() == 0) {
            statusTextField.setText("Calculate totals first");
            return;
        }

        String report = "Tickets: " + ticketing.getTicketsSold() + "\n";
        report += "Revenue: $" + String.format("%.2f", ticketing.getTotalRevenue()) + "\n";
        report += "Counter closed.";

        endOfDaysReportTextArea.setText(report);
        statusTextField.setText("Report created");
    }

    @FXML
    public void notifySecurityOnaction(ActionEvent actionEvent) {
        if (ticketing.getTicketsSold() == 0) {
            statusTextField.setText("No data to notify");
            return;
        }

        // Auto-fill security notification
        String notify = "Ticket counter closed. ";
        notify += "Shift: " + ticketing.getShift() + ". ";
        notify += "Tickets sold: " + ticketing.getTicketsSold() + ". ";
        notify += "All secure.";

        securityNotificationTextArea.setText(notify);
        statusTextField.setText("Security notification ready");
    }

    @FXML
    public void finalReportOnaction(ActionEvent actionEvent) {
        if (!confirmCheckBox.isSelected()) {
            statusTextField.setText("Check confirm box first");
            return;
        }

        if (securityNotificationTextArea.getText().isEmpty()) {
            statusTextField.setText("Notify security first");
            return;
        }

        statusTextField.setText("Final report done. Shift complete.");
    }

    @FXML
    public void logOutOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/login.fxml", actionEvent);
    }
}