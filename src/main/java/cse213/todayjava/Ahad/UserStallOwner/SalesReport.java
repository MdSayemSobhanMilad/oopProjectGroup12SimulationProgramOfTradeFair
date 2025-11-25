package cse213.todayjava.Ahad.UserStallOwner;

public class SalesReport {
    private String reportId;
    private Double dailySales;

    public SalesReport(String reportId, Double dailySales) {
        this.reportId = reportId;
        this.dailySales = dailySales;
    }

    // Getters and Setters
    public String getReportId() { return reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }

    public Double getDailySales() { return dailySales; }
    public void setDailySales(Double dailySales) { this.dailySales = dailySales; }

    // Methods
    public void updateReport(Double newSaleAmount) {
        this.dailySales += newSaleAmount;
        System.out.println("Sales report updated. New total: $" + dailySales);
    }

    public void generateReport() {
        System.out.println("=== SALES REPORT ===");
        System.out.println("Report ID: " + reportId);
        System.out.println("Total Sales: $" + dailySales);
        System.out.println("Generated on: " + java.time.LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "SalesReport{" +
                "reportId='" + reportId + '\'' +
                ", dailySales=" + dailySales +
                '}';
    }
}
