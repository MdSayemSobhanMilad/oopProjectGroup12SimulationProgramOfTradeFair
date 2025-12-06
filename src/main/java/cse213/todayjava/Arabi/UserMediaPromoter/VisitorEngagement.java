package cse213.todayjava.Arabi.UserMediaPromoter;

import java.time.LocalDate;

public class VisitorEngagement {
    private String visitorPost;
    private LocalDate selectDate;
    private String comments;


    public VisitorEngagement(String visitorPost, LocalDate selectDate, String comments) {
        this.visitorPost = visitorPost;
        this.selectDate = selectDate;
        this.comments = comments;
    }


    public VisitorEngagement() {
    }


    public String getVisitorPost() {
        return visitorPost;
    }

    public void setVisitorPost(String visitorPost) {
        this.visitorPost = visitorPost;
    }

    public LocalDate getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(LocalDate selectDate) {
        this.selectDate = selectDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return visitorPost + " | " + selectDate + " | " + comments;
    }
}