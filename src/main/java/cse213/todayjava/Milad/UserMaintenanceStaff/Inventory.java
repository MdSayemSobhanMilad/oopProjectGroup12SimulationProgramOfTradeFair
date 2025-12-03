package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDateTime;

public class Inventory {
    private String itemId;
    private String itemName;
//    private String category;
    private Integer currentStock;
//    private Integer minimumStockLevel;
    private String location;
    private LocalDateTime lastRestocked;

    public Inventory() {
    }

    public Inventory(String itemId, String itemName, Integer currentStock,
                      String location) {
        this.itemId = itemId;
        this.itemName = itemName;

        this.currentStock = currentStock;

        this.location = location;
        this.lastRestocked = LocalDateTime.now();
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



    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getLastRestocked() {
        return lastRestocked;
    }

    public void setLastRestocked(LocalDateTime lastRestocked) {
        this.lastRestocked = lastRestocked;
    }

    // Methods
    public boolean updateStockCount(Integer newCount) {
        this.currentStock = newCount;
        this.lastRestocked = LocalDateTime.now();
        System.out.println("Inventory item " + itemId + " stock updated to: " + newCount);
        return true;
    }

    public Integer checkStockLevel() {
        return currentStock;
    }

//    public boolean verifyMinimumStock() {
//        boolean isBelowMinimum = currentStock < minimumStockLevel;
//        if (isBelowMinimum) {
//            System.out.println("ALERT: Item " + itemName + " is below minimum stock level!");
//        }
//        return !isBelowMinimum;
//    }

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