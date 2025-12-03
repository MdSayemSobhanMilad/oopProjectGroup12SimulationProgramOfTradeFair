package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDate;
import java.util.Objects;

public class Equipment {
    private String equipmentId;
    private String equipmentName;
    private String location;
    private Boolean status;
    private LocalDate lastInspection;

    public Equipment(String equipmentId, String equipmentName, String location, Boolean status, LocalDate lastInspection) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.location = location;
        this.status = status;
        this.lastInspection = lastInspection;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getLastInspection() {
        return lastInspection;
    }

    public void setLastInspection(LocalDate lastInspection) {
        this.lastInspection = lastInspection;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId='" + equipmentId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", lastInspection=" + lastInspection +
                '}';
    }

    public String getEquipmentDetails(){
        return
                "equipmentId='" + equipmentId + ' ' +
                ", equipmentName='" + equipmentName + ' ' +
                ", location='" + location + ' ' +
                ", status='" + status + ' ' +
                ", lastInspection=" + lastInspection;
    }

    public Boolean updateStatus(String newStatus){
        if (newStatus.equals("Yes")){
            return this.status = true;
        } else{
            return this.status = false;
        }
    }
}
