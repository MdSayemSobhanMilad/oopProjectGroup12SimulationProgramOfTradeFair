package cse213.todayjava.Arabi.UserMediaPromoter;

import java.util.Date;

public class Advertisement {
    private String adId;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private Double cost;

    // Constructor
    public Advertisement(String adId, String title, String content, Date startDate, Date endDate, Double cost) {
        this.adId = adId;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    // Default constructor
    public Advertisement() {}

    // Getters and Setters
    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    // Methods from UML
    public void approveAd() {
        System.out.println("Advertisement approved: " + title);
    }

    public void rejectAd() {
        System.out.println("Advertisement rejected: " + title);
    }

    // toString method
    @Override
    public String toString() {
        return "Advertisement{" +
                "adId='" + adId + '\'' +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cost=" + cost +
                '}';
    }
}
