package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.List;
import java.util.ArrayList;

// ==================== DASHBOARD & INTERFACE ====================
public class FinancialDashboard {
    private String dashboardId;
    private String userRole;
    private List<RevenueRecord> revenueRecords;
    private List<Budget> budgets;
    private List<ChartData> charts;

    public FinancialDashboard(String dashboardId, String userRole) {
        this.dashboardId = dashboardId;
        this.userRole = userRole;
        this.revenueRecords = new ArrayList<>();
        this.budgets = new ArrayList<>();
        this.charts = new ArrayList<>();
    }

    public void displayRevenueSummary() {
        System.out.println("=== REVENUE SUMMARY ===");
        double totalRevenue = 0;
        for (RevenueRecord record : revenueRecords) {
            totalRevenue += record.calculateTotalRevenue();
            System.out.println(record.getSourceType() + ": $" + record.getAmount());
        }
        System.out.println("TOTAL REVENUE: $" + totalRevenue);
    }

    public void showBudgetStatus() {
        System.out.println("\n=== BUDGET STATUS ===");
        for (Budget budget : budgets) {
            double remaining = budget.calculateRemainingBalance();
            boolean withinLimit = budget.validateExpenseLimit();
            System.out.println(budget.getCategory() + ": $" + remaining + " remaining - "
                    + (withinLimit ? "Within limits" : "EXCEEDED"));
        }
    }

    public void displayAnalytics() {
        System.out.println("\n=== FINANCIAL ANALYTICS ===");
        System.out.println("Number of revenue records: " + revenueRecords.size());
        System.out.println("Number of budgets monitored: " + budgets.size());
        System.out.println("Number of charts available: " + charts.size());

        // Display charts
        for (ChartData chart : charts) {
            chart.displayChart();
        }
    }

    public void addRevenueRecord(RevenueRecord record) {
        revenueRecords.add(record);
    }

    public void addBudget(Budget budget) {
        budgets.add(budget);
    }

    public void addChart(ChartData chart) {
        charts.add(chart);
    }

    // Getters and Setters
    public String getDashboardId() { return dashboardId; }
    public void setDashboardId(String dashboardId) { this.dashboardId = dashboardId; }

    public String getUserRole() { return userRole; }
    public void setUserRole(String userRole) { this.userRole = userRole; }

    public List<RevenueRecord> getRevenueRecords() { return revenueRecords; }
    public void setRevenueRecords(List<RevenueRecord> revenueRecords) {
        this.revenueRecords = revenueRecords;
    }

    public List<Budget> getBudgets() { return budgets; }
    public void setBudgets(List<Budget> budgets) { this.budgets = budgets; }

    public List<ChartData> getCharts() { return charts; }
    public void setCharts(List<ChartData> charts) { this.charts = charts; }
}
