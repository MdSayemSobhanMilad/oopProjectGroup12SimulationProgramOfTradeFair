package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class ExhibitorLicense {
    private String exhibitorName;
    private String stallNo;
    private String licenseNumber;

    // Constructor with parameters
    public ExhibitorLicense(String exhibitorName, String stallNo, String licenseNumber) {
        this.exhibitorName = exhibitorName;
        this.stallNo = stallNo;
        this.licenseNumber = licenseNumber;
    }

    // Empty constructor
    public ExhibitorLicense() {
    }

    // Getters and Setters
    public String getExhibitorName() {
        return exhibitorName;
    }

    public void setExhibitorName(String exhibitorName) {
        this.exhibitorName = exhibitorName;
    }

    public String getStallNo() {
        return stallNo;
    }

    public void setStallNo(String stallNo) {
        this.stallNo = stallNo;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "Exhibitor: " + exhibitorName +
                ", Stall: " + stallNo +
                ", License: " + licenseNumber;
    }
}
