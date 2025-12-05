package cse213.todayjava.Ahad.UserStallOwner.ModelClasses;

import java.time.LocalDateTime;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StallMaintain {
    private StringProperty ticketId = new SimpleStringProperty();
    private StringProperty issueType = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private StringProperty assignedTo = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();
    private LocalDateTime reportedDate;
    private LocalDateTime fixedDate;
    private StringProperty stallId = new SimpleStringProperty();

    // Constructors
    public StallMaintain() {
        // Default constructor
    }

    public StallMaintain(String ticketId, String issueType, String description,
                         String assignedTo, String status, String stallId) {
        setTicketId(ticketId);
        setIssueType(issueType);
        setDescription(description);
        setAssignedTo(assignedTo);
        setStatus(status);
        setStallId(stallId);
        this.reportedDate = LocalDateTime.now();
        this.fixedDate = null;
    }

    // Property getters for JavaFX binding
    public StringProperty ticketIdProperty() {
        return ticketId;
    }

    public StringProperty issueTypeProperty() {
        return issueType;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty assignedToProperty() {
        return assignedTo;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty stallIdProperty() {
        return stallId;
    }

    // Regular getters
    public String getTicketId() {
        return ticketId.get();
    }

    public String getIssueType() {
        return issueType.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getAssignedTo() {
        return assignedTo.get();
    }

    public String getStatus() {
        return status.get();
    }

    public LocalDateTime getReportedDate() {
        return reportedDate;
    }

    public LocalDateTime getFixedDate() {
        return fixedDate;
    }

    public String getStallId() {
        return stallId.get();
    }

    // Setters
    public void setTicketId(String ticketId) {
        this.ticketId.set(ticketId);
    }

    public void setIssueType(String issueType) {
        this.issueType.set(issueType);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo.set(assignedTo);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public void setReportedDate(LocalDateTime reportedDate) {
        this.reportedDate = reportedDate;
    }

    public void setFixedDate(LocalDateTime fixedDate) {
        this.fixedDate = fixedDate;
    }

    public void setStallId(String stallId) {
        this.stallId.set(stallId);
    }

    @Override
    public String toString() {
        return getTicketId() + " - " + getIssueType() + " (" + getStatus() + ")";
    }
}