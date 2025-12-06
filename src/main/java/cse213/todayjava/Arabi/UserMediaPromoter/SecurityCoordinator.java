package cse213.todayjava.Arabi.UserMediaPromoter;

public class SecurityCoordinator {
    private String securityUpdates;
    private String securityInfo;
    private String createAnnouncement;


    public SecurityCoordinator(String securityUpdates, String securityInfo, String createAnnouncement) {
        this.securityUpdates = securityUpdates;
        this.securityInfo = securityInfo;
        this.createAnnouncement = createAnnouncement;
    }


    public SecurityCoordinator() {
    }


    public String getSecurityUpdates() {
        return securityUpdates;
    }

    public void setSecurityUpdates(String securityUpdates) {
        this.securityUpdates = securityUpdates;
    }

    public String getSecurityInfo() {
        return securityInfo;
    }

    public void setSecurityInfo(String securityInfo) {
        this.securityInfo = securityInfo;
    }

    public String getCreateAnnouncement() {
        return createAnnouncement;
    }

    public void setCreateAnnouncement(String createAnnouncement) {
        this.createAnnouncement = createAnnouncement;
    }


    @Override
    public String toString() {
        return securityUpdates + " | " + securityInfo + " | " + createAnnouncement;
    }
}