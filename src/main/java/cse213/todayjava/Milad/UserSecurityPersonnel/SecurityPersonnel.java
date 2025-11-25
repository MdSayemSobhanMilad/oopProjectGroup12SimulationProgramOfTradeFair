package cse213.todayjava.Milad.UserSecurityPersonnel;

import cse213.todayjava.User;

public class SecurityPersonnel extends User{
    private int personnelID;
    private String name;
    private String zoneAssigned;
    private String shiftTime;

    public SecurityPersonnel(String userid, String userType, int personnelID, String name, String zoneAssigned, String shiftTime) {
        super(userid, userType);
        this.personnelID = personnelID;
        this.name = name;
        this.zoneAssigned = zoneAssigned;
        this.shiftTime = shiftTime;
    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZoneAssigned() {
        return zoneAssigned;
    }

    public void setZoneAssigned(String zoneAssigned) {
        this.zoneAssigned = zoneAssigned;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    @Override
    public String toString() {
        return "SecurityPersonnel{" +
                "personnelID=" + personnelID +
                ", name='" + name + '\'' +
                ", zoneAssigned='" + zoneAssigned + '\'' +
                ", shiftTime='" + shiftTime + '\'' +
                '}';
    }
}
