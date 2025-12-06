package cse213.todayjava.Rahat.UserFinanceManager;

// Vendor Class
public class Vendor {
    private String vendorId;
    private String name;
    private String contactInfo;
    private String category; // "FOOD", "SECURITY", "EQUIPMENT", "ENTERTAINMENT"

    public Vendor(String vendorId, String name, String contactInfo, String category) {
        this.vendorId = vendorId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.category = category;
    }

    // Getters and Setters
    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
