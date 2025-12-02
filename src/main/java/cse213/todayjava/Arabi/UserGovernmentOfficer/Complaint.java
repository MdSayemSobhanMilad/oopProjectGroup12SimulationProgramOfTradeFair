package cse213.todayjava.Arabi.UserGovernmentOfficer;

import java.util.Date;

public class Complaint {
    private String complaintId;
    private String description;
    private Date filedDate;
    private String status;
    private String resolution;

    // Constructor
    public Complaint(String complaintId, String description, Date filedDate, String status, String resolution) {
        this.complaintId = complaintId;
        this.description = description;
        this.filedDate = filedDate;
        this.status = status;
        this.resolution = resolution;
    }

    // Default constructor
    public Complaint() {
    }

    // Getters and Setters
    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFiledDate() {
        return filedDate;
    }

    public void setFiledDate(Date filedDate) {
        this.filedDate = filedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    // Methods from UML
    public void fileComplaint() {
        System.out.println("Complaint filed successfully: " + complaintId);
    }

    public void resolveComplaint() {
        this.status = "Resolved";
        System.out.println("Complaint resolved: " + complaintId);
    }

    // toString method
    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId='" + complaintId + '\'' +
                ", description='" + description + '\'' +
                ", filedDate=" + filedDate +
                ", status='" + status + '\'' +
                ", resolution='" + resolution + '\'' +
                '}';
    }
}
