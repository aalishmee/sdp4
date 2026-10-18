package subsystem;
public class NotificationService {
    public void sendConfirmation(String email, String orderId) {
        System.out.println("[Notify] Confirmation sent to " + email
                + " for order " + orderId);
    }
    public void sendCancellation(String email, String orderId) {
        System.out.println("[Notify] Cancellation sent to " + email
                + " for order " + orderId);
    }
}