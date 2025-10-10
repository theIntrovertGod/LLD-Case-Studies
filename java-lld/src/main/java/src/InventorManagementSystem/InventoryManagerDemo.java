package src.InventorManagementSystem;

import src.InventorManagementSystem.entities.Product;
import src.InventorManagementSystem.entities.Warehouse;
import src.InventorManagementSystem.factory.ProductFactory;

public class InventoryManagerDemo {
    public static void main(String[] args) {
        InventoryManager inventoryManager = InventoryManager.getInstance();

        Warehouse warehouse1 = inventoryManager.addWarehouse(1, "Plano");
        Warehouse warehouse2 = inventoryManager.addWarehouse(2, "Richardson");

        Product laptop = ProductFactory.createproduct("p1", "arnav", "chutiya");
        Product guitar = ProductFactory.createproduct("p2", "nilesh", "chutiya2");

        inventoryManager.addProduct(laptop);
        inventoryManager.addProduct(guitar);

        // Adding stock to warehouses
        System.out.println("---- Intitializing Stock --------");
        inventoryManager.addproductToWarehouse(laptop.getProductId(), 10, warehouse1.getWarehouseId(), 5);
        inventoryManager.addproductToWarehouse(guitar.getProductId(), 50, warehouse1.getWarehouseId(), 20);
        inventoryManager.addproductToWarehouse(laptop.getProductId(), 8, warehouse2.getWarehouseId(), 3);

        System.out.println("----------------------------------------------------");

//        View Initial Inventory
        inventoryManager.viewInventory(warehouse1.getWarehouseId());
        inventoryManager.viewInventory(warehouse2.getWarehouseId());

        //Perform Stock Operationss
        inventoryManager.addStock(warehouse1.getWarehouseId(), laptop.getProductId(), 5);
        inventoryManager.removeStock(warehouse1.getWarehouseId(), guitar.getProductId(), 35);
        inventoryManager.removeStock(warehouse2.getWarehouseId(), laptop.getProductId(), 6);

//
        // 5. Demonstrate error case: removing too much stock
        System.out.println("\n--- Demonstrating Insufficient Stock Error ---");
        inventoryManager.removeStock(warehouse2.getWarehouseId(), laptop.getProductId(), 100); // Fails, only 2 left
        System.out.println();
//
//
        // 6. View final inventory
        System.out.println("\n--- Final Inventory Status ---");
        inventoryManager.viewInventory(warehouse1.getWarehouseId());
        inventoryManager.viewInventory(warehouse2.getWarehouseId());
//
//        // 7. View the full audit log
        inventoryManager.viewAuditLog();
    }
}
