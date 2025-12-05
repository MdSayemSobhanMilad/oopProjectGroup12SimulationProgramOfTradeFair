package cse213.todayjava.Ahad.UserStallOwner;

public class DiscountsApply {
    // Discount properties
    private String itemName;
    private double amount;
    private String discountType;

    // Constructor
    public DiscountsApply(String itemName, double amount, String discountType) {
        this.itemName = itemName;
        this.amount = amount;
        this.discountType = discountType;
    }

    // Getter methods
    public String getItemName() {
        return itemName;
    }

    public double getAmount() {
        return amount;
    }

    public String getDiscountType() {
        return discountType;
    }

    // Method to get amount as string with proper formatting
    public String getAmountString() {
        return "$" + String.format("%.2f", amount);
    }
}