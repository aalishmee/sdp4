package subsystem;
public class InventoryService {
    public boolean checkStock(String itemId, int qty) {
        System.out.println("[Inventory] Checking stock for " + itemId);
        return qty > 0 && qty <= 100;
    }
    public void reserveStock(String itemId, int qty) {
        System.out.println("[Inventory] Reserved " + qty + " x " + itemId);
    }
    public void releaseStock(String itemId, int qty) {
        System.out.println("[Inventory] Released " + qty + " x " + itemId);
    }
}