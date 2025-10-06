package src.PaymentGateway.Strategy;

import src.PaymentGateway.models.PaymentRequest;
import src.PaymentGateway.models.PaymentResponse;

public interface PaymentProcessor {
    PaymentResponse processPayemnt(PaymentRequest request);
}
