package src.PaymentGateway.Strategy;

import src.PaymentGateway.enums.PaymentStatus;
import src.PaymentGateway.models.PaymentRequest;
import src.PaymentGateway.models.PaymentResponse;

public abstract class AbstractPaymentProcessor implements PaymentProcessor{

    private static final int MAX_RETRIES =3;

    @Override
    public PaymentResponse processPayemnt(PaymentRequest request) {
        int attempts = 0;
        PaymentResponse response;
        do{
            response = doProcess(request);
            attempts++;
        }while (response.getStatus() == PaymentStatus.FAILED && attempts < MAX_RETRIES);
        return response;
    }

    protected abstract PaymentResponse doProcess(PaymentRequest request);
}
