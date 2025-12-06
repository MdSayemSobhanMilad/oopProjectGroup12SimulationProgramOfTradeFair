package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class TicketingStart {
    private String loginStatus;
    private String databaseStatus;
    private String dailySetupStatus;
    private String counterStatus;
    private String firstTicket;

    public TicketingStart() {
        this.loginStatus = "Not Checked";
        this.databaseStatus = "Not Connected";
        this.dailySetupStatus = "Not Prepared";
        this.counterStatus = "Closed";
        this.firstTicket = "TKT-000";
    }

    public void startSystem() {
        loginStatus = "Staff Logged In";
        databaseStatus = "Connected";
        dailySetupStatus = "Records Ready";
        counterStatus = "Open";
        firstTicket = "TKT-001";
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public String getDailySetupStatus() {
        return dailySetupStatus;
    }

    public String getCounterStatus() {
        return counterStatus;
    }

    public String getFirstTicket() {
        return firstTicket;
    }

    public boolean isSystemReady() {
        return counterStatus.equals("Open");
    }
}
