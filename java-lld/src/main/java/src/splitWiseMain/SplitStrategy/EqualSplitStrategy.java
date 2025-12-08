package src.splitWiseMain.SplitStrategy;

import src.splitWiseMain.entities.Split;
import src.splitWiseMain.entities.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSPlit(double totalAmount, User paidBy, List<User> participants, List<Double> splitValues) {
        List<Split> splits = new ArrayList<>();
        double amtPerPerson = totalAmount / participants.size();
        for (User participant : participants) {
            splits.add(new Split(participant, amtPerPerson));
        }
        return splits;
    }
}
