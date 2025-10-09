package src.PaymentGateway.observer;

import src.PaymentGateway.models.Transaction;

public class MerchantNotifier implements PaymentNotifier{
    @Override
    public void onTransactionUpdate(Transaction transaction) {
        System.out.println("Merchant Notifier: onTransactionUpdate" + transaction.getId() + "Status changed to:" + transaction.getStatus());
    }
}
