package cse213.todayjava.Ahad.UserTicketCounterStaff;

public class SecurityNotifier {
    private String notifierId;

    public SecurityNotifier(String notifierId) {
        this.notifierId = notifierId;
    }

    // Getters and Setters
    public String getNotifierId() { return notifierId; }
    public void setNotifierId(String notifierId) { this.notifierId = notifierId; }

    // Methods
    public void sendClosureNotification() {
        System.out.println("SECURITY NOTIFICATION: Ticket counter is now closed.");
        System.out.println("Notification sent to security team.");
        System.out.println("Notifier ID: " + notifierId);
    }

    public void confirmSecurityAlert() {
        System.out.println("Security alert confirmed. Counter secured.");
    }

    @Override
    public String toString() {
        return "SecurityNotifier{" +
                "notifierId='" + notifierId + '\'' +
                '}';
    }
}
