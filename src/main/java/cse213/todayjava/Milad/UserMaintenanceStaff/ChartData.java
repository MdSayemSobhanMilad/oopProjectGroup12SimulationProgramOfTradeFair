package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.util.Arrays;

public class ChartData {
    private String chartId;
    private String chartType;
    private String[] labels;
    private Number[] values;
    private String timeFrame;

    public ChartData() {
    }

    public ChartData(String chartId, String chartType, String[] labels, Number[] values, String timeFrame) {
        this.chartId = chartId;
        this.chartType = chartType;
        this.labels = labels;
        this.values = values;
        this.timeFrame = timeFrame;
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

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Number[] getValues() {
        return values;
    }

    public void setValues(Number[] values) {
        this.values = values;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    // Methods
    public ChartData calculateMetrics() {
        System.out.println("Calculating metrics for chart: " + chartId);
        // Implementation to calculate chart metrics
        return this;
    }

    public Object[] getDataPoints() {
        System.out.println("Getting data points for chart: " + chartId);
        if (labels != null && values != null && labels.length == values.length) {
            Object[] dataPoints = new Object[labels.length];
            for (int i = 0; i < labels.length; i++) {
                dataPoints[i] = new Object[]{labels[i], values[i]};
            }
            return dataPoints;
        }
        return new Object[0];
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "chartId='" + chartId + '\'' +
                ", chartType='" + chartType + '\'' +
                ", labels=" + Arrays.toString(labels) +
                ", timeFrame='" + timeFrame + '\'' +
                '}';
    }
}
