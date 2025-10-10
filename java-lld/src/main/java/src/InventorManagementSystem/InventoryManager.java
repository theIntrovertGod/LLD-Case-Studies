package src.InventorManagementSystem;

import src.InventorManagementSystem.auditService.AuditService;
import src.InventorManagementSystem.entities.Product;
import src.InventorManagementSystem.entities.StockItem;
import src.InventorManagementSystem.entities.Transaction;
import src.InventorManagementSystem.entities.Warehouse;
import src.InventorManagementSystem.enums.TransactionType;
import src.InventorManagementSystem.observer.LowStockObserver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManager {
    private static final InventoryManager INSTANCE = new InventoryManager();
    private final Map<String, Product> products;
    private final Map<Integer, Warehouse> warehouses;
    private final AuditService auditService;


    private InventoryManager() {
        this.products = new ConcurrentHashMap<>();
        this.warehouses = new ConcurrentHashMap<>();
        this.auditService = AuditService.getInstance();
    }

    public static InventoryManager getInstance() {
        return INSTANCE;
    }

    public Warehouse addWarehouse(int warehouseId, String Location) {
        Warehouse warehouse = new Warehouse(warehouseId, Location);
        warehouses.put(warehouseId, warehouse);
        return warehouse;
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void addproductToWarehouse(String productId, int initialQuantity, int warehouseId, int threshold) {
        Warehouse warehouse = warehouses.get(warehouseId);
        Product product = products.get(productId);
        if(warehouse == null || product == null) {
            System.err.println("Warehouse or product not found");
        }
        StockItem stockItem = new StockItem(product, initialQuantity, threshold, warehouseId);
        stockItem.addObservers(new LowStockObserver());
        warehouse.addProduct(stockItem);
        auditService.log(new Transaction(productId, warehouseId, initialQuantity, TransactionType.INITIAL_STOCK));
    }

    public void updateStock(int wareHouseId, String productId, int quantityChange) {
        Warehouse warehouse = warehouses.get(wareHouseId);

        if(warehouse == null){
            System.err.println("warehouse does not exist");
            return;
        }

        boolean success = warehouse.updateQuantity(productId, quantityChange);

        if(success) {
            auditService.log(new Transaction(productId, wareHouseId, quantityChange, quantityChange>= 0 ? TransactionType.ADD : TransactionType.REMOVE));
        }
    }

    public void addStock(int warehouseId, String productId, int quantityValue) {
        updateStock(warehouseId, productId, quantityValue);
    }

    public void removeStock(int warehouseId, String productId, int quantityValue) {
        updateStock(warehouseId, productId, -quantityValue);
    }

    public void  viewInventory (int warehouseId) {
        Warehouse warehouse = warehouses.get(warehouseId);
        if(warehouse != null) {
            warehouse.printInventory();
        }else {
            System.err.println("Warehouse with ID :" + warehouseId + " does not exist");
        }
    }

    public void viewAuditLog() {
        auditService.printAUditLog();
    }
}
