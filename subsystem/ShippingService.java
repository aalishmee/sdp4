package subsystem;
public class ShippingService {
    public String scheduleShipment(String itemId, int qty, String address) {
        String tracking = "TRK-" + System.currentTimeMillis();
        System.out.println("[Shipping] Scheduled " + qty + " x " + itemId
                + " to " + address + " (" + tracking + ")");
        return tracking;
    }
    public void cancelShipment(String trackingId) {
        System.out.println("[Shipping] Cancelled " + trackingId);
    }
}