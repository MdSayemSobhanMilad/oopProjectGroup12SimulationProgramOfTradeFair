package cse213.todayjava.Ahad.UserTicketCounterStaff;

import java.util.Date;

public class SalesReport {
    private String reportId;
    private Date reportDate;
    private Integer ticketsSold;
    private Double totalRevenue;

    public SalesReport(String reportId) {
        this.reportId = reportId;
        this.reportDate = new Date();
        this.ticketsSold = 0;
        this.totalRevenue = 0.0;
    }

    // Getters and Setters
    public String getReportId() { return reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }

    public Date getReportDate() { return reportDate; }
    public void setReportDate(Date reportDate) { this.reportDate = reportDate; }

    public Integer getTicketsSold() { return ticketsSold; }
    public void setTicketsSold(Integer ticketsSold) { this.ticketsSold = ticketsSold; }

    public Double getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(Double totalRevenue) { this.totalRevenue = totalRevenue; }

    // Methods
    public void generateReport() {
        System.out.println("=== SALES REPORT ===");
        System.out.println("Report ID: " + reportId);
        System.out.println("Date: " + reportDate);
        System.out.println("Tickets Sold: " + ticketsSold);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Report generated successfully.");
    }

    public void sendToFinance() {
        System.out.println("Sales report sent to Finance Manager via email.");
        System.out.println("Report ID: " + reportId);
    }

    @Override
    public String toString() {
        return "SalesReport{" +
                "reportId='" + reportId + '\'' +
                ", reportDate=" + reportDate +
                ", ticketsSold=" + ticketsSold +
                ", totalRevenue=" + totalRevenue +
                '}';
    }
}