package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;

// Transaction Class
class Transaction {
    private String transactionId;
    private String type; // "INCOME", "EXPENSE", "REFUND"
    private Double amount;
    private Date date;
    private String status; // "PENDING", "COMPLETED", "FAILED"
    private String payerId;
    private String payeeId;

    public Transaction(String transactionId, String type, Double amount, Date date) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.status = "PENDING";
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }
}
