package cse213.todayjava.Arabi.UserGovernmentOfficer;

import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class generateComplianceReportControllerClass {

    @FXML
    private TextField reportTypeTextField;

    @FXML
    private TextField dateRangeTextField;

    @FXML
    private TextArea reportDetailsTextArea;

    @FXML
    private TableView<ReportRecord> generateComplianceReportsTableView;

    @FXML
    private TableColumn<ReportRecord, String> reportTypeTableColumn;

    @FXML
    private TableColumn<ReportRecord, String> dateRangeTableColumn;

    @FXML
    private TableColumn<ReportRecord, String> reportDetailsTableColumn;

    @FXML
    private Label statusLabel;

    private ObservableList<ReportRecord> reportList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        System.out.println("Controller start");


        reportTypeTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getReportType()));

        dateRangeTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getDateRange()));

        reportDetailsTableColumn.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getReportDetails()));

        generateComplianceReportsTableView.setItems(reportList);
        statusLabel.setText("");
    }

    @FXML
    private void generatePdfOnClick() {
        System.out.println("PDF button click!");

        String reportType = reportTypeTextField.getText();
        String dateRange = dateRangeTextField.getText();
        String reportDetails = reportDetailsTextArea.getText();

        if (reportType.isEmpty() || dateRange.isEmpty() || reportDetails.isEmpty()) {
            statusLabel.setText("failed");
            System.out.println("Field empty");
            return;
        }

        // নতুন রিপোর্ট তৈরি
        ReportRecord newReport = new ReportRecord(reportType, dateRange, reportDetails);
        reportList.add(newReport);

        // PDF তৈরি করার চেষ্টা
        boolean pdfCreated = createPDFFile(newReport);

        if (pdfCreated) {
            // PDF তৈরি হলে successful দেখাবে
            statusLabel.setText("successful");
            System.out.println("PDF finish");

            // ফিল্ড clear
            reportTypeTextField.clear();
            dateRangeTextField.clear();
            reportDetailsTextArea.clear();
        } else {
            // PDF তৈরি না হলে failed দেখাবে
            statusLabel.setText("failed");
            System.out.println("PDF fail");
        }
    }

    @FXML
    private void clearOnClick() {
        System.out.println("Clear button click!");

        reportList.clear();
        statusLabel.setText("");

        reportTypeTextField.clear();
        dateRangeTextField.clear();
        reportDetailsTextArea.clear();

        System.out.println("clear data!");
    }

    @javafx.fxml.FXML
    public void backOnClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Arabi/UserGovernmentOfficer/governmentOfficerDashboard.fxml", actionEvent);
    }

    private boolean createPDFFile(ReportRecord report) {
        try {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Report");
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("PDF Files", "*.pdf")
            );


            String fileName = "Compliance_Report_" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".pdf";
            fileChooser.setInitialFileName(fileName);

            File file = fileChooser.showSaveDialog(null);

            if (file == null) {

                return false;
            }


            createTextFile(file, report);

            System.out.println("File save: " + file.getAbsolutePath());
            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    private void createTextFile(File file, ReportRecord report) throws IOException {
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        try {

            bufferedWriter.write("=== COMPLIANCE REPORT ===");
            bufferedWriter.newLine();
            bufferedWriter.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            bufferedWriter.newLine();
            bufferedWriter.write("========================");
            bufferedWriter.newLine();


            bufferedWriter.write("Report Type: " + report.getReportType());
            bufferedWriter.newLine();
            bufferedWriter.write("Date Range: " + report.getDateRange());
            bufferedWriter.newLine();
            bufferedWriter.write("Details: " + report.getReportDetails());
            bufferedWriter.newLine();
            bufferedWriter.write("========================");
            bufferedWriter.newLine();


            if (!reportList.isEmpty()) {
                bufferedWriter.newLine();
                bufferedWriter.write("=== ALL REPORTS ===");
                bufferedWriter.newLine();
                bufferedWriter.write("========================");
                bufferedWriter.newLine();

                for (int i = 0; i < reportList.size(); i++) {
                    ReportRecord r = reportList.get(i);
                    bufferedWriter.write((i + 1) + ". " + r.getReportType() + " | " + r.getDateRange());
                    bufferedWriter.newLine();
                }
            }

        } finally {
            bufferedWriter.close();
            writer.close();
        }
    }
}