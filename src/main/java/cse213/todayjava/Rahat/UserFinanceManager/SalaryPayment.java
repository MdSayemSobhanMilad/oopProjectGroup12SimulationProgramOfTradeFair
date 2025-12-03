package cse213.todayjava.Rahat.UserFinanceManager;

import java.util.Date;

// ==================== SALARY MANAGEMENT ====================

// SalaryPayment Class
class SalaryPayment {
    private String salaryId;
    private Date paymentDate;
    private Double amount;
    private String status; // "PENDING", "PAID", "FAILED"
    private Employee employee;

    public SalaryPayment(String salaryId, Employee employee, Date paymentDate) {
        this.salaryId = salaryId;
        this.employee = employee;
        this.paymentDate = paymentDate;
        this.amount = employee.getSalary();
        this.status = "PENDING";
    }

    public void processSalaryPayment() {
        System.out.println("Processing salary payment for: " + employee.getName());
        this.status = "PROCESSING";
        // Salary payment processing logic
        this.status = "PAID";
        System.out.println("Salary payment completed: " + salaryId);
    }

    public void generateDisbursementReport() {
        System.out.println("=== Salary Disbursement Report ===");
        System.out.println("Payment ID: " + salaryId);
        System.out.println("Employee: " + employee.getName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Status: " + status);
    }

    // Getters and Setters
    public String getSalaryId() { return salaryId; }
    public void setSalaryId(String salaryId) { this.salaryId = salaryId; }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
