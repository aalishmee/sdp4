package subsystem;
public class PaymentProcessor {
    public boolean charge(String cardNumber, double amount) {
        System.out.println("[Payment] Charging $" + amount);
        return amount > 0 && amount < 10000;
    }
    public void refund(String cardNumber, double amount) {
        System.out.println("[Payment] Refunded $" + amount);
    }
}