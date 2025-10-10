package src.InventorManagementSystem.observer;

import src.InventorManagementSystem.entities.StockItem;

public class LowStockObserver implements StockItemObsever{
    @Override
    public void onStockUpdate(StockItem stockItem) {
        if(stockItem.getQuantity() < stockItem.getThreshold()) {
            System.out.println("ALERT: Low stock for item: " + stockItem.getProduct().getProductName());
        }
    }
}
