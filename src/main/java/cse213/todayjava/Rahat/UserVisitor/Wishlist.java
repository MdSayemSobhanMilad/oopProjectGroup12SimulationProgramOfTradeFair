package cse213.todayjava.Rahat.UserVisitor;

import java.io.Serializable;
import java.time.LocalDate;

public class Wishlist implements Serializable {
    private String ItemName;
    private int Price;
    private String ItemCategory ;

    public Wishlist(String itemName, int price, String itemCategory) {
        ItemName = itemName;
        Price = price;
        ItemCategory = itemCategory;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getItemCategory() {
        return ItemCategory;
    }

    public void setItemCategory(String itemCategory) {
        ItemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "ItemName='" + ItemName + '\'' +
                ", Price=" + Price +
                ", ItemCategory='" + ItemCategory + '\'' +
                '}';
    }
}
