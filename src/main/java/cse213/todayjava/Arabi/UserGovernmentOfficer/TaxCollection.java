package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class TaxCollection {
    private String totalTax;
    private String pending;
    private String status;

    
    public TaxCollection(String totalTax, String pending, String status) {
        this.totalTax = totalTax;
        this.pending = pending;
        this.status = status;
    }


    public TaxCollection() {
    }


    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return totalTax + " | " + pending + " | " + status;
    }
}