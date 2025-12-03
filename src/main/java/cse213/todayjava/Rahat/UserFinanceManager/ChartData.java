package cse213.todayjava.Rahat.UserFinanceManager;

// ChartData Class
class ChartData {
    private String chartId;
    private String chartType; // "BAR", "LINE", "PIE", "AREA"
    private String dataSet;
    private Boolean isInteractive;

    public ChartData(String chartId, String chartType, String dataSet, Boolean isInteractive) {
        this.chartId = chartId;
        this.chartType = chartType;
        this.dataSet = dataSet;
        this.isInteractive = isInteractive;
    }

    public void displayChart() {
        System.out.println("Displaying " + chartType + " chart: " + dataSet);
        System.out.println("Chart ID: " + chartId);
        System.out.println("Interactive: " + (isInteractive ? "Yes" : "No"));
        // Chart rendering logic
    }

    // Getters and Setters
    public String getChartId() {
        return chartId;
    }

    public void setChartId(String chartId) {
        this.chartId = chartId;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getDataSet() {
        return dataSet;
    }

    public void setDataSet(String dataSet) {
        this.dataSet = dataSet;
    }

    public Boolean getIsInteractive() {
        return isInteractive;
    }

    public void setIsInteractive(Boolean isInteractive) {
        this.isInteractive = isInteractive;
    }
}
