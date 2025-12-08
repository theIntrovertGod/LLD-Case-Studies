package src.OnlineStockExchange.Exceptions;

public class InsufficientFundException extends RuntimeException{
    public InsufficientFundException(String message){
        super(message);
    }
}
