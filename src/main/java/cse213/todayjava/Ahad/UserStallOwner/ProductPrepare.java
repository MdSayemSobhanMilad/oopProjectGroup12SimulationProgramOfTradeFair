package cse213.todayjava.Ahad.UserStallOwner;

import java.time.LocalDateTime;

public class ProductPrepare {
    // Location Information
    private String stallName;
    private String stallNumber;
    private String stallLocation;

    // Staff Information
    private String staffCount;  // Using String to match your TextField
    private String shiftTime;

    // Setup Information (CheckBox states)
    private boolean displayTablesReady;
    private boolean shelvesOrganized;
    private boolean lightingAdequate;
    private boolean powerConnected;

    // Additional Notes
    private String additionalNotes;

    // System Information
    private LocalDateTime preparationTime;
    private boolean isReadyForCustomers;
    private String statusMessage;

    // Constructor
    public ProductPrepare() {
        this.preparationTime = LocalDateTime.now();
        this.isReadyForCustomers = false;
        this.statusMessage = "Preparation Not Submitted";
    }

    // Getters and Setters
    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getStallNumber() {
        return stallNumber;
    }

    public void setStallNumber(String stallNumber) {
        this.stallNumber = stallNumber;
    }

    public String getStallLocation() {
        return stallLocation;
    }

    public void setStallLocation(String stallLocation) {
        this.stallLocation = stallLocation;
    }

    public String getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(String staffCount) {
        this.staffCount = staffCount;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public boolean isDisplayTablesReady() {
        return displayTablesReady;
    }

    public void setDisplayTablesReady(boolean displayTablesReady) {
        this.displayTablesReady = displayTablesReady;
    }

    public boolean isShelvesOrganized() {
        return shelvesOrganized;
    }

    public void setShelvesOrganized(boolean shelvesOrganized) {
        this.shelvesOrganized = shelvesOrganized;
    }

    public boolean isLightingAdequate() {
        return lightingAdequate;
    }

    public void setLightingAdequate(boolean lightingAdequate) {
        this.lightingAdequate = lightingAdequate;
    }

    public boolean isPowerConnected() {
        return powerConnected;
    }

    public void setPowerConnected(boolean powerConnected) {
        this.powerConnected = powerConnected;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public LocalDateTime getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(LocalDateTime preparationTime) {
        this.preparationTime = preparationTime;
    }

    public boolean isReadyForCustomers() {
        return isReadyForCustomers;
    }

    public void setReadyForCustomers(boolean readyForCustomers) {
        isReadyForCustomers = readyForCustomers;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    // Method to populate from controller data
    public void populateFromForm(String stallName, String stallNumber, String stallLocation,
                                 String staffCount, String shiftTime,
                                 boolean tables, boolean shelves, boolean lighting, boolean power,
                                 String notes) {
        this.stallName = stallName;
        this.stallNumber = stallNumber;
        this.stallLocation = stallLocation;
        this.staffCount = staffCount;
        this.shiftTime = shiftTime;
        this.displayTablesReady = tables;
        this.shelvesOrganized = shelves;
        this.lightingAdequate = lighting;
        this.powerConnected = power;
        this.additionalNotes = notes;
    }

    // Generate summary for TextArea
    public String generateSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== STALL PREPARATION SUMMARY ===\n\n");

        summary.append("LOCATION INFORMATION:\n");
        summary.append("  Stall Name: ").append(stallName != null ? stallName : "Not Provided").append("\n");
        summary.append("  Stall Number: ").append(stallNumber != null ? stallNumber : "Not Provided").append("\n");
        summary.append("  Location: ").append(stallLocation != null ? stallLocation : "Not Provided").append("\n\n");

        summary.append("STAFF INFORMATION:\n");
        summary.append("  Number of Staff: ").append(staffCount != null ? staffCount : "0").append("\n");
        summary.append("  Shift Time: ").append(shiftTime != null ? shiftTime : "Not Provided").append("\n\n");

        summary.append("SETUP CHECKLIST:\n");
        summary.append("  ✓ Display Tables: ").append(displayTablesReady ? "READY" : "NOT READY").append("\n");
        summary.append("  ✓ Shelves: ").append(shelvesOrganized ? "ORGANIZED" : "NOT ORGANIZED").append("\n");
        summary.append("  ✓ Lighting: ").append(lightingAdequate ? "ADEQUATE" : "INADEQUATE").append("\n");
        summary.append("  ✓ Power: ").append(powerConnected ? "CONNECTED" : "NOT CONNECTED").append("\n\n");

        if (additionalNotes != null && !additionalNotes.trim().isEmpty()) {
            summary.append("ADDITIONAL NOTES:\n");
            summary.append(additionalNotes).append("\n\n");
        }

        summary.append("SYSTEM STATUS:\n");
        summary.append("  Preparation Time: ").append(preparationTime).append("\n");
        summary.append("  Ready for Customers: ").append(isReadyForCustomers ? "YES" : "NO").append("\n");
        summary.append("  Status: ").append(statusMessage).append("\n");

        return summary.toString();
    }

    // Validation methods
    public boolean validateForm() {
        boolean isValid = true;
        statusMessage = "";

        if (stallName == null || stallName.trim().isEmpty()) {
            statusMessage += "Stall Name is required. ";
            isValid = false;
        }

        if (stallNumber == null || stallNumber.trim().isEmpty()) {
            statusMessage += "Stall Number is required. ";
            isValid = false;
        }

        if (stallLocation == null || stallLocation.trim().isEmpty()) {
            statusMessage += "Location is required. ";
            isValid = false;
        }

        if (staffCount == null || staffCount.trim().isEmpty()) {
            statusMessage += "Staff Count is required. ";
            isValid = false;
        }

        if (shiftTime == null || shiftTime.trim().isEmpty()) {
            statusMessage += "Shift Time is required. ";
            isValid = false;
        }

        if (!displayTablesReady || !shelvesOrganized || !lightingAdequate || !powerConnected) {
            statusMessage += "All setup checks must be completed. ";
            isValid = false;
        }

        if (isValid) {
            statusMessage = "All information validated successfully!";
            isReadyForCustomers = true;
        }

        return isValid;
    }

    @Override
    public String toString() {
        return "ProductPrepare{" +
                "stallName='" + stallName + '\'' +
                ", stallNumber='" + stallNumber + '\'' +
                ", isReady=" + isReadyForCustomers +
                '}';
    }
}