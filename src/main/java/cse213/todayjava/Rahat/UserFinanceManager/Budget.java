package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

// ==================== BUDGET MANAGEMENT ====================

// Budget Class
public class Budget {
    private String budgetId;
    private String category; // "STAFF", "SECURITY", "MARKETING", "OPERATIONS"
    private Double allocatedAmount;
    private Double utilizedAmount;
    private Date fiscalYear;
    private List<Expense> expenses;

    public Budget(String budgetId, String category, Double allocatedAmount, Date fiscalYear) {
        this.budgetId = budgetId;
        this.category = category;
        this.allocatedAmount = allocatedAmount;
        this.utilizedAmount = 0.0;
        this.fiscalYear = fiscalYear;
        this.expenses = new ArrayList<>();
    }

    public double calculateRemainingBalance() {
        double remaining = allocatedAmount - utilizedAmount;
        System.out.println("Budget " + category + ": Allocated $" + allocatedAmount
                + ", Utilized $" + utilizedAmount + ", Remaining $" + remaining);
        return remaining;
    }

    public boolean validateExpenseLimit() {
        if (utilizedAmount > allocatedAmount) {
            System.out.println("WARNING: Budget exceeded for category: " + category);
            return false;
        }
        System.out.println("Budget within limits for category: " + category);
        return true;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        utilizedAmount += expense.getAmount();
    }

    // Getters and Setters
    public String getBudgetId() { return budgetId; }
    public void setBudgetId(String budgetId) { this.budgetId = budgetId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getAllocatedAmount() { return allocatedAmount; }
    public void setAllocatedAmount(Double allocatedAmount) { this.allocatedAmount = allocatedAmount; }

    public Double getUtilizedAmount() { return utilizedAmount; }
    public void setUtilizedAmount(Double utilizedAmount) { this.utilizedAmount = utilizedAmount; }

    public Date getFiscalYear() { return fiscalYear; }
    public void setFiscalYear(Date fiscalYear) { this.fiscalYear = fiscalYear; }

    public List<Expense> getExpenses() { return expenses; }
    public void setExpenses(List<Expense> expenses) { this.expenses = expenses; }
}
