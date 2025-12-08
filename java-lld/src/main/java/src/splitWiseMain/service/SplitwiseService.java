package src.splitWiseMain.service;

import src.splitWiseMain.entities.*;

import java.util.*;

public class SplitwiseService {
    private static SplitwiseService INSTANCE;
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();

    private SplitwiseService() {}

    public static synchronized SplitwiseService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SplitwiseService();
        }
        return INSTANCE;
    }

    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getName(), user);
        return user;
    }
    public Group addGroup(String groupName, List<User> members) {
        Group group = new Group(groupName, members);
        groups.put(groupName, group);
        return group;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }

//    --- Core Functionalality---

    public synchronized void createExpense(Expense.ExpenseBuilder builder) {
        Expense  expense = builder.build();
        User paidBy = expense.getPaidBY();

        for (Split split : expense.getSplits()){
            User user = split.getUser();
            double amount = split.getAmount();

            if (!paidBy.equals(user)) {
                paidBy.getBalanceSheet().adjustBalance(user, amount);
                user.getBalanceSheet().adjustBalance(user, -amount);
            }
        }
    }

//    1-on-1 :SIngle Settlemnet

    public synchronized void settleUp (String payerId, String payeeId, double amount) {
        User payer = users.get(payerId);
        User payee = users.get(payeeId);

        payee.getBalanceSheet().adjustBalance(payer, -amount);
        payer.getBalanceSheet().adjustBalance(payee, amount);
    }

    public List<Transaction> simplifyGroupDebt(String groupId) {
        Group group = groups.get(groupId);
        List<Transaction> transactions = new ArrayList<>();
        Map<User, Double> netBalance = new HashMap<>();
        for (User member : group.getMembers()) {
            double balance = 0;
            for (Map.Entry<User, Double> entry: member.getBalanceSheet().getBalances().entrySet()) {
                if (group.getMembers().contains(entry.getKey())) {
                    balance += entry.getValue();
                }
            }
            netBalance.put(member, balance);
        }

        PriorityQueue<Map.Entry<User, Double>> creditors = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));
        PriorityQueue<Map.Entry<User, Double>> debitors = new PriorityQueue<>((a,b) -> Double.compare(a.getValue(), b.getValue()));


        for (Map.Entry<User, Double> entry : netBalance.entrySet()) {
            if(entry.getValue() > 0) {
                creditors.offer(entry);
            }else if(entry.getValue() < 0) {
                debitors.offer(entry);
            }
        }

        while (!creditors.isEmpty() && !debitors.isEmpty()) {
            Map.Entry<User, Double> creditor = creditors.poll();
            Map.Entry<User, Double> debitor = debitors.poll();

            double amountTOSettle = Math.min(creditor.getValue(), -debitor.getValue());

            transactions.add(new Transaction(debitor.getKey().getId(), creditor.getKey().getId(), amountTOSettle));
            creditor.setValue(creditor.getValue() - amountTOSettle);
            debitor.setValue(debitor.getValue() + amountTOSettle);

            if (creditor.getValue() > 0){
                creditors.offer(creditor);
            }
            if (debitor.getValue() < 0) {
                debitors.offer(debitor);
            }
        }
        return transactions;
    }
}
