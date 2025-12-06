package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class PolicyCompliance {
    private String stallName;
    private String violenceDetails;


    public PolicyCompliance(String stallName, String violenceDetails) {
        this.stallName = stallName;
        this.violenceDetails = violenceDetails;
    }


    public PolicyCompliance() {
    }


    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getViolenceDetails() {
        return violenceDetails;
    }

    public void setViolenceDetails(String violenceDetails) {
        this.violenceDetails = violenceDetails;
    }


    @Override
    public String toString() {
        return stallName + ": " + violenceDetails;
    }
}