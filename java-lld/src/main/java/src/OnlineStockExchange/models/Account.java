package src.OnlineStockExchange.models;

import src.OnlineStockExchange.Exceptions.InsufficientFundException;
import src.OnlineStockExchange.Exceptions.InsufficientStockException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Account {
    private double balance;
    private final Map<String, Integer> portfolio;

    public Account(double initialBalance) {
        this.portfolio = new ConcurrentHashMap<>();
        this.balance = initialBalance;
    }

    public synchronized void debit(double amount) {
        if (amount > balance) {
            throw new InsufficientFundException("Insufficient funds");
        }
        balance -= amount;
    }

    public synchronized void credit(double amount) {
        balance += amount;
    }

    public synchronized void addStock(String symbol, int quantity) {
        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
    }

    public synchronized void  removeStock(String symbol, int quantity) {
        int currentQuantity = portfolio.getOrDefault(symbol, 0);
        if (currentQuantity < quantity) {
            throw new InsufficientStockException("Not enough " + symbol + " quanitty");
        }
        portfolio.put(symbol, currentQuantity - quantity);
    }
    public double getBalance() {
        return balance;
    }

    public Map<String, Integer> getPortfolio() {
        return Map.copyOf(portfolio);
    }

    public int getStockQuantity(String symbol) {
        return portfolio.getOrDefault(symbol, 0);
    }

    // credit
    // debit
    // addStock
//    removeStock
}
