package cse213.todayjava.Milad.UserMaintenanceStaff;

import java.time.LocalDate;

public class TaskLog {
    private String logId;
    private String staffId;
    private LocalDate todayDate;
    private String summary;
    private String status;

    public TaskLog() {
    }

    public TaskLog(String logId, String staffId, String summary, String status) {
        this.logId = logId;
        this.staffId = staffId;
        this.todayDate = LocalDate.now();
        this.summary = summary;
        this.status = status;
    }

    public TaskLog(String logId, String staffId, LocalDate todayDate, String summary, String status) {
        this.logId = logId;
        this.staffId = staffId;
        this.todayDate = todayDate;
        this.summary = summary;
        this.status = status;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public LocalDate getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(LocalDate todayDate) {
        this.todayDate = todayDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskLog{" +
                "logId='" + logId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", todayDate=" + todayDate +
                ", summary='" + summary + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}