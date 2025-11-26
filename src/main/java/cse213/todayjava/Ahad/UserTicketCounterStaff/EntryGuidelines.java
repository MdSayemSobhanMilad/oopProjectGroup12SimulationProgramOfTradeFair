package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class EntryGuidelines {
    private String guidelineId;
    private String title;
    private String content;
    private String version;

    public EntryGuidelines(String guidelineId, String title, String content, String version) {
        this.guidelineId = guidelineId;
        this.title = title;
        this.content = content;
        this.version = version;
    }

    // Getters and Setters
    public String getGuidelineId() { return guidelineId; }
    public void setGuidelineId(String guidelineId) { this.guidelineId = guidelineId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    // Methods
    public void displayRules() {
        System.out.println("=== OFFICIAL ENTRY RULES ===");
        System.out.println("Title: " + title);
        System.out.println("Version: " + version);
        System.out.println("Content: " + content);
        System.out.println("1. All visitors must present valid ID");
        System.out.println("2. No outside food or beverages");
        System.out.println("3. Follow security protocols at all times");
    }

    public void recordView() {
        System.out.println("Guidelines viewed by staff. Recorded for compliance tracking.");
        System.out.println("Guideline ID: " + guidelineId + ", Version: " + version);
    }

    @Override
    public String toString() {
        return "EntryGuidelines{" +
                "guidelineId='" + guidelineId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
