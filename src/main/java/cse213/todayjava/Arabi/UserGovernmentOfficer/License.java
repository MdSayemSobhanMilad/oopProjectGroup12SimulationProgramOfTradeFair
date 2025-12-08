package cse213.todayjava.Arabi.UserGovernmentOfficer;

import java.util.Date;

public class License {
    private String licenseId;
    private String type;
    private Date issueDate;
    private Date expiryDate;
    private String status;

    // Constructor
    public License(String licenseId, String type, Date issueDate, Date expiryDate, String status) {
        this.licenseId = licenseId;
        this.type = type;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    // Default constructor
    public License() {}

    // Getters and Setters
    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Methods from UML
    public boolean validateLicense() {
        Date currentDate = new Date();
        boolean isValid = currentDate.before(expiryDate) && "Active".equals(status);
        System.out.println("License " + licenseId + " validation: " + isValid);
        return isValid;
    }

    public void renewLicense() {
        long oneYearInMillis = 365L * 24 * 60 * 60 * 1000;
        this.expiryDate = new Date(this.expiryDate.getTime() + oneYearInMillis);
        this.status = "Active";
        System.out.println("License renewed: " + licenseId);
    }

    // toString method
    @Override
    public String toString() {
        return "License{" +
                "licenseId='" + licenseId + '\'' +
                ", type='" + type + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", status='" + status + '\'' +
                '}';
    }
}
