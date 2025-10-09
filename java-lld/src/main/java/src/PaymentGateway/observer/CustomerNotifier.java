package src.PaymentGateway.observer;

import src.PaymentGateway.enums.PaymentStatus;
import src.PaymentGateway.models.Transaction;

public class CustomerNotifier implements  PaymentNotifier{
    @Override
    public void onTransactionUpdate(Transaction transaction) {
        if (transaction.getStatus() == PaymentStatus.SUCCESSFUL) {
            System.out.println("Customer Notifier: Transaction Successful");
        }
    }
}
