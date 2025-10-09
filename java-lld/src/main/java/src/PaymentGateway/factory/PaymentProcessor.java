package src.PaymentGateway.factory;

import src.PaymentGateway.Strategy.CreditCardProcessor;
import src.PaymentGateway.Strategy.PayPalProcessor;
import src.PaymentGateway.Strategy.UPIProcessor;
import src.PaymentGateway.enums.PaymentMethod;

public class PaymentProcessor {
    public static src.PaymentGateway.Strategy.PaymentProcessor getProcessor(PaymentMethod payMethod) {
        switch (payMethod) {
            case PAYPAL:
                return new PayPalProcessor();
            case UPI:
                return new UPIProcessor();
            case CREDIT_CARD:
                return new CreditCardProcessor();
            default:
                throw new IllegalArgumentException("Unsupported payment method" + payMethod);
        }
    }
}
