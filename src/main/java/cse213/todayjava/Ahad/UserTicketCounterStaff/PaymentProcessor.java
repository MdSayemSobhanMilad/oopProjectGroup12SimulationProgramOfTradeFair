package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class PaymentProcessor {
    private String paymentId;
    private String paymentMethod;
    private Double amount;
    private String status;

    public PaymentProcessor(String paymentId) {
        this.paymentId = paymentId;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods
    public boolean processPayment(String paymentMethod, Double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;

        boolean success = validatePayment();
        this.status = success ? "Success" : "Failed";

        System.out.println("Payment processed via " + paymentMethod + ": " +
                (success ? "SUCCESS" : "FAILED"));
        return success;
    }

    public boolean validatePayment() {
        boolean isValid = amount > 0 &&
                (paymentMethod.equals("cash") ||
                        paymentMethod.equals("card") ||
                        paymentMethod.equals("mobile money"));
        System.out.println("Payment validation: " + (isValid ? "VALID" : "INVALID"));
        return isValid;
    }

    public void generateReceipt() {
        System.out.println("=== DIGITAL RECEIPT ===");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Method: " + paymentMethod);
        System.out.println("Amount: $" + amount);
        System.out.println("Status: " + status);
        System.out.println("Date: " + new java.util.Date());
    }

    @Override
    public String toString() {
        return "PaymentProcessor{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}