package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class CashflowManage {
    private double totalAmountDue;
    private double cashReceived;
    private double changeToGive;
    private double currentCash;
    private String status;

    public CashflowManage() {
        this.currentCash = 1000.00; // Starting cash float
        this.status = "Ready";
    }

    public CashflowManage(double totalAmountDue, double cashReceived) {
        this();
        this.totalAmountDue = totalAmountDue;
        this.cashReceived = cashReceived;
        calculateChange();
    }

    public void calculateChange() {
        if (cashReceived >= totalAmountDue) {
            changeToGive = cashReceived - totalAmountDue;
            changeToGive = Math.round(changeToGive * 100.0) / 100.0;
            status = "Change calculated";
        } else {
            changeToGive = 0.00;
            status = "Insufficient cash";
        }
    }

    public void completeTransaction() {
        if (changeToGive >= 0 && cashReceived >= totalAmountDue) {
            currentCash += totalAmountDue;
            currentCash = Math.round(currentCash * 100.0) / 100.0;
            status = "Transaction completed";
        }
    }

    public double getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public double getCashReceived() {
        return cashReceived;
    }

    public void setCashReceived(double cashReceived) {
        this.cashReceived = cashReceived;
        calculateChange();
    }

    public double getChangeToGive() {
        return changeToGive;
    }

    public double getCurrentCash() {
        return currentCash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionDetails() {
        String details = "=== CASH TRANSACTION ===\n";
        details += "Amount Due: $" + String.format("%.2f", totalAmountDue) + "\n";
        details += "Cash Received: $" + String.format("%.2f", cashReceived) + "\n";
        details += "Change Given: $" + String.format("%.2f", changeToGive) + "\n";
        details += "Current Cash Float: $" + String.format("%.2f", currentCash) + "\n";
        details += "Status: " + status + "\n";
        details += "========================";
        return details;
    }
}