package cse213.todayjava.Ahad.UserTicketCounterStaff;

import java.util.Date;

public class TicketSale {
    private String saleId;
    private String ticketType;
    private Integer quantity;
    private Double totalPrice;
    private Date saleDate;

    public TicketSale(String saleId, String ticketType, Integer quantity) {
        this.saleId = saleId;
        this.ticketType = ticketType;
        this.quantity = quantity;
        this.saleDate = new Date();
        this.totalPrice = calculateTotal();
    }

    // Getters and Setters
    public String getSaleId() { return saleId; }
    public void setSaleId(String saleId) { this.saleId = saleId; }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public Date getSaleDate() { return saleDate; }
    public void setSaleDate(Date saleDate) { this.saleDate = saleDate; }

    // Methods
    public Double calculateTotal() {
        // Simulate price based on ticket type
        double unitPrice = 0.0;
        switch (ticketType.toLowerCase()) {
            case "adult": unitPrice = 50.0; break;
            case "child": unitPrice = 25.0; break;
            case "vip": unitPrice = 100.0; break;
            default: unitPrice = 40.0;
        }

        this.totalPrice = unitPrice * quantity;
        System.out.println("Total price calculated: $" + totalPrice + " for " + quantity + " " + ticketType + " tickets");
        return totalPrice;
    }

    public boolean reserveTickets() {
        System.out.println(quantity + " " + ticketType + " tickets reserved. Awaiting payment.");
        return true;
    }

    @Override
    public String toString() {
        return "TicketSale{" +
                "saleId='" + saleId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", saleDate=" + saleDate +
                '}';
    }
}
