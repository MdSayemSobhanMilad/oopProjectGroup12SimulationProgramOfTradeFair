package cse213.todayjava.Ahad.UserStallOwner;

import cse213.todayjava.User;

public class StallOwner extends User {
    private String ownerID;
    private String username;
    private String stallID;
    private String location;

    public StallOwner(String userid, String userType, String ownerID, String username, String stallID, String location) {
        super(userid, userType);
        this.ownerID = ownerID;
        this.username = username;
        this.stallID = stallID;
        this.location = location;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStallID() {
        return stallID;
    }

    public void setStallID(String stallID) {
        this.stallID = stallID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "StallOwner{" +
                "ownerID='" + ownerID + '\'' +
                ", username='" + username + '\'' +
                ", stallID='" + stallID + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public boolean login() {
        System.out.println("Stall Owner " + username + " logged in successfully.");
        return true;
    }

    public void openModule(String moduleName) {
        System.out.println("Opening module: " + moduleName);
    }
}
