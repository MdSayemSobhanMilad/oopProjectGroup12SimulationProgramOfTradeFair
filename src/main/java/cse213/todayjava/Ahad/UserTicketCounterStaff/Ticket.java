package cse213.todayjava.Ahad.UserTicketCounterStaff;

import java.util.UUID;

public class Ticket {
    private String ticketId;
    private String ticketType;
    private Double price;
    private String status;
    private String uniqueCode;

    public Ticket(String ticketId, String ticketType, Double price) {
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.price = price;
        this.status = "Available";
        this.uniqueCode = generateCode();
    }

    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getUniqueCode() { return uniqueCode; }
    public void setUniqueCode(String uniqueCode) { this.uniqueCode = uniqueCode; }

    // Methods
    public void createTicket(String ticketType, Double price) {
        this.ticketType = ticketType;
        this.price = price;
        this.status = "Available";
        this.uniqueCode = generateCode();
        System.out.println("Ticket created: " + ticketType + " - $" + price);
    }

    public void markAsSold() {
        this.status = "Sold";
        System.out.println("Ticket marked as sold: " + ticketId);
    }

    public String generateCode() {
        this.uniqueCode = "TICKET_" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        System.out.println("Unique ticket code generated: " + uniqueCode);
        return uniqueCode;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", uniqueCode='" + uniqueCode + '\'' +
                '}';
    }
}
