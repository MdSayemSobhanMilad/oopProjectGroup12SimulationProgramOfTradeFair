package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDateTime;

public class ReportParameters {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String reportType;
    private String[] includedSections;

    public ReportParameters() {
    }

    public ReportParameters(LocalDateTime startDate, LocalDateTime endDate, String reportType, String[] includedSections) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reportType = reportType;
        this.includedSections = includedSections;
    }

    // Getters and Setters
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String[] getIncludedSections() {
        return includedSections;
    }

    public void setIncludedSections(String[] includedSections) {
        this.includedSections = includedSections;
    }

    // Methods
    public boolean validateParameters() {
        if (startDate == null || endDate == null || reportType == null || reportType.isEmpty()) {
            System.out.println("Report parameters validation failed: Missing required fields");
            return false;
        }
        if (startDate.isAfter(endDate)) {
            System.out.println("Report parameters validation failed: Start date cannot be after end date");
            return false;
        }
        System.out.println("Report parameters validated successfully");
        return true;
    }

    @Override
    public String toString() {
        return "ReportParameters{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", reportType='" + reportType + '\'' +
                '}';
    }
}
