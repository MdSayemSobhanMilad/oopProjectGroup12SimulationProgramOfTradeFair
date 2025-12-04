package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Inventory {
    private String itemId;
    private String itemName;
    private int currentStock;
    private String location;
    private LocalDate lastRestocked;

    public Inventory() {
    }

    public Inventory(String itemId, String itemName, int currentStock, String location, LocalDate lastRestocked) {
        this.itemId = itemId;
        this.itemName = itemName;

        this.currentStock = currentStock;

        this.location = location;
        this.lastRestocked = lastRestocked;
    }

    // Getters and Setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getLastRestocked() {
        return lastRestocked;
    }

    public void setLastRestocked(LocalDate lastRestocked) {
        this.lastRestocked = lastRestocked;
    }



    @Override
    public String toString() {
        return "Inventory{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", currentStock=" + currentStock +
                ", location='" + location + '\'' +
                ", lastRestocked=" + lastRestocked +
                '}';
    }
}