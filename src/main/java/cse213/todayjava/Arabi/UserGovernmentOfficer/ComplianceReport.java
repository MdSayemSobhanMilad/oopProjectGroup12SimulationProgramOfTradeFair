package cse213.todayjava.Arabi.UserGovernmentOfficer;

import java.util.Date;

public class ComplianceReport {
    private String reportId;
    private Date generationDate;
    private String reportType;
    private String findings;

    // Constructor
    public ComplianceReport(String reportId, Date generationDate, String reportType, String findings) {
        this.reportId = reportId;
        this.generationDate = generationDate;
        this.reportType = reportType;
        this.findings = findings;
    }

    // Default constructor
    public ComplianceReport() {
    }

    // Getters and Setters
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    // Methods from UML
    public void generateReport() {
        System.out.println("Compliance report generated: " + reportId + " - " + reportType);
    }

    public void exportPDF() {
        System.out.println("Exporting compliance report to PDF: " + reportId);
    }

    // toString method
    @Override
    public String toString() {
        return "ComplianceReport{" +
                "reportId='" + reportId + '\'' +
                ", generationDate=" + generationDate +
                ", reportType='" + reportType + '\'' +
                ", findings='" + findings + '\'' +
                '}';
    }
}
