package src.splitWiseMain.entities;

import java.util.UUID;

public class Transaction {
    private final String transactionId;
    private final String from;
    private final String to;
    private final double amount;


    public Transaction(String from, String to, double amount) {
        this.to = to;
        this.transactionId = UUID.randomUUID().toString();
        this.from = from;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public double getAmount() {
        return amount;
    }
}
