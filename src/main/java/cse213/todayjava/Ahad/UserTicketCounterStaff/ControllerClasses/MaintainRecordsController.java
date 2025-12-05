package cse213.todayjava.Ahad.UserTicketCounterStaff.ControllerClasses;

import cse213.todayjava.Ahad.UserTicketCounterStaff.RecordsMaintain;
import cse213.todayjava.SceneSwitcher;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.IOException;

public class MaintainRecordsController {
    @javafx.fxml.FXML private TableColumn<SaleRecord, String> dateTableView;
    @javafx.fxml.FXML private TableColumn<SaleRecord, String> ticketTypeTableView;
    @javafx.fxml.FXML private TextArea reportTextArea;
    @javafx.fxml.FXML private TableView<SaleRecord> tableView;
    @javafx.fxml.FXML private ComboBox<String> shiftComboBox;
    @javafx.fxml.FXML private TextField totalsalesTextField;
    @javafx.fxml.FXML private DatePicker selectDatePicker;
    @javafx.fxml.FXML private ComboBox<String> reportFormatComboBox;
    @javafx.fxml.FXML private TableColumn<SaleRecord, Double> totalTableView;
    @javafx.fxml.FXML private TextArea statusTextArea;
    @javafx.fxml.FXML private TableColumn<SaleRecord, String> shiftTableView;
    @javafx.fxml.FXML private TableColumn<SaleRecord, Integer> quantityTableView;
    @javafx.fxml.FXML private TableColumn<SaleRecord, Double> priceTableView;
    @javafx.fxml.FXML private TableColumn<SaleRecord, Double> priceTableView1;
    @javafx.fxml.FXML private ComboBox<String> ticketTypeComboBox;
    @javafx.fxml.FXML private TextField quantityTextField;
    @javafx.fxml.FXML private TextField priceTextField;

    private RecordsMaintain records;

    // Inner class for TableView data
    public class SaleRecord {
        private SimpleStringProperty ticketType;
        private SimpleIntegerProperty quantity;
        private SimpleDoubleProperty price;
        private SimpleDoubleProperty total;
        private SimpleStringProperty date;
        private SimpleStringProperty shift;

        public SaleRecord(String ticketType, int quantity, double price, String date, String shift) {
            this.ticketType = new SimpleStringProperty(ticketType);
            this.quantity = new SimpleIntegerProperty(quantity);
            this.price = new SimpleDoubleProperty(price);
            this.total = new SimpleDoubleProperty(quantity * price);
            this.date = new SimpleStringProperty(date);
            this.shift = new SimpleStringProperty(shift);
        }

        // Getters
        public String getTicketType() { return ticketType.get(); }
        public int getQuantity() { return quantity.get(); }
        public double getPrice() { return price.get(); }
        public double getTotal() { return total.get(); }
        public String getDate() { return date.get(); }
        public String getShift() { return shift.get(); }

        // Property getters for TableView
        public SimpleStringProperty ticketTypeProperty() { return ticketType; }
        public SimpleIntegerProperty quantityProperty() { return quantity; }
        public SimpleDoubleProperty priceProperty() { return price; }
        public SimpleDoubleProperty totalProperty() { return total; }
        public SimpleStringProperty dateProperty() { return date; }
        public SimpleStringProperty shiftProperty() { return shift; }
    }

    @javafx.fxml.FXML
    public void initialize() {
        records = new RecordsMaintain();

        shiftComboBox.getItems().addAll("Morning", "Afternoon", "Evening");
        reportFormatComboBox.getItems().addAll("PDF", "CSV");
        ticketTypeComboBox.getItems().addAll("Standard", "VIP", "Student", "Senior", "Child");

        statusTextArea.setText("Ready");
        priceTextField.setEditable(false);

        // Setup TableView columns
        ticketTypeTableView.setCellValueFactory(cellData -> cellData.getValue().ticketTypeProperty());
        quantityTableView.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        priceTableView.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        totalTableView.setCellValueFactory(cellData -> cellData.getValue().totalProperty().asObject());
        dateTableView.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        shiftTableView.setCellValueFactory(cellData -> cellData.getValue().shiftProperty());

        // Auto-set price when ticket type selected
        ticketTypeComboBox.setOnAction(event -> {
            String type = ticketTypeComboBox.getValue();
            if (type != null) {
                priceTextField.setText(getPrice(type));
            }
        });
    }

    private String getPrice(String type) {
        switch (type) {
            case "VIP": return "50.00";
            case "Student": return "18.00";
            case "Senior": return "20.00";
            case "Child": return "12.00";
            default: return "25.00";
        }
    }

    @javafx.fxml.FXML
    public void loadTableViewOnaction(ActionEvent actionEvent) {
        String ticketType = ticketTypeComboBox.getValue();
        String qtyText = quantityTextField.getText();
        String priceText = priceTextField.getText();
        String shift = shiftComboBox.getValue();

        if (ticketType == null || qtyText.isEmpty() || shift == null) {
            statusTextArea.setText("Fill all fields first");
            return;
        }

        try {
            int quantity = Integer.parseInt(qtyText);
            double price = Double.parseDouble(priceText);
            String date = selectDatePicker.getValue() != null ?
                    selectDatePicker.getValue().toString() : "2024-12-01";

            // Create SaleRecord object
            SaleRecord sale = new SaleRecord(ticketType, quantity, price, date, shift);

            // Add to TableView
            tableView.getItems().add(sale);

            // Update model
            records.addSale(ticketType, quantity, price);

            statusTextArea.setText("Added to table");

            // Clear input fields for next entry
            quantityTextField.clear();
            ticketTypeComboBox.setValue(null);
            priceTextField.clear();

        } catch (NumberFormatException e) {
            statusTextArea.setText("Enter valid numbers");
        }
    }

    @javafx.fxml.FXML
    public void loadSummaryOnaction(ActionEvent actionEvent) {
        if (tableView.getItems().isEmpty()) {
            statusTextArea.setText("Add data to table first");
            return;
        }

        totalsalesTextField.setText("$" + String.format("%.2f", records.getTotalSales()));
        reportTextArea.setText(records.getSummary());
        statusTextArea.setText("Summary loaded");
    }

    @javafx.fxml.FXML
    public void generateReportOnaction(ActionEvent actionEvent) {
        String format = reportFormatComboBox.getValue();
        if (format == null) {
            statusTextArea.setText("Select format first");
            return;
        }

        if (tableView.getItems().isEmpty()) {
            statusTextArea.setText("No data to report");
            return;
        }

        statusTextArea.setText(format + " report generated");
    }

    @javafx.fxml.FXML
    public void reportToFinanceOnaction(ActionEvent actionEvent) {
        if (tableView.getItems().isEmpty()) {
            statusTextArea.setText("No report to send");
            return;
        }

        statusTextArea.setText("Report sent to Finance");
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Ahad/UserTicketCounterStaff/ticketCounterStaffDashboard.fxml", actionEvent);
    }
}