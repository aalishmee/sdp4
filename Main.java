import model.Cart;
import model.Customer;
import model.Order;
public class Main {
    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();

        Cart cart = new Cart("BOOK-67", 2, 15.0);
        Customer alice = new Customer("Aruzhan",
                "aruzhan@mail.com",
                "6767-6767");

        try {
            Order order = facade.placeOrder(cart, alice);
            System.out.println("Order placed: " + order.getId());
        } catch (IllegalStateException e) {
            System.out.println("Error! " + e.getMessage());
        }

        Cart bigCart = new Cart("TV-67", 1, 99999.0);
        try {
            facade.placeOrder(bigCart, alice);
        } catch (IllegalStateException e) {
            System.out.println("Error! " + e.getMessage()
                    + " (stock was released)");
        }
    }
}