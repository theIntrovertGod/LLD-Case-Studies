package src.OnlineStockExchange.States;

import src.OnlineStockExchange.models.Order;

public class CancelledState implements OrderState{
    @Override
    public void handle(Order order) {
        System.out.println("Order is cancelled");

    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order is already cancelled");
    }
}
