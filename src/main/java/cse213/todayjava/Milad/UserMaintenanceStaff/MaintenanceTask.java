package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDate;


public class MaintenanceTask {
    private String taskId;
    private String taskType;
    private String description;

    private String status;
    private LocalDate reportedTime;
    private LocalDate completedTime;


    public MaintenanceTask() {
    }

    public MaintenanceTask(String taskId, String taskType, String description, String status, LocalDate reportedTime, LocalDate completedTime) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.description = description;
        this.status = status;
        this.reportedTime = reportedTime;
        this.completedTime = completedTime;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(LocalDate reportedTime) {
        this.reportedTime = reportedTime;
    }

    public LocalDate getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(LocalDate completedTime) {
        this.completedTime = completedTime;
    }

    @Override
    public String toString() {
        return
                "taskId='" + taskId + '\'' +
                ", taskType='" + taskType + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", reportedTime=" + reportedTime +
                ", completedTime=" + completedTime;
    }

    // Methods
    public boolean updateStatus(String newStatus) {
        this.status = newStatus;
        if ("COMPLETED".equals(newStatus)) {
            this.completedTime = LocalDate.now();
        }
        System.out.println("Task " + taskId + " status updated to: " + newStatus);
        return true;
    }

}
