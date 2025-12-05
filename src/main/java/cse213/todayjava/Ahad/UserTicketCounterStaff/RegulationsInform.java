package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class RegulationsInform {
    private String officialRules;
    private String staffExplanation;
    private boolean guidelinesViewed;
    private String timestamp;
    private String status;

    public RegulationsInform() {
        this.officialRules = getDefaultRules();
        this.status = "Not Saved";
    }

    public RegulationsInform(String staffExplanation) {
        this();
        this.staffExplanation = staffExplanation;
        this.guidelinesViewed = true;
    }

    private String getDefaultRules() {
        String rules = "=== OFFICIAL ENTRY REGULATIONS ===\n\n";
        rules += "1. All visitors must present valid ID at entry\n";
        rules += "2. No outside food or drinks allowed\n";
        rules += "3. Smoking prohibited in all areas\n";
        rules += "4. Children must be accompanied by adults\n";
        rules += "5. Follow all safety instructions\n";
        rules += "6. Prohibited items: weapons, sharp objects\n";
        rules += "7. Respect other visitors and staff\n";
        rules += "8. Emergency exits must remain clear\n";
        rules += "9. Follow COVID-19 safety protocols if applicable\n";
        rules += "10. Report any issues to security immediately\n";
        rules += "\nThese rules are mandatory for all visitors.";
        return rules;
    }

    public String getOfficialRules() {
        return officialRules;
    }

    public String getStaffExplanation() {
        return staffExplanation;
    }

    public void setStaffExplanation(String staffExplanation) {
        this.staffExplanation = staffExplanation;
    }

    public boolean isGuidelinesViewed() {
        return guidelinesViewed;
    }

    public void setGuidelinesViewed(boolean guidelinesViewed) {
        this.guidelinesViewed = guidelinesViewed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComplianceRecord() {
        String record = "=== COMPLIANCE RECORD ===\n";
        record += "Guidelines Viewed: " + (guidelinesViewed ? "YES" : "NO") + "\n";
        record += "Staff Explanation: " + staffExplanation + "\n";
        record += "Status: " + status + "\n";
        record += "Timestamp: " + timestamp + "\n";
        record += "=======================";
        return record;
    }
}