import model.Cart;
import model.Customer;
import model.Order;
import subsystem.InventoryService;
import subsystem.PaymentProcessor;
import subsystem.ShippingService;
import subsystem.NotificationService;

public class OrderFacade {
    private final InventoryService inventory;
    private final PaymentProcessor payment;
    private final ShippingService shipping;
    private final NotificationService notifier;

    public OrderFacade() {
        this.inventory = new InventoryService();
        this.payment   = new PaymentProcessor();
        this.shipping  = new ShippingService();
        this.notifier  = new NotificationService();
    }

    public Order placeOrder(Cart cart, Customer customer) {
        String itemId = cart.getItemId();
        int qty = cart.getQuantity();
        double total = cart.getPrice() * qty;

        if (!inventory.checkStock(itemId, qty)) {
            throw new IllegalStateException("Out of stock: " + itemId);
        }
        inventory.reserveStock(itemId, qty);

        if (!payment.charge(customer.getCardNumber(), total)) {
            inventory.releaseStock(itemId, qty);
            throw new IllegalStateException("Payment declined");
        }

        String tracking = shipping.scheduleShipment(
                itemId, qty, customer.getEmail());
        System.out.println("[Facade] Shipment tracking ID: " + tracking);

        Order order = new Order("ORD-" + System.currentTimeMillis(),
                itemId, qty, total);
        notifier.sendConfirmation(customer.getEmail(), order.getId());
        return order;
    }

    public void cancelOrder(Order order, Customer customer) {
        order.setStatus("CANCELLED");
        inventory.releaseStock(order.getItemId(), order.getQuantity());
        payment.refund(customer.getCardNumber(), order.getTotal());
        notifier.sendCancellation(customer.getEmail(), order.getId());
    }
}