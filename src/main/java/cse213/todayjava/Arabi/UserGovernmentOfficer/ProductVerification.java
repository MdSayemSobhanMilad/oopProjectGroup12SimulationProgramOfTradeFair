package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class ProductVerification {
    private String stallNo;
    private String productName;
    private String officerStallNumber;
    private String complianceStatus; // Compliant or Non-Compliant

    // Constructor
    public ProductVerification(String stallNo, String productName, String officerStallNumber, String complianceStatus) {
        this.stallNo = stallNo;
        this.productName = productName;
        this.officerStallNumber = officerStallNumber;
        this.complianceStatus = complianceStatus;
    }

    // Empty constructor
    public ProductVerification() {
    }

    // Getters and Setters
    public String getStallNo() {
        return stallNo;
    }

    public void setStallNo(String stallNo) {
        this.stallNo = stallNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOfficerStallNumber() {
        return officerStallNumber;
    }

    public void setOfficerStallNumber(String officerStallNumber) {
        this.officerStallNumber = officerStallNumber;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }

    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    // toString method
    @Override
    public String toString() {
        return stallNo + " | " + productName + " | " + officerStallNumber + " | " + complianceStatus;
    }
}