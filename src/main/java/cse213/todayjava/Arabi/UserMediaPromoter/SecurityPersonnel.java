package cse213.todayjava.Arabi.UserMediaPromoter;

public class SecurityPersonnel {
    private String securityId;
    private String shift;
    private String zone;

    // Constructor
    public SecurityPersonnel(String securityId, String shift, String zone) {
        this.securityId = securityId;
        this.shift = shift;
        this.zone = zone;
    }

    // Default constructor
    public SecurityPersonnel() {
    }

    // Getters and Setters
    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    // Methods from UML
    public void patrolZone() {
        System.out.println("Security personnel " + securityId + " patrolling zone: " + zone);
    }

    public void validateTicket() {
        System.out.println("Security personnel " + securityId + " validating tickets");
    }

    public void respondToAlert() {
        System.out.println("Security personnel " + securityId + " responding to alert");
    }

    // toString method
    @Override
    public String toString() {
        return "SecurityPersonnel{" +
                "securityId='" + securityId + '\'' +
                ", shift='" + shift + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}