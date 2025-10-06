package src.PaymentGateway.models;

import src.PaymentGateway.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final PaymentRequest paymentRequest;
    private PaymentStatus status;
    private final LocalDateTime timestamp;

    public Transaction(PaymentRequest paymentRequest) {
        this.id = paymentRequest.getTransactionId();
        this.paymentRequest = paymentRequest;
        this.status = PaymentStatus.INITATED;
        this.timestamp = LocalDateTime.now();
    }

    //IMportant Setter
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    //Important Getters
    public String getId() {
        return id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }
}
