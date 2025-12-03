package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

// ==================== REVENUE MANAGEMENT ====================

// RevenueRecord Class
public class RevenueRecord {
    private String recordId;
    private String sourceType; // "TICKET_SALES", "EXHIBITOR_FEES", "SPONSORSHIPS"
    private Double amount;
    private Date transactionDate;
    private String description;
    private List<Transaction> transactions;

    public RevenueRecord(String recordId, String sourceType, Double amount, Date transactionDate) {
        this.recordId = recordId;
        this.sourceType = sourceType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactions = new ArrayList<>();
    }

    public double calculateTotalRevenue() {
        double total = amount;
        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    public void applyFilters(String filterType) {
        System.out.println("Applying " + filterType + " filters to revenue records");
        // Filter implementation logic
    }

    // Getters and Setters
    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getSourceType() { return sourceType; }
    public void setSourceType(String sourceType) { this.sourceType = sourceType; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Date getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
}
