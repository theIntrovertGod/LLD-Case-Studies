package src.OnlineStockExchange.models;

import src.OnlineStockExchange.States.OrderState;
import src.OnlineStockExchange.enums.OrderStatus;
import src.OnlineStockExchange.enums.OrderType;

public class Order {
    private final String orderId;
    private final int quanity;
    private final double price;
    private final OrderType orderType;
    private final User owner;
    private OrderStatus status;
    private OrderState currentState;
    private final ExecutionStrategy executionStrategy;

    public Order(String orderId, int quanity, double price, OrderType orderType, User owner, ExecutionStrategy executionStrategy) {
        this.orderId = orderId;
        this.quanity = quanity;
        this.price = price;
        this.orderType = orderType;
        this.owner = owner;
        this.executionStrategy = executionStrategy;
        this.status = OrderStatus.OPEN;
    }

    public void setOrdderStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }

    public String getOrderId() {
        return orderId;
    }
    public int getQuanity() {
        return quanity;
    }
    public double getPrice() {
        return price;
    }
    public OrderType getOrderType() {
        return orderType;
    }
    public User getOwner() {
        return owner;
    }
    public OrderStatus getStatus() {
        return status;
    }

    private void setStatus(OrderStatus status) {
        this.status = status;
        notifyOwner();
    }

    private void notifyOwner() {
        if (owner != null) {
            owner.orderStatusUpdate(this);
        }
    }

}
