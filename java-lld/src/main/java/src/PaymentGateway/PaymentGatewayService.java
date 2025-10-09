package src.PaymentGateway;

import src.PaymentGateway.Strategy.PaymentProcessor;
import src.PaymentGateway.enums.PaymentStatus;
import src.PaymentGateway.models.PaymentRequest;
import src.PaymentGateway.models.PaymentResponse;
import src.PaymentGateway.models.Transaction;
import src.PaymentGateway.observer.PaymentNotifier;

import java.util.ArrayList;
import java.util.List;

import static src.PaymentGateway.factory.PaymentProcessor.getProcessor;

public class PaymentGatewayService {
    private static PaymentGatewayService INSTANCE;

    private PaymentGatewayService() {}

    public synchronized static PaymentGatewayService getInstance() {
        if (INSTANCE == null) {
                INSTANCE = new PaymentGatewayService();
        }
        return INSTANCE;
    }

    private final List<PaymentNotifier> observsers = new ArrayList<>();

    public void addObserver(PaymentNotifier observer) {
        observsers.add(observer);
    }
    public void removeObserver(PaymentNotifier observer) {
        observsers.remove(observer);
    }

    public void notifyObservers(Transaction transaction) {
        observsers.forEach( o -> o.onTransactionUpdate(transaction));
    }

    public Transaction processPayment(PaymentRequest paymentRequest)
    {
        Transaction transaction = new Transaction(paymentRequest);
        try{
            PaymentProcessor processor = getProcessor(paymentRequest.getPaymentMethod());
            PaymentResponse response = processor.processPayemnt(paymentRequest);
            transaction.setStatus(response.getStatus());
        }catch (Exception e) {
            System.out.println("Payment Processing Failed " + e.getMessage());
            transaction.setStatus(PaymentStatus.FAILED);
        }
        notifyObservers(transaction);
        return transaction;
    }
}
