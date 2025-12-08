package src.splitWiseMain.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class BalanceSheet {
    private final User owner;

    private final Map<User, Double> balances = new ConcurrentHashMap<>();
//    + : incoming Money , -: outgoing money

    public BalanceSheet(User owner) {
        this.owner = owner;
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

    public void adjustBalance(User otherUser, double amount) {
        //check
        if(owner.equals(otherUser)) {
            return;
        }
//        balances.merge(otherUser, amount, Double::sum);
        balances.put(otherUser, balances.getOrDefault(otherUser,0.0) + amount);
    }

    public void showBalances() {
        for(Map.Entry<User, Double> entry : balances.entrySet()) {
            User anotherUser = entry.getKey();
            double amount = entry.getValue();

            System.out.println(anotherUser.getName() + " : " + amount);
        }
    }



//    synchronized  ::
//    Ashish Accout : 5000 - 5500 ,5500

//    Srajit - 500
//            , Arnav =500
//
//    5500, 5500
//
//    5000 + 500 =
//    > 5500 +500 ==> 6000
}
