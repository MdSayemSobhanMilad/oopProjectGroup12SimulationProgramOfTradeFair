package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;
import java.time.Duration;

public class ShiftLog {
    private String logId;
    private String securityPersonnelId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double duration;

    // Constructors
    public ShiftLog() {}

    public ShiftLog(String logId, String securityPersonnelId) {
        this.logId = logId;
        this.securityPersonnelId = securityPersonnelId;
    }

    // Getters and Setters
    public String getLogId() { return logId; }
    public void setLogId(String logId) { this.logId = logId; }

    public String getSecurityPersonnelId() { return securityPersonnelId; }
    public void setSecurityPersonnelId(String securityPersonnelId) { this.securityPersonnelId = securityPersonnelId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Double getDuration() { return duration; }
    public void setDuration(Double duration) { this.duration = duration; }

    // Methods
    public Boolean logStartShift(String personnelId) {
        this.securityPersonnelId = personnelId;
        this.startTime = LocalDateTime.now();
        System.out.println("Shift started for security personnel: " + personnelId + " at " + startTime);
        return true;
    }

    public Boolean logEndShift(String personnelId) {
        this.endTime = LocalDateTime.now();
        calculateDuration();
        System.out.println("Shift ended for security personnel: " + personnelId + " at " + endTime);
        return true;
    }

    public Double calculateDuration() {
        if (startTime != null && endTime != null) {
            this.duration = (double) Duration.between(startTime, endTime).toMinutes() / 60.0;
            System.out.println("Shift duration: " + duration + " hours");
            return duration;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "ShiftLog{" +
                "logId='" + logId + '\'' +
                ", securityPersonnelId='" + securityPersonnelId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                '}';
    }
}