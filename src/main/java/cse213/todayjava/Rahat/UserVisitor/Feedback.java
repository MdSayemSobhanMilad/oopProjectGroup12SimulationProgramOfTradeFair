package cse213.todayjava.Rahat.UserVisitor;

import java.io.Serializable;

public class Feedback implements Serializable {
    private String Stallname;
    private String Productname;
    private String Rating;


    public Feedback(String stallname, String productname, String rating) {
        Stallname = stallname;
        Productname = productname;
        Rating = rating;
    }

    public String getStallname() {
        return Stallname;
    }

    public void setStallname(String stallname) {
        Stallname = stallname;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "Stallname='" + Stallname + '\'' +
                ", Productname='" + Productname + '\'' +
                ", Rating='" + Rating + '\'' +
                '}';
    }
}
