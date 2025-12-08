package src.splitWiseMain.SplitStrategy;

import src.splitWiseMain.entities.Split;
import src.splitWiseMain.entities.User;

import java.util.ArrayList;
import java.util.List;

public class ExactSPlitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSPlit(double totalAmount, User paidBy, List<User> participants, List<Double> splitValues) {
        List<Split> splits = new ArrayList<>();
        for (int i =0; i< participants.size(); i++) {
            splits.add(new Split(participants.get(i), splitValues.get(i)));
        }
        return splits;
    }
}
