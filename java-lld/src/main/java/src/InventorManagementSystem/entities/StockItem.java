package src.InventorManagementSystem.entities;

import src.InventorManagementSystem.observer.StockItemObsever;

import java.util.ArrayList;
import java.util.List;

public class StockItem {
    private final Product product;
    private int quantity;
    private final int threshold;
    private final int wareHouseId;
    private final List<StockItemObsever> stockItemObservers;

    public StockItem(Product product, int quantity, int threshold, int wareHouseId) {
        this.product = product;
        this.quantity = quantity;
        this.threshold = threshold;
        this.wareHouseId = wareHouseId;
        this.stockItemObservers = new ArrayList<>();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getThreshold() {
        return threshold;
    }
    public int getWareHouseId() {
        return wareHouseId;
    }

    public void addObservers(StockItemObsever observer) {
        stockItemObservers.add(observer);
    }

    public void removeObservers(StockItemObsever observer) {
        stockItemObservers.remove(observer);
    }

    public synchronized boolean updateStockItem(int quantityChange) {
        if(quantityChange + quantity < 0) {
            System.err.println("Cannot remove stock more than available");
            return false;
        }
        this.quantity += quantityChange;
        notifyObservers();
        return true;
    }

    private void notifyObservers() {
        for (StockItemObsever observer : stockItemObservers) {
            observer.onStockUpdate(this);
        }
    }
}
