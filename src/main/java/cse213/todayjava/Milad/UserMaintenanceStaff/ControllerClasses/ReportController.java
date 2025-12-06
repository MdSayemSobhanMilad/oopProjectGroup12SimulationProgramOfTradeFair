package cse213.todayjava.Milad.UserMaintenanceStaff.ControllerClasses;

import cse213.todayjava.Milad.UserMaintenanceStaff.ReportParameters;
import cse213.todayjava.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.stage.FileChooser;
//
//import org.openpdf.text.Document;
//import org.openpdf.text.DocumentException;
//import org.openpdf.text.Paragraph;
//import org.openpdf.text.pdf.PdfWriter;
//import org.openpdf.text.pdf.PdfPTable;
//
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.time.LocalDate;
//import java.io.File;
//
//
//import java.io.File;
//import java.io.IOException;

public class ReportController
{
    @javafx.fxml.FXML
    private Label errorSuccessLabel;
    @javafx.fxml.FXML
    private DatePicker endMonthDatePicker;
    @javafx.fxml.FXML
    private DatePicker startMonthDatePicker;
    @javafx.fxml.FXML
    private TextField absenceTextField;
    @javafx.fxml.FXML
    private TextArea salaryTA;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backClick(ActionEvent actionEvent) throws IOException {
        SceneSwitcher.switchTo("/cse213/todayjava/Milad/UserMaintenanceStaff/maintenanceDashboard.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void salaryOnClick(ActionEvent actionEvent) {
        if (!validateInput()){
            return;
        }

        ReportParameters a = new ReportParameters(startMonthDatePicker.getValue(), endMonthDatePicker.getValue(), Integer.parseInt(absenceTextField.getText()));

        salaryTA.setText("The Salary of the month is: "+ a.getSalary() + "BDT");

        endMonthDatePicker.setValue(null);
        startMonthDatePicker.setValue(null);
        absenceTextField.setText("");

    }

    @javafx.fxml.FXML
    public void pdfOnClick(ActionEvent actionEvent) {
//        // First validate the input
//        if (!validateInput()) {
//            return;
//        }
//
//
//        ReportParameters report = new ReportParameters(
//                startMonthDatePicker.getValue(),
//                endMonthDatePicker.getValue(),
//                Integer.parseInt(absenceTextField.getText())
//        );
//
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("PDF Document", "*.pdf")
//        );
//
//        String defaultFileName = "Maintenance_Report_" +
//                startMonthDatePicker.getValue().getMonth().toString() + "_" +
//                startMonthDatePicker.getValue().getYear() + ".pdf";
//        fileChooser.setInitialFileName(defaultFileName);
//
//        File chosenFile = fileChooser.showSaveDialog(salaryTA.getScene().getWindow());
//        if (chosenFile == null) return;
//
//        try {
//            // Create PDF document
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(chosenFile));
//
//            document.open();
//
//            // Add title
//            document.add(new Paragraph("Maintenance Staff Monthly Report"));
//            document.add(new Paragraph(" "));
//
//            // Add generation date
//            document.add(new Paragraph("Report Generated: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
//            document.add(new Paragraph(" "));
//
//            // Add report period
//            document.add(new Paragraph("Report Period:"));
//            document.add(new Paragraph("Start Date: " + startMonthDatePicker.getValue()));
//            document.add(new Paragraph("End Date: " + endMonthDatePicker.getValue()));
//            document.add(new Paragraph(" "));
//
//            // Add absence information
//            document.add(new Paragraph("Absence Days: " + absenceTextField.getText()));
//            document.add(new Paragraph(" "));
//
//            // Add salary information
//            document.add(new Paragraph("Salary Calculation:"));
//            document.add(new Paragraph("Total Salary: " + report.getSalary()));
//            document.add(new Paragraph(" "));
//
//            // Add a summary table
//            PdfPTable table = new PdfPTable(2);
//            table.setWidthPercentage(100);
//
//            table.addCell("Parameter");
//            table.addCell("Value");
//
//            table.addCell("Start Date");
//            table.addCell(startMonthDatePicker.getValue().toString());
//
//            table.addCell("End Date");
//            table.addCell(endMonthDatePicker.getValue().toString());
//
//            table.addCell("Absence Days");
//            table.addCell(absenceTextField.getText());
//
//            table.addCell("Calculated Salary");
//            table.addCell(String.valueOf(report.getSalary()));
//
//            table.addCell("Report Month");
//            table.addCell(startMonthDatePicker.getValue().getMonth().toString());
//
//            table.addCell("Report Year");
//            table.addCell(String.valueOf(startMonthDatePicker.getValue().getYear()));
//
//            document.add(table);
//            document.add(new Paragraph(" "));
//
//            // Add footer
//            document.add(new Paragraph("--- End of Report ---"));
//
//            document.close();
//
//            errorSuccessLabel.setText("PDF report saved successfully!");
//            errorSuccessLabel.setStyle("-fx-text-fill: green;");
//
//        } catch (DocumentException | IOException e) {
//            errorSuccessLabel.setText("Error creating PDF: " + e.getMessage());
//            errorSuccessLabel.setStyle("-fx-text-fill: red;");
//            e.printStackTrace();
//        }
    }

    private boolean validateInput(){
        if (startMonthDatePicker.getValue() == null || endMonthDatePicker.getValue() == null || absenceTextField.getText().isEmpty()){
            errorSuccessLabel.setText("Please Enter all the values.");
            return false;
        }

        if(startMonthDatePicker.getValue().getMonthValue() != endMonthDatePicker.getValue().getMonthValue()){
            errorSuccessLabel.setText("Date have to be same month.");
            return false;
        }

        if(startMonthDatePicker.getValue().getDayOfMonth() >= endMonthDatePicker.getValue().getDayOfMonth()){
            errorSuccessLabel.setText("Starting Date should be before the ending date.");
            return false;
        }

        String temp = absenceTextField.getText();
        int absence;
        try{
            absence = Integer.parseInt(temp);
            if (absence <= 0){
                errorSuccessLabel.setText("The absence should be positive.");
                return false;
            }
        } catch (NumberFormatException e){
            errorSuccessLabel.setText("Add integer value in the absence text field");
            return false;
        }

        if (absence > (endMonthDatePicker.getValue().getDayOfMonth() - startMonthDatePicker.getValue().getDayOfMonth())){
            errorSuccessLabel.setText("Absence is more than working day. Input the proper information.");
            return false;
        }

        return true;
    }
}