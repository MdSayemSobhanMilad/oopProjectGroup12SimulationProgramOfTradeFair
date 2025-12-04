package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDate;


public class RoutineInspection {
    private String inspectionId;
    private String equipmentId;
    private String inspectedBy;
    private LocalDate inspectionDate;
    private String status;
    private String issuesFound;

    public RoutineInspection() {
    }

    public RoutineInspection(String inspectionId, String equipmentId, String inspectedBy, LocalDate inspectionDate, String status, String issuesFound) {
        this.inspectionId = inspectionId;
        this.equipmentId = equipmentId;
        this.inspectedBy = inspectedBy;
        this.inspectionDate = inspectionDate;
        this.status = status;
        this.issuesFound = issuesFound;
    }

    public String getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getInspectedBy() {
        return inspectedBy;
    }

    public void setInspectedBy(String inspectedBy) {
        this.inspectedBy = inspectedBy;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssuesFound() {
        return issuesFound;
    }

    public void setIssuesFound(String issuesFound) {
        this.issuesFound = issuesFound;
    }

    @Override
    public String toString() {
        return "RoutineInspection{" +
                "inspectionId='" + inspectionId + '\'' +
                ", equipmentId='" + equipmentId + '\'' +
                ", inspectedBy='" + inspectedBy + '\'' +
                ", inspectionDate=" + inspectionDate +
                ", status='" + status + '\'' +
                ", issuesFound='" + issuesFound + '\'' +
                '}';
    }
}