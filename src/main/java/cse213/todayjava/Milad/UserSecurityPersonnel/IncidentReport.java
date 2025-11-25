package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;
import java.time.Duration;

public class IncidentReport {
    private String incidentId;
    private String reportedBy;
    private String location;
    private String incidentType;
    private String description;
    private String status;
    private LocalDateTime reportedTime;
    private LocalDateTime resolvedTime;

    // Constructors
    public IncidentReport() {}

    public IncidentReport(String incidentId, String reportedBy, String location,
                          String incidentType, String description) {
        this.incidentId = incidentId;
        this.reportedBy = reportedBy;
        this.location = location;
        this.incidentType = incidentType;
        this.description = description;
        this.reportedTime = LocalDateTime.now();
        this.status = "OPEN";
    }

    // Getters and Setters
    public String getIncidentId() { return incidentId; }
    public void setIncidentId(String incidentId) { this.incidentId = incidentId; }

    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getIncidentType() { return incidentType; }
    public void setIncidentType(String incidentType) { this.incidentType = incidentType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getReportedTime() { return reportedTime; }
    public void setReportedTime(LocalDateTime reportedTime) { this.reportedTime = reportedTime; }

    public LocalDateTime getResolvedTime() { return resolvedTime; }
    public void setResolvedTime(LocalDateTime resolvedTime) { this.resolvedTime = resolvedTime; }

    // Methods
    public Boolean updateStatus(String newStatus) {
        this.status = newStatus;
        if ("RESOLVED".equals(newStatus)) {
            this.resolvedTime = LocalDateTime.now();
        }
        System.out.println("Incident " + incidentId + " status updated to: " + newStatus);
        return true;
    }

    public String generatePDFReport() {
        String reportContent = "INCIDENT REPORT\n" +
                "Incident ID: " + incidentId + "\n" +
                "Type: " + incidentType + "\n" +
                "Location: " + location + "\n" +
                "Reported By: " + reportedBy + "\n" +
                "Reported Time: " + reportedTime + "\n" +
                "Status: " + status + "\n" +
                "Description: " + description + "\n";

        if (resolvedTime != null) {
            reportContent += "Resolved Time: " + resolvedTime + "\n" +
                    "Time to Resolve: " +
                    Duration.between(reportedTime, resolvedTime).toMinutes() + " minutes\n";
        }

        System.out.println("PDF report generated for incident: " + incidentId);
        return reportContent;
    }

    @Override
    public String toString() {
        return "IncidentReport{" +
                "incidentId='" + incidentId + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", location='" + location + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", status='" + status + '\'' +
                ", reportedTime=" + reportedTime +
                ", resolvedTime=" + resolvedTime +
                '}';
    }
}