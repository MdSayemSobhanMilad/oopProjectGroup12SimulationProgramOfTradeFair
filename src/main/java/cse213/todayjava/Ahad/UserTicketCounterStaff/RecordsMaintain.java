package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class RecordsMaintain {
    private double totalSales;
    private int totalTickets;

    public RecordsMaintain() {
        totalSales = 0.0;
        totalTickets = 0;
    }

    public void addSale(String type, int quantity, double price) {
        totalSales += (quantity * price);
        totalTickets += quantity;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void reset() {
        totalSales = 0.0;
        totalTickets = 0;
    }

    public String getSummary() {
        String summary = "=== REPORT SUMMARY ===\n";
        summary += "Total Tickets: " + totalTickets + "\n";
        summary += "Total Sales: $" + String.format("%.2f", totalSales) + "\n";

        if (totalTickets > 0) {
            double avg = totalSales / totalTickets;
            summary += "Average Price: $" + String.format("%.2f", avg);
        }

        return summary;
    }
}