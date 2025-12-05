package cse213.todayjava.Ahad.UserStallOwner;

import java.time.LocalDateTime;

public class Stall {
    private String stallName;
    private String stallNumber;
    private String stallLocation;
    private int staffCount;
    private String shiftTime;
    // Setup Information (Checkboxes)
    private boolean tablesReady;
    private boolean shelvesOrganized;
    private boolean lightingAdequate;
    private boolean powerConnected;
    private boolean posSystemReady;

    // Additional Notes (from TextArea)
    private String additionalNotes;

    // System Fields
    private LocalDateTime preparationTime;
    private boolean isReadyForCustomers;
    private String preparedBy;

    // Constructor
    public Stall() {
        this.preparationTime = LocalDateTime.now();
        this.isReadyForCustomers = false;
    }

    // Constructor with parameters
    public Stall(String stallName, String stallNumber, String stallLocation,
                            int staffCount, String shiftTime, String additionalNotes) {
        this();
        this.stallName = stallName;
        this.stallNumber = stallNumber;
        this.stallLocation = stallLocation;
        this.staffCount = staffCount;
        this.shiftTime = shiftTime;
        this.additionalNotes = additionalNotes;
    }




    // Getters and Setters
    public String getStallName() { return stallName; }
    public void setStallName(String stallName) { this.stallName = stallName; }

    public String getStallNumber() { return stallNumber; }
    public void setStallNumber(String stallNumber) { this.stallNumber = stallNumber; }

    public String getStallLocation() { return stallLocation; }
    public void setStallLocation(String stallLocation) { this.stallLocation = stallLocation; }

    public int getStaffCount() { return staffCount; }
    public void setStaffCount(int staffCount) { this.staffCount = staffCount; }

    public String getShiftTime() { return shiftTime; }
    public void setShiftTime(String shiftTime) { this.shiftTime = shiftTime; }

    public boolean isTablesReady() { return tablesReady; }
    public void setTablesReady(boolean tablesReady) { this.tablesReady = tablesReady; }

    public boolean isShelvesOrganized() { return shelvesOrganized; }
    public void setShelvesOrganized(boolean shelvesOrganized) { this.shelvesOrganized = shelvesOrganized; }

    public boolean isLightingAdequate() { return lightingAdequate; }
    public void setLightingAdequate(boolean lightingAdequate) { this.lightingAdequate = lightingAdequate; }

    public boolean isPowerConnected() { return powerConnected; }
    public void setPowerConnected(boolean powerConnected) { this.powerConnected = powerConnected; }

    public boolean isPosSystemReady() { return posSystemReady; }
    public void setPosSystemReady(boolean posSystemReady) { this.posSystemReady = posSystemReady; }

    // TextArea Content Getter/Setter
    public String getAdditionalNotes() { return additionalNotes; }
    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public LocalDateTime getPreparationTime() { return preparationTime; }
    public void setPreparationTime(LocalDateTime preparationTime) { this.preparationTime = preparationTime; }

    public boolean isReadyForCustomers() { return isReadyForCustomers; }
    public void setReadyForCustomers(boolean readyForCustomers) {
        this.isReadyForCustomers = readyForCustomers;
    }

    public String getPreparedBy() { return preparedBy; }
    public void setPreparedBy(String preparedBy) { this.preparedBy = preparedBy; }

    // Validation Methods
    public boolean isLocationComplete() {
        return stallName != null && !stallName.trim().isEmpty() &&
                stallNumber != null && !stallNumber.trim().isEmpty() &&
                stallLocation != null && !stallLocation.trim().isEmpty();
    }

    public boolean isStaffInfoComplete() {
        return staffCount > 0 && shiftTime != null && !shiftTime.trim().isEmpty();
    }

    public boolean isSetupComplete() {
        return tablesReady && shelvesOrganized && lightingAdequate && powerConnected && posSystemReady;
    }

    public boolean isAllRequiredFieldsComplete() {
        return isLocationComplete() && isStaffInfoComplete() && isSetupComplete();
    }
    // TextArea-specific methods
    public boolean hasAdditionalNotes() {
        return additionalNotes != null && !additionalNotes.trim().isEmpty();
    }

    public int getNotesLength() {
        return additionalNotes != null ? additionalNotes.length() : 0;
    }

    public String getNotesSummary() {
        if (additionalNotes == null || additionalNotes.isEmpty()) {
            return "No additional notes";
        }

        if (additionalNotes.length() <= 50) {
            return additionalNotes;
        }

        return additionalNotes.substring(0, 50) + "...";
    }


    // To String
    @Override
    public String toString() {
        return "StallPreparation{" +
                "stallName='" + stallName + '\'' +
                ", stallNumber='" + stallNumber + '\'' +
                ", stallLocation='" + stallLocation + '\'' +
                ", staffCount=" + staffCount +
                ", shiftTime='" + shiftTime + '\'' +
                ", additionalNotes='" + getNotesSummary() + '\'' +
                ", isReady=" + isReadyForCustomers +
                ", preparedAt=" + preparationTime +
                '}';
    }

    // Create from form data
    public static Stall createFromForm(String stallName, String stallNumber,
                                                  String stallLocation, String staffCountStr,
                                                  String shiftTime, String additionalNotes,
                                                  boolean tables, boolean shelves,
                                                  boolean lighting, boolean power, boolean pos) {
        Stall stall = new Stall();

        stall.setStallName(stallName);
        stall.setStallNumber(stallNumber);
        stall.setStallLocation(stallLocation);

        try {
            stall.setStaffCount(Integer.parseInt(staffCountStr));
        } catch (NumberFormatException e) {
            stall.setStaffCount(1); // default value
        }

        stall.setShiftTime(shiftTime);
        stall.setAdditionalNotes(additionalNotes);

        stall.setTablesReady(tables);
        stall.setShelvesOrganized(shelves);
        stall.setLightingAdequate(lighting);
        stall.setPowerConnected(power);
        stall.setPosSystemReady(pos);

        return stall;
    }
}
