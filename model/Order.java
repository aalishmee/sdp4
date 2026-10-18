package model;
public class Order {
    private final String id;
    private final String itemId;
    private final int quantity;
    private final double total;
    private String status;

    public Order(String id, String itemId, int quantity, double total) {
        this.id = id;
        this.itemId = itemId;
        this.quantity = quantity;
        this.total = total;
        this.status = "PLACED";
    }
    public String getId()       { return id; }
    public String getItemId()   { return itemId; }
    public int getQuantity()    { return quantity; }
    public double getTotal()    { return total; }
    public String getStatus()   { return status; }
    public void setStatus(String s) { this.status = s; }
}