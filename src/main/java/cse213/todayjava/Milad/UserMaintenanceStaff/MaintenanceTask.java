package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDateTime;

public class MaintenanceTask {
    private String taskId;
    private String taskType;
    private String description;
    private String priority;
    private String status;
    private String reportedBy;
    private String assignedTo;
    private LocalDateTime reportedTime;
    private LocalDateTime completedTime;
    private String completionPhoto;

    public MaintenanceTask() {
    }

    public MaintenanceTask(String taskId, String taskType, String description, String priority, String status,
                           String reportedBy, String assignedTo, LocalDateTime reportedTime) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.reportedBy = reportedBy;
        this.assignedTo = assignedTo;
        this.reportedTime = reportedTime;
    }

    // Getters and Setters
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(LocalDateTime reportedTime) {
        this.reportedTime = reportedTime;
    }

    public LocalDateTime getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(LocalDateTime completedTime) {
        this.completedTime = completedTime;
    }

    public String getCompletionPhoto() {
        return completionPhoto;
    }

    public void setCompletionPhoto(String completionPhoto) {
        this.completionPhoto = completionPhoto;
    }

    // Methods
    public boolean updateStatus(String newStatus) {
        this.status = newStatus;
        if ("COMPLETED".equals(newStatus)) {
            this.completedTime = LocalDateTime.now();
        }
        System.out.println("Task " + taskId + " status updated to: " + newStatus);
        return true;
    }

    public boolean assignTask(String staffId) {
        this.assignedTo = staffId;
        System.out.println("Task " + taskId + " assigned to staff: " + staffId);
        return true;
    }

    public boolean markAsCompleted(byte[] photo) {
        this.status = "COMPLETED";
        this.completedTime = LocalDateTime.now();
        this.completionPhoto = "photo_reference"; // Store photo reference
        System.out.println("Task " + taskId + " marked as completed");
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceTask{" +
                "taskId='" + taskId + '\'' +
                ", taskType='" + taskType + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", reportedTime=" + reportedTime +
                ", completedTime=" + completedTime +
                '}';
    }
}
