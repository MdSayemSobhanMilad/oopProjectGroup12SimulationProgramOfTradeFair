package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDateTime;

public class RoutineInspection {
    private String inspectionId;
    private String equipmentId;
    private String inspectedBy;
    private LocalDateTime inspectionDate;
    private String status;
    private String notes;
    private String issuesFound;

    public RoutineInspection() {
    }

    public RoutineInspection(String inspectionId, String equipmentId, String inspectedBy,
                             LocalDateTime inspectionDate, String status) {
        this.inspectionId = inspectionId;
        this.equipmentId = equipmentId;
        this.inspectedBy = inspectedBy;
        this.inspectionDate = inspectionDate;
        this.status = status;
    }

    // Getters and Setters
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

    public LocalDateTime getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDateTime inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIssuesFound() {
        return issuesFound;
    }

    public void setIssuesFound(String issuesFound) {
        this.issuesFound = issuesFound;
    }

    // Methods
    public boolean recordInspection(String result) {
        this.status = result;
        this.notes = result;
        System.out.println("Inspection " + inspectionId + " recorded with result: " + result);
        return true;
    }

    public String generateInspectionReport() {
        String report = "Inspection Report - " + inspectionId + "\n" +
                "Equipment: " + equipmentId + "\n" +
                "Inspected By: " + inspectedBy + "\n" +
                "Date: " + inspectionDate + "\n" +
                "Status: " + status + "\n" +
                "Issues Found: " + (issuesFound != null ? issuesFound : "None") + "\n" +
                "Notes: " + (notes != null ? notes : "N/A");
        System.out.println("Generated inspection report for: " + inspectionId);
        return report;
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