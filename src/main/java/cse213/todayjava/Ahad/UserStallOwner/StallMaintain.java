package cse213.todayjava.Ahad.UserStallOwner;

public class StallMaintain {
    // Maintenance ticket properties
    private String ticketId;
    private String issue;
    private String assignedTo;
    private String status;

    // Constructor
    public StallMaintain(String ticketId, String issue, String assignedTo, String status) {
        this.ticketId = ticketId;
        this.issue = issue;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    // Getter methods
    public String getTicketId() {
        return ticketId;
    }

    public String getIssue() {
        return issue;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status (to update when fixed)
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
}