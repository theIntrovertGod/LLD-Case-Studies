package src.OnlineStockExchange.commands;

import src.OnlineStockExchange.StockExchange;
import src.OnlineStockExchange.models.Account;
import src.OnlineStockExchange.models.Order;
import src.OnlineStockExchange.models.Stock;

public class SellStockCommand implements OrderCommand{
    private final Account account;
    private final Order order;
    private final StockExchange stockExchange;

    public SellStockCommand(Account account, Order order) {
        this.account = account;
        this.order = order;
        this.stockExchange = StockExchange;
    }

    @Override
    public void execute() {

    }
}
