package src.PaymentGateway.Strategy;

import src.PaymentGateway.enums.PaymentStatus;
import src.PaymentGateway.models.PaymentRequest;
import src.PaymentGateway.models.PaymentResponse;

public class CreditCardProcessor extends AbstractPaymentProcessor{

    @Override
    protected PaymentResponse doProcess(PaymentRequest request) {
        System.out.println("Procesing Credit Card payment" + "amount : " + request.getAmount() + " currency : " + request.getCurrency());
        return new PaymentResponse(PaymentStatus.SUCCESSFUL, "Credit Card Payment Successful");
    }
}
