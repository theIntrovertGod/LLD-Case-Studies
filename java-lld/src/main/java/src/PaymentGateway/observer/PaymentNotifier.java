package src.PaymentGateway.observer;

import src.PaymentGateway.models.Transaction;

public interface PaymentNotifier {
    void onTransactionUpdate(Transaction transaction);
}
