package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;

// ==================== BUDGET MANAGEMENT ====================

// Expense Class
class Expense {
    private String expenseId;
    private String category;
    private Double amount;
    private Date expenseDate;
    private String description;

    public Expense(String expenseId, String category, Double amount, Date expenseDate) {
        this.expenseId = expenseId;
        this.category = category;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    // Getters and Setters
    public String getExpenseId() { return expenseId; }
    public void setExpenseId(String expenseId) { this.expenseId = expenseId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Date getExpenseDate() { return expenseDate; }
    public void setExpenseDate(Date expenseDate) { this.expenseDate = expenseDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}