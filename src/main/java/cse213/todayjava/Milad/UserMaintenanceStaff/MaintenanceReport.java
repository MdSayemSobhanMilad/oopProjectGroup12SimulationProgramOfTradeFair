package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDate;

public class MaintenanceReport {
    private String reportId;
    private String reportType;
    private LocalDate generatedDate;
    private String generatedBy;
    private String status;

    // Default constructor (REQUIRED for JavaFX TableView)
    public MaintenanceReport() {
        this.reportId = "";
        this.reportType = "";
        this.generatedDate = LocalDate.now();
        this.generatedBy = "";
        this.status = "";
    }

    public MaintenanceReport(String reportId, String reportType, LocalDate generatedDate, String generatedBy, String status) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.generatedDate = generatedDate;
        this.generatedBy = generatedBy;
        this.status = status;
    }

    // Getters and Setters (MUST be exactly like this)
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MaintenanceReport{" +
                "reportId='" + reportId + '\'' +
                ", reportType='" + reportType + '\'' +
                ", generatedDate=" + generatedDate +
                ", generatedBy='" + generatedBy + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}