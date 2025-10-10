package src.InventorManagementSystem.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Warehouse {
    private final int warehouseId;
    private final String warehouseLocation;
    private final Map<String, StockItem> stockItems;

    public Warehouse(int warehouseId, String warehouseLocation) {
        this.warehouseId = warehouseId;
        this.warehouseLocation = warehouseLocation;
        this.stockItems = new ConcurrentHashMap<>();
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public String getWarehouseLocation(){
        return warehouseLocation;
    }

    public void addProduct(StockItem stockItem) {
        stockItems.put(stockItem.getProduct().getProductId(), stockItem);
    }

    public boolean updateQuantity(String productId, int quantityChange) {
        StockItem stockItem = stockItems.get(productId);
        if (stockItem != null) {
            return stockItem.updateStockItem(quantityChange);
        }else {
            System.err.println("Error -- Product Id not found" );
        }
        return false;
    }

    public  int getStockLevel(String productId) {
        StockItem stockItem = stockItems.get(productId);
        return (stockItem == null) ? 0: stockItem.getQuantity();
    }

    public void printInventory() {
        if(stockItems.isEmpty()) {
            System.out.println("Warehouse khaali hai");
            return;
        }
        System.out.println("------------INVENTORY LIST-------------------");
        stockItems.values().forEach(item -> System.out.println(
                item.getProduct().getProductName() + " : " + item.getQuantity()
        ));

        System.out.println("-------------------------------");
    }


}
