package cse213.todayjava.Ahad.UserStallOwner;

public class ProductManages {
    private String productName;
    private double price;
    private int quantity;

    // Constructor
    public ProductManages() {
        this.productName = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    // Constructor with parameters
    public ProductManages(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Validation method
    public boolean isValid() {
        return productName != null && !productName.trim().isEmpty() &&
                price >= 0 && quantity >= 0;
    }

    // Calculate total value
    public double getTotalValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return productName + " - $" + price + " (Qty: " + quantity + ")";
    }
}