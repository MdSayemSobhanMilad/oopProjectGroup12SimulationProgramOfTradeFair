package cse213.todayjava.Ahad.UserTicketCounterStaff;

import java.util.*;

public class TransactionLog {
    private String logId;
    private List<String> transactions;
    private Date shiftDate;

    public TransactionLog(String logId) {
        this.logId = logId;
        this.transactions = new ArrayList<>();
        this.shiftDate = new Date();
    }

    // Getters and Setters
    public String getLogId() { return logId; }
    public void setLogId(String logId) { this.logId = logId; }

    public List<String> getTransactions() { return transactions; }
    public void setTransactions(List<String> transactions) { this.transactions = transactions; }

    public Date getShiftDate() { return shiftDate; }
    public void setShiftDate(Date shiftDate) { this.shiftDate = shiftDate; }

    // Methods
    public void addTransaction(String transactionDetails) {
        transactions.add(new Date() + " - " + transactionDetails);
        System.out.println("Transaction added to log: " + transactionDetails);
    }

    public List<String> getShiftTransactions() {
        System.out.println("Retrieving all transactions for shift: " + shiftDate);
        return new ArrayList<>(transactions);
    }

    @Override
    public String toString() {
        return "TransactionLog{" +
                "logId='" + logId + '\'' +
                ", transactions=" + transactions.size() +
                ", shiftDate=" + shiftDate +
                '}';
    }
}