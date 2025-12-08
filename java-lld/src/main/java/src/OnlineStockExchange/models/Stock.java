package src.OnlineStockExchange.models;

import src.OnlineStockExchange.observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final String symbol;
    private double price;
    private final List<StockObserver> observers = new ArrayList<StockObserver>();


    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public double getPrice() {
        return price;
    }
    public String getSymbol(){
        return symbol;
    }

    public void setPrice(double price) {
        if (this.price != price) {
            this.price = price;
            notifyObservers();
        }
    }

    public void addObserver(StockObserver observer){
        observers.add(observer);
    }
    public void removeObserver(StockObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for(StockObserver observer : observers){
            observer.update(this);
        }
    }
}
