package cse213.todayjava.Ahad.UserStallOwner;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private String catalogId;
    private List<Product> products;

    public ProductCatalog(String catalogId) {
        this.catalogId = catalogId;
        this.products = new ArrayList<>();
    }

    // Getters and Setters
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    // Methods
    public Product searchProduct(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                System.out.println("Product found: " + product.getName());
                return product;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to catalog: " + product.getName());
    }

    public void editProduct(String productId, String newName, Double newPrice) {
        Product product = searchProduct(productId);
        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
            System.out.println("Product updated successfully.");
        }
    }

    @Override
    public String toString() {
        return "ProductCatalog{" +
                "catalogId='" + catalogId + '\'' +
                ", products=" + products.size() +
                '}';
    }
}