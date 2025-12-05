package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class TaxCollection {
    private double totalTax;
    private double pending;
    private String status;

    // Constructor
    public TaxCollection(double totalTax, double pending, String status) {
        this.totalTax = totalTax;
        this.pending = pending;
        this.status = status;
    }

    // Empty constructor
    public TaxCollection() {
    }

    // Getters and Setters
    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getPending() {
        return pending;
    }

    public void setPending(double pending) {
        this.pending = pending;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "TaxCollection{" +
                "totalTax=" + totalTax +
                ", pending=" + pending +
                ", status='" + status + '\'' +
                '}';
    }
}