package cse213.todayjava.Ahad.UserStallOwner;
public class ProductCatalog {
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public ProductCatalog() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    // Constructor with parameters
    public ProductCatalog(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    // toString method for display
    @Override
    public String toString() {
        return name + " - $" + price + " (Qty: " + quantity + ")";
    }

    // Validation methods
    public boolean isValid() {
        return name != null && !name.trim().isEmpty() && price >= 0 && quantity >= 0;
    }

    public boolean isInStock() {
        return quantity > 0;
    }
}