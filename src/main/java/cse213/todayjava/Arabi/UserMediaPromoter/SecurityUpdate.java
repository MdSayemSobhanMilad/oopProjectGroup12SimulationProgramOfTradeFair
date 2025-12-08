package cse213.todayjava.Arabi.UserMediaPromoter;

import java.util.Date;

public class SecurityUpdate {
    private String updateId;
    private String type;
    private String description;
    private Date timestamp;
    private String priority;

<<<<<<< Updated upstream

=======
    // Constructor
>>>>>>> Stashed changes
    public SecurityUpdate(String updateId, String type, String description, Date timestamp, String priority) {
        this.updateId = updateId;
        this.type = type;
        this.description = description;
        this.timestamp = timestamp;
        this.priority = priority;
    }

<<<<<<< Updated upstream

    public SecurityUpdate() {
    }


=======
    // Default constructor
    public SecurityUpdate() {
    }

    // Getters and Setters
>>>>>>> Stashed changes
    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Methods from UML
    public void createUpdate() {
        System.out.println("Security update created: " + updateId);
    }

    public void broadcastAlert() {
        System.out.println("Broadcasting security alert: " + description + " [Priority: " + priority + "]");
    }

<<<<<<< Updated upstream

=======
    // toString method
>>>>>>> Stashed changes
    @Override
    public String toString() {
        return "SecurityUpdate{" +
                "updateId='" + updateId + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", priority='" + priority + '\'' +
                '}';
    }
}
