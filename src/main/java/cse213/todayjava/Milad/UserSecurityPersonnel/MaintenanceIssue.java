package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;
import java.util.Map;

public class MaintenanceIssue {
    private String issueId;
    private String reportedBy;
    private String location;
    private String description;
    private String priority;
    private String status;

    // Constructors
    public MaintenanceIssue() {}

    public MaintenanceIssue(String issueId, String reportedBy, String location,
                            String description, String priority) {
        this.issueId = issueId;
        this.reportedBy = reportedBy;
        this.location = location;
        this.description = description;
        this.priority = priority;
        this.status = "REPORTED";
    }

    // Getters and Setters
    public String getIssueId() { return issueId; }
    public void setIssueId(String issueId) { this.issueId = issueId; }

    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods
    public Boolean reportIssue(Map<String, String> details) {
        if (details != null) {
            this.location = details.get("location");
            this.description = details.get("description");
            this.priority = details.get("priority");
            System.out.println("Maintenance issue reported at " + location + " with priority: " + priority);
            return true;
        }
        return false;
    }

    public Boolean sendToMaintenanceQueue() {
        this.status = "QUEUED";
        System.out.println("Maintenance issue " + issueId + " sent to maintenance queue");
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceIssue{" +
                "issueId='" + issueId + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", location='" + location + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
