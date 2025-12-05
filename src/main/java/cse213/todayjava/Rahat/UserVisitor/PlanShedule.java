package cse213.todayjava.Rahat.UserVisitor;

import jdk.jfr.Category;

import java.io.Serializable;
import java.time.LocalDate;

public class PlanShedule implements Serializable {
    private String VisitorName;
    private int Stallnumber;
    private String StallType;
    private String Category ;
    private LocalDate Bookingdate;
    private String Productcategory;

    public PlanShedule(String visitorName, Integer stallnumber, String stallType, String category, LocalDate bookingdate, String productcategory) {
        VisitorName = visitorName;
        Stallnumber = stallnumber;
        StallType = stallType;
        Category = category;
        Bookingdate = bookingdate;
        Productcategory = productcategory;
    }

    public String getVisitorName() {
        return VisitorName;
    }

    public void setVisitorName(String visitorName) {
        VisitorName = visitorName;
    }

    public Integer getStallnumber() {
        return Stallnumber;
    }

    public void setStallnumber(Integer stallnumber) {
        Stallnumber = stallnumber;
    }

    public String getStallType() {
        return StallType;
    }

    public void setStallType(String stallType) {
        StallType = stallType;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public LocalDate getBookingdate() {
        return Bookingdate;
    }

    public void setBookingdate(LocalDate bookingdate) {
        Bookingdate = bookingdate;
    }

    public String getProductcategory() {
        return Productcategory;
    }

    public void setProductcategory(String productcategory) {
        Productcategory = productcategory;
    }

    @Override
    public String toString() {
        return "PlanShedule{" +
                "VisitorName='" + VisitorName + '\'' +
                ", Stallnumber=" + Stallnumber +
                ", StallType='" + StallType + '\'' +
                ", Category='" + Category + '\'' +
                ", Bookingdate=" + Bookingdate +
                ", Productcategory='" + Productcategory + '\'' +
                '}';
    }
}









