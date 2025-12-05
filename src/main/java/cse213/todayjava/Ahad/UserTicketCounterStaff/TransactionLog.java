package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class TransactionLog {
    private String paymentMethod;
    private double amount;
    private String time;
    private boolean isSuccessful;

    public TransactionLog() {
        this.time = java.time.LocalTime.now().toString().substring(0, 8);
    }

    public TransactionLog(String paymentMethod, double amount) {
        this();
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String generateReceipt() {
        String receipt = "=== RECEIPT ===\n";
        receipt += "Time: " + time + "\n";
        receipt += "Amount: $" + amount + "\n";
        receipt += "Payment: " + paymentMethod + "\n";
        receipt += "Status: SUCCESS\n";
        receipt += "Thank you!";
        return receipt;
    }
}