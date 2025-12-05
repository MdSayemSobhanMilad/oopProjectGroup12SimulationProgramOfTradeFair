package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class TicketingConclude {
    private int ticketsSold;
    private double totalRevenue;
    private String shift;
    private String ticketType;

    public TicketingConclude() {
        ticketsSold = 0;
        totalRevenue = 0.0;
        shift = "";
        ticketType = "";
    }

    public void addSale(String shift, String ticketType, int tickets, double revenue) {
        this.shift = shift;
        this.ticketType = ticketType;
        this.ticketsSold = tickets;
        this.totalRevenue = revenue;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public String getShift() {
        return shift;
    }

    public String getTicketType() {
        return ticketType;
    }
}