package src.OnlineStockExchange;

import src.OnlineStockExchange.models.Order;
import src.OnlineStockExchange.models.Stock;
import src.OnlineStockExchange.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockBrokerageSystem {
    private static volatile StockBrokerageSystem stockBrokerageSystemInstance;
    private final Map<String, User> users;
    private final Map<String, Stock> stocks;
    private StockBrokerageSystem() {
        this.users = new ConcurrentHashMap<>();
        this.stocks = new ConcurrentHashMap<>();
    }
    public static StockBrokerageSystem getInstance() {
        if (stockBrokerageSystemInstance == null) {
            synchronized (StockBrokerageSystem.class) {
                if (stockBrokerageSystemInstance == null) {
                    stockBrokerageSystemInstance = new StockBrokerageSystem();
                }
            }
        }
        return stockBrokerageSystemInstance;
    }

    public User registerUser(String username, double initAmount) {
        User user = new User(username, initAmount);
        users.put(username, user);
        return user;
    }

    public Stock addStock(String symbol, double initialPrice) {
        Stock newStock = new Stock(symbol, initialPrice);
        stocks.put(symbol, newStock);
        return newStock;
    }

    public void placeBuyOrder(Order order){
        User user = order.getOwner();

    }
}
