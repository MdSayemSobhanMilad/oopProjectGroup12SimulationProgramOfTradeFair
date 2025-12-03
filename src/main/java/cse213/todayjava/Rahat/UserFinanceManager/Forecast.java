package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Forecast Class
public class Forecast {
    private String forecastId;
    private Date forecastDate;
    private String forecastType; // "COST", "REVENUE", "ATTENDANCE"
    private Double projectedAmount;
    private Double confidenceLevel;
    private List<HistoricalData> historicalData;

    public Forecast(String forecastId) {
        this.forecastId = forecastId;
        this.forecastDate = new Date();
        this.historicalData = new ArrayList<>();
        this.confidenceLevel = 0.0;
    }

    public void applyForecastingModel(List<HistoricalData> data) {
        this.historicalData = data;
        System.out.println("Applying forecasting model with " + data.size() + " data points");

        // Simple forecasting logic (average of last 3 periods)
        if (data.size() >= 3) {
            double sum = 0;
            for (int i = data.size() - 3; i < data.size(); i++) {
                sum += data.get(i).getActualExpenses();
            }
            this.projectedAmount = sum / 3;
            this.confidenceLevel = 0.85; // 85% confidence
        }

        System.out.println("Forecast projected amount: $" + projectedAmount);
        System.out.println("Confidence level: " + (confidenceLevel * 100) + "%");
    }

    public boolean validateAccuracy() {
        if (historicalData.isEmpty()) {
            System.out.println("No historical data to validate accuracy");
            return false;
        }

        // Simple validation logic
        HistoricalData latest = historicalData.get(historicalData.size() - 1);
        double difference = Math.abs(projectedAmount - latest.getActualExpenses());
        double accuracy = 1 - (difference / latest.getActualExpenses());

        System.out.println("Forecast accuracy: " + (accuracy * 100) + "%");
        return accuracy > 0.7; // 70% threshold
    }

    // Getters and Setters
    public String getForecastId() {
        return forecastId;
    }

    public void setForecastId(String forecastId) {
        this.forecastId = forecastId;
    }

    public Date getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(Date forecastDate) {
        this.forecastDate = forecastDate;
    }

    public String getForecastType() {
        return forecastType;
    }

    public void setForecastType(String forecastType) {
        this.forecastType = forecastType;
    }

    public Double getProjectedAmount() {
        return projectedAmount;
    }

    public void setProjectedAmount(Double projectedAmount) {
        this.projectedAmount = projectedAmount;
    }

    public Double getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(Double confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public List<HistoricalData> getHistoricalData() {
        return historicalData;
    }

    public void setHistoricalData(List<HistoricalData> historicalData) {
        this.historicalData = historicalData;
    }
}
