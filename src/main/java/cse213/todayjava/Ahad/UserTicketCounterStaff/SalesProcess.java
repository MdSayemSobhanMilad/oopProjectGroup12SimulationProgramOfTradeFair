package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class SalesProcess {
    private String ticketType;
    private int quantity;
    private double priceEach;
    private double totalPrice;

    public SalesProcess() {
        this.quantity = 1;
        this.priceEach = 0.0;
        this.totalPrice = 0.0;
    }

    public SalesProcess(String ticketType, int quantity, double price) {
        this.ticketType = ticketType;
        this.quantity = quantity;
        this.priceEach = price;
        calculateTotal();
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotal();
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
        calculateTotal();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void calculateTotal() {
        totalPrice = priceEach * quantity;
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;
    }

    public String getDetails() {
        String details = "=== TICKET DETAILS ===\n";
        details += "Type: " + ticketType + "\n";
        details += "Quantity: " + quantity + "\n";
        details += "Price Each: $" + String.format("%.2f", priceEach) + "\n";
        details += "Total: $" + String.format("%.2f", totalPrice) + "\n";
        details += "====================";
        return details;
    }
}