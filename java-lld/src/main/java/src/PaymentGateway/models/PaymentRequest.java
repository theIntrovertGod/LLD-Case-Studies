package src.PaymentGateway.models;

import src.PaymentGateway.enums.PaymentMethod;

import java.util.Map;
import java.util.UUID;

public class PaymentRequest {
    private final String transactionId;
    private final double amount;
    private final String payerId;
    private final String currency;
    private final PaymentMethod paymentMethod;
    private final Map<String, String> paymentDetails;

    public PaymentRequest( double amount, String payerId, String currency, PaymentMethod paymentMethod, Map<String, String> paymentDetails) {
        this.transactionId = UUID.randomUUID().toString();
        this.amount = amount;
        this.payerId = payerId;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
    }

//    public PaymentRequest(Builder builder){
//        this.transactionId = UUID.randomUUID().toString();
//        this.amount = builder.amount;
//        this.payerId = builder.payerId;
//        this.currency = builder.currency;
//        this.paymentMethod = builder.paymentMethod;
//        this.paymentDetails = builder.paymentDetails;
//    }
//
    //Getters
    public String getTransactionId() {
        return transactionId;
    }
    public double getAmount() {
        return amount;
    }
    public String getPayerId() {
        return payerId;
    }
    public String getCurrency() {
        return currency;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
//
//    public static class Builder{
//        private String transactionId;
//        private double amount;
//        private String payerId;
//        private String currency;
//        private PaymentMethod paymentMethod;
//        private Map<String, String> paymentDetails;
//
//        public Builder payerId(String payerId) {
//            payerId = payerId;
//            return this;
//        }
//        public Builder amount(double amount) {
//            amount = amount;
//            return this;
//        }
//        public Builder curreny(String curreny) {
//            curreny = curreny;
//            return this;
//        }
//        public Builder paymentMethod(PaymentMethod paymentMethod) {
//            paymentMethod = paymentMethod;
//            return this;
//        }
//
//        public Builder paymentDetails(Map<String, String> paymentDetails) {
//            paymentDetails = paymentDetails;
//            return this;
//        }
//
//        public PaymentRequest build() {
//            return new PaymentRequest(this);
//        }

    }

//    BUILDER DESIGN PAtter  ka Geeta ka saar:
//    Builder Pattern ek design pattern hai jo complex object ko step-by-step banata hai bina lambi constructors ke, taaki code readable aur flexible rahe.


//Anand Singh
//        amount
//        sender
//                receiver
//        paymentMethod

// Builder
//Oberser
//Facade...
