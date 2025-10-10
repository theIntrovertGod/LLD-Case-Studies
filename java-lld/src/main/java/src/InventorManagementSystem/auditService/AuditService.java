package src.InventorManagementSystem.auditService;

import src.InventorManagementSystem.entities.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AuditService {
    private static final AuditService INSTANCE = new AuditService();
    private final List<Transaction> trnsactionLog;

    private AuditService() {
        this.trnsactionLog = new CopyOnWriteArrayList<>();
    }

    public static synchronized AuditService getInstance() {
        return INSTANCE;
    }
    public void log(Transaction transaction){
        this.trnsactionLog.add(transaction);
    }

    public void printAUditLog() {
        this.trnsactionLog.forEach(System.out::println);
    }
}
