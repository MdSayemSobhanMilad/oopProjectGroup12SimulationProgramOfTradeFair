package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class TicketProvider {
    private String ticketCode;
    private String visitorName;
    private String passType;
    private String deliveryMethod;
    private String status;

    public TicketProvider() {
        this.status = "Not Created";
    }

    public TicketProvider(String ticketCode, String visitorName) {
        this();
        this.ticketCode = ticketCode;
        this.visitorName = visitorName;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicketDetails() {
        String details = "=== TRADE FAIR TICKET ===\n";
        details += "Ticket Code: " + ticketCode + "\n";
        details += "Visitor Name: " + visitorName + "\n";
        details += "Pass Type: " + passType + "\n";
        details += "Delivery Method: " + deliveryMethod + "\n";
        details += "Current Status: " + status + "\n";
        details += "=========================";
        return details;
    }
}