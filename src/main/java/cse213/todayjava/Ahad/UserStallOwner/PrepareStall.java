package cse213.todayjava.Ahad.UserStallOwner;

public class PrepareStall {
    // Stall details
    private String stallName;
    private String stallNumber;
    private String location;

    // Staff details
    private int staffCount;
    private String shiftTime;

    // Setup checklist
    private boolean tablesReady;
    private boolean shelvesOrganized;
    private boolean lightingAdequate;
    private boolean powerConnected;

    // Constructor
    public PrepareStall() {
        // Initialize with empty values
        this.stallName = "";
        this.stallNumber = "";
        this.location = "";
        this.staffCount = 0;
        this.shiftTime = "";
    }

    // Setter methods
    public void setStallName(String name) {
        this.stallName = name;
    }

    public void setStallNumber(String number) {
        this.stallNumber = number;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStaffCount(int count) {
        this.staffCount = count;
    }

    public void setShiftTime(String time) {
        this.shiftTime = time;
    }

    public void setTablesReady(boolean ready) {
        this.tablesReady = ready;
    }

    public void setShelvesOrganized(boolean organized) {
        this.shelvesOrganized = organized;
    }

    public void setLightingAdequate(boolean adequate) {
        this.lightingAdequate = adequate;
    }

    public void setPowerConnected(boolean connected) {
        this.powerConnected = connected;
    }

    // Getter methods
    public String getStallName() {
        return stallName;
    }

    public String getStallNumber() {
        return stallNumber;
    }

    public String getLocation() {
        return location;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public boolean isTablesReady() {
        return tablesReady;
    }

    public boolean isShelvesOrganized() {
        return shelvesOrganized;
    }

    public boolean isLightingAdequate() {
        return lightingAdequate;
    }

    public boolean isPowerConnected() {
        return powerConnected;
    }

    // Method to get all details as a string
    public String getAllDetails() {
        String details = "=== STALL PREPARATION DETAILS ===\n\n";

        // Stall information
        details += "STALL INFORMATION:\n";
        details += "Stall Name: " + stallName + "\n";
        details += "Stall Number: " + stallNumber + "\n";
        details += "Location: " + location + "\n\n";

        // Staff information
        details += "STAFF INFORMATION:\n";
        details += "Number of Staff: " + staffCount + "\n";
        details += "Shift Time: " + shiftTime + "\n\n";

        // Setup checklist
        details += "SETUP CHECKLIST:\n";
        details += "✓ Tables Ready: " + (tablesReady ? "YES" : "NO") + "\n";
        details += "✓ Shelves Organized: " + (shelvesOrganized ? "YES" : "NO") + "\n";
        details += "✓ Lighting Adequate: " + (lightingAdequate ? "YES" : "NO") + "\n";
        details += "✓ Power Connected: " + (powerConnected ? "YES" : "NO") + "\n";

        return details;
    }
}