package cse213.todayjava.Ahad.UserStallOwner;

import java.util.List;

public class POSSystem {
    private String transactionId;
    private Double totalAmount;

    public POSSystem(String transactionId) {
        this.transactionId = transactionId;
        this.totalAmount = 0.0;
    }

    // Getters and Setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    // Methods
    public Double calculateTotal(List<Product> products, Discount discount) {
        totalAmount = 0.0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }

        if (discount != null) {
            totalAmount = discount.applyDiscount(totalAmount);
        }

        System.out.println("Total amount calculated: $" + totalAmount);
        return totalAmount;
    }

    public boolean processPayment(String paymentMethod, Double amount) {
        boolean paymentSuccess = amount >= totalAmount;
        if (paymentSuccess) {
            System.out.println("Payment processed successfully via " + paymentMethod);
            if (amount > totalAmount) {
                System.out.println("Change to return: $" + (amount - totalAmount));
            }
        } else {
            System.out.println("Payment failed: Insufficient amount.");
        }
        return paymentSuccess;
    }

    public SalesReport completeSale() {
        System.out.println("Sale completed successfully. Transaction ID: " + transactionId);
        return new SalesReport("REP_" + transactionId, totalAmount);
    }

    @Override
    public String toString() {
        return "POSSystem{" +
                "transactionId='" + transactionId + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
