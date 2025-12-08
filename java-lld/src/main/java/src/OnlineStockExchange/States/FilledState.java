package src.OnlineStockExchange.States;

import src.OnlineStockExchange.models.Order;

public class FilledState implements OrderState{
    @Override
    public void handle(Order order) {
        System.out.println("Order ins already Filled");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order is in filled state , so cannot be cancelled.");
    }
}
