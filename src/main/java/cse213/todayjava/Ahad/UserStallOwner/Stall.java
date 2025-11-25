package cse213.todayjava.Ahad.UserStallOwner;

public class Stall {
    private String stallId;
    private String location;
    private String status;

    public Stall(String stallId, String location, String status) {
        this.stallId = stallId;
        this.location = location;
        this.status = status;
    }

    // Getters and Setters
    public String getStallId() { return stallId; }
    public void setStallId(String stallId) { this.stallId = stallId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Methods
    public void updateDetails(String location, String status) {
        this.location = location;
        this.status = status;
        System.out.println("Stall details updated successfully.");
    }

    public boolean validateSetup() {
        boolean isValid = location != null && !location.isEmpty() && status != null;
        System.out.println("Stall setup validation: " + (isValid ? "PASSED" : "FAILED"));
        return isValid;
    }

    @Override
    public String toString() {
        return "Stall{" +
                "stallId='" + stallId + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}