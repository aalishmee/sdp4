package model;
public class Customer {
    private final String name;
    private final String email;
    private final String cardNumber;

    public Customer(String name, String email, String cardNumber) {
        this.name = name;
        this.email = email;
        this.cardNumber = cardNumber;
    }
    public String getName()       { return name; }
    public String getEmail()      { return email; }
    public String getCardNumber() { return cardNumber; }
}