package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;
import java.util.Map;

public class Watchlist {
    private String entryId;
    private String personName;
    private String reason;
    private String addedBy;
    private LocalDateTime dateAdded;
    private String status;

    // Constructors
    public Watchlist() {}

    public Watchlist(String entryId, String personName, String reason, String addedBy) {
        this.entryId = entryId;
        this.personName = personName;
        this.reason = reason;
        this.addedBy = addedBy;
        this.dateAdded = LocalDateTime.now();
        this.status = "ACTIVE";
    }

    // Getters and Setters
    public String getEntryId() { return entryId; }
    public void setEntryId(String entryId) { this.entryId = entryId; }

    public String getPersonName() { return personName; }
    public void setPersonName(String personName) { this.personName = personName; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getAddedBy() { return addedBy; }
    public void setAddedBy(String addedBy) { this.addedBy = addedBy; }

    public LocalDateTime getDateAdded() { return dateAdded; }
    public void setDateAdded(LocalDateTime dateAdded) { this.dateAdded = dateAdded; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods
    public Boolean addEntry(Map<String, String> personDetails) {
        if (personDetails != null) {
            this.personName = personDetails.get("name");
            this.reason = personDetails.get("reason");
            System.out.println("Added " + personName + " to watchlist. Reason: " + reason);
            return true;
        }
        return false;
    }

    public Boolean removeEntry(String entryId) {
        if (this.entryId.equals(entryId)) {
            this.status = "REMOVED";
            System.out.println("Removed entry " + entryId + " from watchlist");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Watchlist{" +
                "entryId='" + entryId + '\'' +
                ", personName='" + personName + '\'' +
                ", reason='" + reason + '\'' +
                ", addedBy='" + addedBy + '\'' +
                ", dateAdded=" + dateAdded +
                ", status='" + status + '\'' +
                '}';
    }
}
