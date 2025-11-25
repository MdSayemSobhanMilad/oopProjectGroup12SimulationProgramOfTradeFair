package cse213.todayjava.Ahad.UserTicketCounterStaff;

import java.util.Date;

public class TicketSystem {
    private String systemId;
    private String status;
    private Date currentDate;

    public TicketSystem(String systemId) {
        this.systemId = systemId;
        this.status = "Closed";
        this.currentDate = new Date();
    }

    // Getters and Setters
    public String getSystemId() { return systemId; }
    public void setSystemId(String systemId) { this.systemId = systemId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getCurrentDate() { return currentDate; }
    public void setCurrentDate(Date currentDate) { this.currentDate = currentDate; }

    // Methods
    public boolean openSystem() {
        this.status = "Open";
        System.out.println("Ticket system opened successfully. Status: " + status);
        return true;
    }

    public boolean checkDatabaseConnection() {
        boolean isConnected = true; // Simulate connection check
        System.out.println("Database connection: " + (isConnected ? "OK" : "FAILED"));
        return isConnected;
    }

    public void prepareDailySales() {
        System.out.println("Daily sales record prepared. First ticket number set.");
        System.out.println("Counter Open – Ready for Sales.");
    }

    @Override
    public String toString() {
        return "TicketSystem{" +
                "systemId='" + systemId + '\'' +
                ", status='" + status + '\'' +
                ", currentDate=" + currentDate +
                '}';
    }
}