package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.ArrayList;
import java.util.List;

// AnnualReport Class
public class AnnualReport {
    private String reportId;
    private Integer year;
    private String analysisParameters;
    private List<ChartData> charts;

    public AnnualReport(String reportId, Integer year) {
        this.reportId = reportId;
        this.year = year;
        this.charts = new ArrayList<>();
    }

    public void generateComparativeCharts() {
        System.out.println("Generating comparative charts for annual report: " + year);

        // Create sample charts
        ChartData revenueChart = new ChartData("CHART_REV_" + year, "BAR",
                "Revenue Comparison", true);
        ChartData expenseChart = new ChartData("CHART_EXP_" + year, "LINE",
                "Expense Trend", true);
        ChartData profitChart = new ChartData("CHART_PROF_" + year, "PIE",
                "Profit Distribution", false);

        charts.add(revenueChart);
        charts.add(expenseChart);
        charts.add(profitChart);

        System.out.println("Generated " + charts.size() + " comparative charts");
    }

    public void exportVisualReport() {
        System.out.println("Exporting visual report for year: " + year);
        System.out.println("Report ID: " + reportId);
        System.out.println("Number of charts: " + charts.size());
        // Export logic (PDF, Excel, etc.)
    }

    // Getters and Setters
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAnalysisParameters() {
        return analysisParameters;
    }

    public void setAnalysisParameters(String analysisParameters) {
        this.analysisParameters = analysisParameters;
    }

    public List<ChartData> getCharts() {
        return charts;
    }

    public void setCharts(List<ChartData> charts) {
        this.charts = charts;
    }
}
