package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;

// ==================== FINANCIAL REPORTING ====================
public class FinancialReport {
    private String reportId;
    private String reportType; // "DAILY", "WEEKLY", "MONTHLY", "ANNUAL"
    private Date periodStart;
    private Date periodEnd;
    private String format; // "PDF", "EXCEL", "HTML"

    public FinancialReport(String reportId, String reportType,
                           Date periodStart, Date periodEnd) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.format = "PDF";
    }

    public void generateReport() {
        System.out.println("Generating " + reportType + " financial report");
        System.out.println("Period: " + periodStart + " to " + periodEnd);
        // Report generation logic
    }

    public void exportToPDF() {
        System.out.println("Exporting report " + reportId + " to PDF format");
        // PDF export logic
    }

    // Getters and Setters
    public String getReportId() { return reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }

    public String getReportType() { return reportType; }
    public void setReportType(String reportType) { this.reportType = reportType; }

    public Date getPeriodStart() { return periodStart; }
    public void setPeriodStart(Date periodStart) { this.periodStart = periodStart; }

    public Date getPeriodEnd() { return periodEnd; }
    public void setPeriodEnd(Date periodEnd) { this.periodEnd = periodEnd; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }
}
