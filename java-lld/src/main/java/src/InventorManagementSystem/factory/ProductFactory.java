package src.InventorManagementSystem.factory;

import src.InventorManagementSystem.entities.Product;

public class ProductFactory {
    public static Product createproduct(String productid, String name, String description) {
        return new Product.ProductBuilder(productid)
                .productName(name)
                .productDescription(description)
                .build();
    }
}
