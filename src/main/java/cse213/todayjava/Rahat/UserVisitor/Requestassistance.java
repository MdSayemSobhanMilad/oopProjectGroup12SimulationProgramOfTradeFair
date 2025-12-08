package cse213.todayjava.Rahat.UserVisitor;

import java.io.Serializable;

public class Requestassistance implements Serializable {
    private int VisitorId;
    private String TypeOfAssistance;

    public Requestassistance(int visitorId, String typeOfAssistance) {
        VisitorId = visitorId;
        TypeOfAssistance = typeOfAssistance;
    }

    public int getVisitorId() {
        return VisitorId;
    }

    public void setVisitorId(int visitorId) {
        VisitorId = visitorId;
    }

    public String getTypeOfAssistance() {
        return TypeOfAssistance;
    }

    public void setTypeOfAssistance(String typeOfAssistance) {
        TypeOfAssistance = typeOfAssistance;
    }

    @Override
    public String toString() {
        return "Requestassistance{" +
                "VisitorId=" + VisitorId +
                ", TypeOfAssistance='" + TypeOfAssistance + '\'' +
                '}';
    }
}
