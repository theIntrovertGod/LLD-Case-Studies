package src.OnlineStockExchange.States;

import src.OnlineStockExchange.enums.OrderStatus;
import src.OnlineStockExchange.models.Order;

public class OpenState implements OrderState{
    @Override
    public void handle(Order order) {
        System.out.println("Order is open and waiting to be executed..... Order id : "  + order.getOrderId());
    }

    @Override
    public void cancel(Order order) {
        order.setOrdderStatus(OrderStatus.CANCELLED);
        order.setCurrentState(new CancelledState());
        System.out.println("Order : " + order.getOrderId() + " has been cancelled");
    }
}
