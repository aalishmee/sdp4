package model;
public class Cart {
    private final String itemId;
    private final int quantity;
    private final double price;

    public Cart(String itemId, int quantity, double price) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
    public String getItemId() { return itemId; }
    public int getQuantity()  { return quantity; }
    public double getPrice()  { return price; }
}