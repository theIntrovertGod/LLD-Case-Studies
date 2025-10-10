package src.InventorManagementSystem.entities;

import src.InventorManagementSystem.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final String transactionId;
    private final LocalDateTime timestamp;
    private final String productId;
    private final int warehouseId;
    private final int quantityChange;
    private final TransactionType type;


    public Transaction( String productId, int warehouseId, int quantityChange, TransactionType type) {
        this.transactionId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        this.productId = productId;
        this.warehouseId = warehouseId;
        this.quantityChange = quantityChange;
        this.type = type;
    }
}
