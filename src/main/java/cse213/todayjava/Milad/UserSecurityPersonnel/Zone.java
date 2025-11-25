package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;

public class Zone {
    private String zoneId;
    private String zoneName;
    private String description;
    private String status;
    private LocalDateTime lastCleaned;

    public Zone() {
    }

    public Zone(String zoneId, String zoneName, String description, String status, LocalDateTime lastCleaned) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.description = description;
        this.status = status;
        this.lastCleaned = lastCleaned;
    }

    
    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastCleaned() {
        return lastCleaned;
    }

    public void setLastCleaned(LocalDateTime lastCleaned) {
        this.lastCleaned = lastCleaned;
    }

    // Methods
    public Zone getZoneDetails() {
        return this;
    }

    public boolean updateCleaningStatus(String status) {
        this.status = status;
        this.lastCleaned = LocalDateTime.now();
        System.out.println("Zone " + zoneId + " cleaning status updated to: " + status);
        return true;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneId='" + zoneId + '\'' +
                ", zoneName='" + zoneName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", lastCleaned=" + lastCleaned +
                '}';
    }
}
