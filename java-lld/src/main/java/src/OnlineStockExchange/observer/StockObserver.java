package src.OnlineStockExchange.observer;

import src.OnlineStockExchange.models.Stock;

public interface StockObserver {
    void update(Stock stock);
}
