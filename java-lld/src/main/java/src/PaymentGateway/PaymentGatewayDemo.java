package src.PaymentGateway;

import src.PaymentGateway.enums.PaymentMethod;
import src.PaymentGateway.models.PaymentRequest;
import src.PaymentGateway.observer.CustomerNotifier;
import src.PaymentGateway.observer.MerchantNotifier;

import java.util.Map;

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        PaymentGatewayService service = PaymentGatewayService.getInstance();

        service.addObserver(new MerchantNotifier());
        service.addObserver(new CustomerNotifier());

        System.out.println("Scenario 1- PAypal Payment");

//        PaymentRequest paypalRequest = new PaymentRequest.Builder()
//                .payerId("123LundWala")
//                .amount(10000)
//                .curreny("INR")
//                .paymentMethod(PaymentMethod.PAYPAL)
//                .paymentDetails(Map.of("email", "Mojhan@ooad.com"))
//                .build();
        PaymentRequest paypalRequest = new PaymentRequest(100.0, "teesmaarKahn", "INR", PaymentMethod.PAYPAL, Map.of("email", "teesmaarKahn@gmail.com"));

        service.processPayment(paypalRequest);


        System.out.println("Scenario 1- Credit Card  Payment");
        PaymentRequest creditCardReq = new PaymentRequest(100.0, "jalebiBai", "INR", PaymentMethod.CREDIT_CARD, Map.of("cardNUm", "32-26-36"));
//        service.processPayment(paypalRequest);
        service.processPayment(creditCardReq);

    }
}
