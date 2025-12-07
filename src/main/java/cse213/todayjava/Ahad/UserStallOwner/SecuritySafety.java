package cse213.todayjava.Ahad.UserStallOwner.ModelClasses;

import java.time.LocalDateTime;

public class SecuritySafety {
    private String incidentId;
    private String incidentType;
    private String description;
    private LocalDateTime reportedTime;
    private String status;
    private String stallId;
    private String reportedBy;

    // Constructor
    public SecuritySafety() {
        this.reportedTime = LocalDateTime.now();
        this.status = "Pending";
    }

    public SecuritySafety(String incidentId, String incidentType, String description, String stallId, String reportedBy) {
        this.incidentId = incidentId;
        this.incidentType = incidentType;
        this.description = description;
        this.stallId = stallId;
        this.reportedBy = reportedBy;
        this.reportedTime = LocalDateTime.now();
        this.status = "Pending";
    }

    // Getters and Setters
    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(LocalDateTime reportedTime) {
        this.reportedTime = reportedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStallId() {
        return stallId;
    }

    public void setStallId(String stallId) {
        this.stallId = stallId;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    @Override
    public String toString() {
        return "[" + incidentId + "] " + incidentType + " - " + status + " (" + reportedTime + ")";
    }
}