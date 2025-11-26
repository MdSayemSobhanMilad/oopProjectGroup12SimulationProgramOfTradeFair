package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class CashManagement {
    private String cashId;
    private Double cashReceived;
    private Double changeGiven;
    private Double currentFloat;

    public CashManagement(String cashId, Double initialFloat) {
        this.cashId = cashId;
        this.currentFloat = initialFloat;
        this.cashReceived = 0.0;
        this.changeGiven = 0.0;
    }

    // Getters and Setters
    public String getCashId() { return cashId; }
    public void setCashId(String cashId) { this.cashId = cashId; }

    public Double getCashReceived() { return cashReceived; }
    public void setCashReceived(Double cashReceived) { this.cashReceived = cashReceived; }

    public Double getChangeGiven() { return changeGiven; }
    public void setChangeGiven(Double changeGiven) { this.changeGiven = changeGiven; }

    public Double getCurrentFloat() { return currentFloat; }
    public void setCurrentFloat(Double currentFloat) { this.currentFloat = currentFloat; }

    // Methods
    public Double calculateChange(Double amountDue, Double cashReceived) {
        this.cashReceived = cashReceived;
        this.changeGiven = cashReceived - amountDue;

        if (changeGiven < 0) {
            System.out.println("Insufficient cash received.");
            return -1.0;
        }

        System.out.println("Change calculated: $" + changeGiven);
        return changeGiven;
    }

    public void updateCashFloat() {
        this.currentFloat += cashReceived - changeGiven;
        System.out.println("Cash float updated. New float: $" + currentFloat);
    }

    @Override
    public String toString() {
        return "CashManagement{" +
                "cashId='" + cashId + '\'' +
                ", cashReceived=" + cashReceived +
                ", changeGiven=" + changeGiven +
                ", currentFloat=" + currentFloat +
                '}';
    }
}
