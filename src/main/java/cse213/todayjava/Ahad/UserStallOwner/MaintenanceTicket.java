package cse213.todayjava.Ahad.UserStallOwner;

public class MaintenanceTicket {
    private String ticketId;
    private String issueDescription;
    private String status;

    public MaintenanceTicket(String ticketId, String issueDescription, String status) {
        this.ticketId = ticketId;
        this.issueDescription = issueDescription;
        this.status = status;
    }

    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    public String getIssueDescription() { return issueDescription; }
    public void setIssueDescription(String issueDescription) { this.issueDescription = issueDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods
    public void submitTicket() {
        this.status = "Submitted";
        System.out.println("Maintenance ticket submitted: " + issueDescription);
    }

    public void assignStaff(String staffId) {
        this.status = "Assigned to " + staffId;
        System.out.println("Ticket assigned to staff: " + staffId);
    }

    public void markResolved() {
        this.status = "Resolved";
        System.out.println("Maintenance ticket resolved: " + ticketId);
    }

    @Override
    public String toString() {
        return "MaintenanceTicket{" +
                "ticketId='" + ticketId + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
