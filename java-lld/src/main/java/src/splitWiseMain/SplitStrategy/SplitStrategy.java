package src.splitWiseMain.SplitStrategy;

import src.splitWiseMain.entities.Split;
import src.splitWiseMain.entities.User;

import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSPlit(double totalAmount, User paidBy, List<User> participants, List<Double> splitValues) ;
}
