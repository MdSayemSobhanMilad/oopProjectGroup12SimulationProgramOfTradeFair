package cse213.todayjava.Ahad.UserTicketCounterStaff;

import cse213.todayjava.User;

public class TicketCounterStaff extends User {
    private String staffID;
    private String username;
    private String counterID;

    public TicketCounterStaff(String userid, String userType, String staffID, String username, String counterID) {
        super(userid, userType);
        this.staffID = staffID;
        this.username = username;
        this.counterID = counterID;

    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCounterID() {
        return counterID;
    }

    public void setCounterID(String counterID) {
        this.counterID = counterID;
    }

    @Override
    public String toString() {
        return "TicketCounterStaff{" +
                "staffID='" + staffID + '\'' +
                ", username='" + username + '\'' +
                ", counterID='" + counterID + '\'' +
                '}';
    }

    public boolean login() {
        System.out.println("Ticket Counter Staff " + username + " logged in successfully.");
        return true;
    }

    public void startShift() {
        System.out.println("Shift started for staff: " + username + " at counter: " + counterID);
    }

    public void endShift() {
        System.out.println("Shift ended for staff: " + username);
    }
}
