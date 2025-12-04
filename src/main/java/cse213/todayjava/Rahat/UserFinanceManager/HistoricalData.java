package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;

// ==================== COST FORECASTING ====================

// HistoricalData Class
class HistoricalData {
    private String dataId;
    private Date period;
    private Double actualRevenue;
    private Double actualExpenses;
    private Integer attendance;

    public HistoricalData(String dataId, Date period, Double actualRevenue,
                          Double actualExpenses, Integer attendance) {
        this.dataId = dataId;
        this.period = period;
        this.actualRevenue = actualRevenue;
        this.actualExpenses = actualExpenses;
        this.attendance = attendance;
    }

    // Getters and Setters
    public String getDataId() { return dataId; }
    public void setDataId(String dataId) { this.dataId = dataId; }

    public Date getPeriod() { return period; }
    public void setPeriod(Date period) { this.period = period; }

    public Double getActualRevenue() { return actualRevenue; }
    public void setActualRevenue(Double actualRevenue) { this.actualRevenue = actualRevenue; }

    public Double getActualExpenses() { return actualExpenses; }
    public void setActualExpenses(Double actualExpenses) { this.actualExpenses = actualExpenses; }

    public Integer getAttendance() { return attendance; }
    public void setAttendance(Integer attendance) { this.attendance = attendance; }
}
