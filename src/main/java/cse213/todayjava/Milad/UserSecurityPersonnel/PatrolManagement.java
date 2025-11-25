package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

public class PatrolManagement {
    private String patrolId;
    private String securityPersonnelId;
    private String zoneId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    // Constructors
    public PatrolManagement() {}

    public PatrolManagement(String patrolId, String securityPersonnelId, String zoneId) {
        this.patrolId = patrolId;
        this.securityPersonnelId = securityPersonnelId;
        this.zoneId = zoneId;
        this.status = "PENDING";
    }

    // Getters and Setters
    public String getPatrolId() { return patrolId; }
    public void setPatrolId(String patrolId) { this.patrolId = patrolId; }

    public String getSecurityPersonnelId() { return securityPersonnelId; }
    public void setSecurityPersonnelId(String securityPersonnelId) { this.securityPersonnelId = securityPersonnelId; }

    public String getZoneId() { return zoneId; }
    public void setZoneId(String zoneId) { this.zoneId = zoneId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods
    public Boolean recordPatrolStart(String zoneId) {
        this.zoneId = zoneId;
        this.startTime = LocalDateTime.now();
        this.status = "IN_PROGRESS";
        System.out.println("Patrol " + patrolId + " started in zone: " + zoneId);
        return true;
    }

    public Boolean recordPatrolCompletion() {
        this.endTime = LocalDateTime.now();
        this.status = "COMPLETED";
        System.out.println("Patrol " + patrolId + " completed. Duration: " +
                Duration.between(startTime, endTime).toMinutes() + " minutes");
        return true;
    }

    public List<PatrolManagement> getPatrolHistory(String securityPersonnelId) {
        System.out.println("Retrieving patrol history for security personnel: " + securityPersonnelId);
        return List.of(this);
    }

    @Override
    public String toString() {
        return "PatrolManagement{" +
                "patrolId='" + patrolId + '\'' +
                ", securityPersonnelId='" + securityPersonnelId + '\'' +
                ", zoneId='" + zoneId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                '}';
    }
}