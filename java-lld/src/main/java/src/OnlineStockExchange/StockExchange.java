package src.OnlineStockExchange;

import src.OnlineStockExchange.models.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockExchange {
    private static volatile StockExchange instance;
    private final Map<String, List<Order>> buyOrders;
    private final Map<String, List<Order>> sellOrders;

    private StockExchange() {
        buyOrders = new ConcurrentHashMap<>();
        sellOrders = new ConcurrentHashMap<>();
    }
    public static StockExchange getInstance() {
        if (instance == null) {
            synchronized (StockExchange.class) {
                if (instance == null) {
                    instance = new StockExchange();
                }
            }
        }
        return instance;
    }
}
