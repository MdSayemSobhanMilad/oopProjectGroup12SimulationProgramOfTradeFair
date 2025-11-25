package cse213.todayjava.Ahad.UserStallOwner;

public class Discount {
    private String discountId;
    private String type;
    private Double value;
    private boolean isActive;

    public Discount(String discountId, String type, Double value, boolean isActive) {
        this.discountId = discountId;
        this.type = type;
        this.value = value;
        this.isActive = isActive;
    }

    // Getters and Setters
    public String getDiscountId() { return discountId; }
    public void setDiscountId(String discountId) { this.discountId = discountId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    // Methods
    public void createDiscount(String type, Double value) {
        this.type = type;
        this.value = value;
        this.isActive = true;
        System.out.println("Discount created: " + type + " - " + value);
    }

    public boolean validateDiscount() {
        boolean isValid = value > 0 && (type.equals("percentage") || type.equals("fixed"));
        System.out.println("Discount validation: " + (isValid ? "VALID" : "INVALID"));
        return isValid;
    }

    public Double applyDiscount(Double originalPrice) {
        if (!isActive || !validateDiscount()) {
            return originalPrice;
        }

        double discountedPrice;
        if (type.equals("percentage")) {
            discountedPrice = originalPrice * (1 - value / 100);
        } else {
            discountedPrice = originalPrice - value;
        }

        System.out.println("Discount applied. Original: $" + originalPrice + ", Discounted: $" + discountedPrice);
        return Math.max(discountedPrice, 0);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId='" + discountId + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", isActive=" + isActive +
                '}';
    }
}
