package cse213.todayjava.Milad.UserSecurityPersonnel;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private String visitorId;
    private String ticketType;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private String status;

    // Constructors
    public Ticket() {}

    public Ticket(String ticketId, String visitorId, String ticketType,
                  LocalDateTime validFrom, LocalDateTime validTo) {
        this.ticketId = ticketId;
        this.visitorId = visitorId;
        this.ticketType = ticketType;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.status = "ACTIVE";
    }

    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    public String getVisitorId() { return visitorId; }
    public void setVisitorId(String visitorId) { this.visitorId = visitorId; }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    public LocalDateTime getValidFrom() { return validFrom; }
    public void setValidFrom(LocalDateTime validFrom) { this.validFrom = validFrom; }

    public LocalDateTime getValidTo() { return validTo; }
    public void setValidTo(LocalDateTime validTo) { this.validTo = validTo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods
    public Boolean validateTicket() {
        LocalDateTime now = LocalDateTime.now();
        boolean isValid = now.isAfter(validFrom) && now.isBefore(validTo) && "ACTIVE".equals(status);
        this.status = isValid ? "VALIDATED" : "INVALID";
        System.out.println("Ticket " + ticketId + " validation: " + (isValid ? "VALID" : "INVALID"));
        return isValid;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", visitorId='" + visitorId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", status='" + status + '\'' +
                '}';
    }
}
