package src.PaymentGateway.Strategy;

import src.PaymentGateway.enums.PaymentStatus;
import src.PaymentGateway.models.PaymentRequest;
import src.PaymentGateway.models.PaymentResponse;

public class PayPalProcessor extends AbstractPaymentProcessor{

    @Override
    protected PaymentResponse doProcess(PaymentRequest request) {
        System.out.println("Procesing Paypal payment" + "amount : " + request.getAmount() + " currency : " + request.getCurrency());
        return new PaymentResponse(PaymentStatus.SUCCESSFUL, "PayPal Payment Successful");
    }
}
