package src.OnlineStockExchange.models;

import java.util.UUID;

public class User {
    private final String userId;
    private final String userName;
    private final Account account;

    public User(String userName, double initialAmount) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.account = new Account(initialAmount);
    }

    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public Account getAccount() {
        return account;
    }

    public void update(Stock stock) {
        System.out.println("Notification for Stock price change " + stock.getSymbol() + " : " + stock.getPrice());
    }

    public void orderStatusUpdate(Order order) {
        System.out.println("Order Notification for Order :" + order.getOrderId() + " : " + order.getPrice() + order.getStatus()) ;
    }

}
