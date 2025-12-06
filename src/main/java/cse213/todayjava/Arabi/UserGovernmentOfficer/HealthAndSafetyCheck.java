package cse213.todayjava.Arabi.UserGovernmentOfficer;

public class HealthAndSafetyCheck {
    private String reportId;
    private String safetyStatus;


    public HealthAndSafetyCheck(String reportId, String safetyStatus) {
        this.reportId = reportId;
        this.safetyStatus = safetyStatus;
    }


    public HealthAndSafetyCheck() {
    }


    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getSafetyStatus() {
        return safetyStatus;
    }

    public void setSafetyStatus(String safetyStatus) {
        this.safetyStatus = safetyStatus;
    }


    @Override
    public String toString() {
        return "Report ID: " + reportId + ", Safety Status: " + safetyStatus;
    }
}