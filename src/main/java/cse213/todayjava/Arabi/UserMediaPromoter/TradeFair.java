package cse213.todayjava.Arabi.UserMediaPromoter;

import java.util.Date;

public class TradeFair {
    private String fairId;
    private String name;
    private Date startDate;
    private Date endDate;

    // Constructor
    public TradeFair(String fairId, String name, Date startDate, Date endDate) {
        this.fairId = fairId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Default constructor
    public TradeFair() {
    }

    // Getters and Setters
    public String getFairId() {
        return fairId;
    }

    public void setFairId(String fairId) {
        this.fairId = fairId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // toString method
    @Override
    public String toString() {
        return "TradeFair{" +
                "fairId='" + fairId + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
