package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDateTime;

public class TaskLog {
    private String logId;
    private String taskId;
    private String staffId;
    private LocalDateTime completionTime;
    private String summary;
    private Double timeSpent;
    private String status;

    public TaskLog() {
    }

    public TaskLog(String logId, String taskId, String staffId, LocalDateTime completionTime,
                   String summary, Double timeSpent) {
        this.logId = logId;
        this.taskId = taskId;
        this.staffId = staffId;
        this.completionTime = completionTime;
        this.summary = summary;
        this.timeSpent = timeSpent;
        this.status = "LOGGED";
    }

    // Getters and Setters
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Methods
    public boolean logTaskCompletion(String details) {
        this.summary = details;
        this.completionTime = LocalDateTime.now();
        System.out.println("Task completion logged for task: " + taskId);
        return true;
    }

    public boolean verifyCompleteness() {
        boolean isComplete = logId != null && !logId.isEmpty() &&
                taskId != null && !taskId.isEmpty() &&
                staffId != null && !staffId.isEmpty() &&
                summary != null && !summary.isEmpty() &&
                timeSpent != null && timeSpent > 0;
        System.out.println("Task log completeness verification: " + (isComplete ? "PASSED" : "FAILED"));
        return isComplete;
    }

    public String generateDailyReport() {
        String report = "Daily Task Log Report\n" +
                "Log ID: " + logId + "\n" +
                "Task ID: " + taskId + "\n" +
                "Staff ID: " + staffId + "\n" +
                "Completion Time: " + completionTime + "\n" +
                "Time Spent: " + timeSpent + " hours\n" +
                "Summary: " + summary + "\n" +
                "Status: " + status;
        System.out.println("Generated daily report for task log: " + logId);
        return report;
    }

    @Override
    public String toString() {
        return "TaskLog{" +
                "logId='" + logId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", completionTime=" + completionTime +
                ", timeSpent=" + timeSpent +
                ", status='" + status + '\'' +
                '}';
    }
}