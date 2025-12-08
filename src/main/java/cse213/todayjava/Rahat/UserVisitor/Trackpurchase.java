package cse213.todayjava.Rahat.UserVisitor;

import java.io.Serializable;
import java.time.LocalDate;

public class Trackpurchase implements Serializable {
    private String ProductName;
    private int Price;
    private String Category ;
    private LocalDate Purchasedate;

    public Trackpurchase(String productName, int price, String category, LocalDate purchasedate) {
        ProductName = productName;
        Price = price;
        Category = category;
        Purchasedate = purchasedate;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public LocalDate getPurchasedate() {
        return Purchasedate;
    }

    public void setPurchasedate(LocalDate purchasedate) {
        Purchasedate = purchasedate;
    }

    @Override
    public String toString() {
        return "Trackpurchase{" +
                "ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", Category='" + Category + '\'' +
                ", Purchasedate=" + Purchasedate +
                '}';
    }
}

