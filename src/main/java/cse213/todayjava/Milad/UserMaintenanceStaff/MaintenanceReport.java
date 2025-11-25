package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDateTime;

public class MaintenanceReport {
    private String reportId;
    private String reportType;
    private LocalDateTime generatedDate;
    private String timeFrame;
    private String generatedBy;
    private byte[] reportContent;

    public MaintenanceReport() {
        this.generatedDate = LocalDateTime.now();
    }

    public MaintenanceReport(String reportId, String reportType, String timeFrame, String generatedBy) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.timeFrame = timeFrame;
        this.generatedBy = generatedBy;
        this.generatedDate = LocalDateTime.now();
    }

    // Getters and Setters
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

    public LocalDateTime getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public byte[] getReportContent() {
        return reportContent;
    }

    public void setReportContent(byte[] reportContent) {
        this.reportContent = reportContent;
    }

    // Methods
    public MaintenanceReport generateReport(ReportParameters parameters) {
        System.out.println("Generating maintenance report with ID: " + reportId);
        // Implementation to generate report content
        this.reportContent = ("Maintenance Report: " + reportType).getBytes();
        return this;
    }

    public byte[] previewReport() {
        System.out.println("Previewing report: " + reportId);
        return reportContent != null ? reportContent : "Report preview not available".getBytes();
    }

    public byte[] exportToPDF() {
        System.out.println("Exporting report " + reportId + " to PDF");
        // Implementation for PDF export
        return reportContent != null ? reportContent : "PDF export content".getBytes();
    }

    public boolean printReport() {
        System.out.println("Printing report: " + reportId);
        // Implementation for printing logic
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceReport{" +
                "reportId='" + reportId + '\'' +
                ", reportType='" + reportType + '\'' +
                ", generatedDate=" + generatedDate +
                ", timeFrame='" + timeFrame + '\'' +
                ", generatedBy='" + generatedBy + '\'' +
                '}';
    }
}
