package cse213.todayjava.Ahad.UserStallOwner;

public class SecurityDashboard {
    private String dashboardId;

    public SecurityDashboard(String dashboardId) {
        this.dashboardId = dashboardId;
    }

    // Getters and Setters
    public String getDashboardId() { return dashboardId; }
    public void setDashboardId(String dashboardId) { this.dashboardId = dashboardId; }

    // Methods
    public void displayRules() {
        System.out.println("=== SECURITY RULES ===");
        System.out.println("1. All visitors must wear ID badges");
        System.out.println("2. No unauthorized access to restricted areas");
        System.out.println("3. Report any suspicious activity immediately");
    }

    public boolean confirmGuidelines() {
        System.out.println("Security guidelines confirmed by stall owner.");
        return true;
    }

    public void reportIncident(String incidentDescription) {
        System.out.println("Incident reported: " + incidentDescription);
        System.out.println("Security team has been notified.");
    }

    @Override
    public String toString() {
        return "SecurityDashboard{" +
                "dashboardId='" + dashboardId + '\'' +
                '}';
    }
}