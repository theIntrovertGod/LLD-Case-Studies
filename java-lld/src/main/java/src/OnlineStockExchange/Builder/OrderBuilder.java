package src.OnlineStockExchange.Builder;

import src.OnlineStockExchange.enums.OrderType;
import src.OnlineStockExchange.enums.TransactionType;
import src.OnlineStockExchange.models.Stock;
import src.OnlineStockExchange.models.User;


public class OrderBuilder {
    private User user;
    private Stock stock;
    private OrderType orderType;
    private TransactionType transactionType;
    private int quantity;
    private double price;

    public OrderBuilder forUser(User user) {
        this.user = user;
        return this;
    }
    public OrderBuilder forStock(Stock stock) {
        this.stock = stock;
        return this;
    }
    public OrderBuilder buy(int quantity) {
        this.quantity = quantity;
        this.transactionType = TransactionType.BUY;
        return this;
    }

    public OrderBuilder sell(int quantity) {
        this.quantity = quantity;
        this.transactionType = TransactionType.SELL;
        return this;
    }

    public OrderBuilder atMarketPrice() {
        this.orderType = OrderType.MARKET;
        this.price = 0;
        return this;
    }

    public OrderBuilder withLimit(double limitPrice) {
        this.price = limitPrice;
        this.orderType = OrderType.LIMIT;
        return this;
    }
}
