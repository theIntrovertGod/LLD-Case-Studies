package src.splitWiseMain.entities;

import java.util.UUID;

public class Split {
    private String id;
    private final User user;
    private final double amount;

    public Split(User user, double amount) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.amount = amount;
    }
    public User getUser() {
        return user;
    }
    public double getAmount() {
        return amount;
    }
}
