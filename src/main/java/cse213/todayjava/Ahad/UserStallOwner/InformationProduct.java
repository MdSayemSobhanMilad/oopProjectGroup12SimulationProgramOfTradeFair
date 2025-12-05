package cse213.todayjava.Ahad.UserStallOwner;

public class InformationProduct {
    // Product properties
    private String productName;
    private double price;
    private String category;
    private String description;
    private String stockStatus;
    private String features;

    // Constructor
    public InformationProduct(String productName, double price, String category,
                              String description, String stockStatus, String features) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.description = description;
        this.stockStatus = stockStatus;
        this.features = features;
    }

    // Getter methods
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public String getFeatures() {
        return features;
    }

    // Method to get price as string with $ sign
    public String getPriceString() {
        return "$" + String.format("%.2f", price);
    }
}