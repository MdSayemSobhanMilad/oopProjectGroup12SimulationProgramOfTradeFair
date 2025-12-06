package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class ReportRecord {
    private String reportType;
    private String dateRange;
    private String reportDetails;


    public ReportRecord(String reportType, String dateRange, String reportDetails) {
        this.reportType = reportType;
        this.dateRange = dateRange;
        this.reportDetails = reportDetails;
    }


    public ReportRecord() {
    }


    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }


    @Override
    public String toString() {
        return reportType + " | " + dateRange + " | " + reportDetails;
    }
}