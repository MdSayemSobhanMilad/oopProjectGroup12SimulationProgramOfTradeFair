package cse213.todayjava.Ahad.UserStallOwner;

public class ReportingSales {

    private String productName;
    private int quantity;
    private double price;
    private String paymentMethod;


    public ReportingSales(String productName, int quantity, double price, String paymentMethod) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }


    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }


    public double getTotal() {
        return quantity * price;
    }


    public double calculateChange(double cashReceived) {
        double total = getTotal();
        return cashReceived - total;
    }


    public boolean isCashEnough(double cashReceived) {
        return cashReceived >= getTotal();
    }
}