package src.InventorManagementSystem.observer;

import src.InventorManagementSystem.entities.StockItem;

public interface StockItemObsever {
    void onStockUpdate(StockItem stockItem);
}
