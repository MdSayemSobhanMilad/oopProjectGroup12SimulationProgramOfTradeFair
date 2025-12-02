package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class Product {
    private String productId;
    private String name;
    private String category;
    private Boolean isCompliant;

    // Constructor
    public Product(String productId, String name, String category, Boolean isCompliant) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.isCompliant = isCompliant;
    }

    // Default constructor
    public Product() {
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsCompliant() {
        return isCompliant;
    }

    public void setIsCompliant(Boolean isCompliant) {
        this.isCompliant = isCompliant;
    }

    // toString method
    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", isCompliant=" + isCompliant +
                '}';
    }
}
