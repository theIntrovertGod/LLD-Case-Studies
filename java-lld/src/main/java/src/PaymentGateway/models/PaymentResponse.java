package src.PaymentGateway.models;

import src.PaymentGateway.enums.PaymentStatus;

public class PaymentResponse {
    private final PaymentStatus status;
    private final String message;

    public PaymentResponse( PaymentStatus status, String message){
        this.status = status;
        this.message = message;
    }
    // Getters
    public PaymentStatus getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
}
