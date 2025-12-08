package src.OnlineStockExchange.States;

import src.OnlineStockExchange.models.Order;

public interface OrderState {
    public void handle(Order order);
    public  void cancel(Order order);
}
