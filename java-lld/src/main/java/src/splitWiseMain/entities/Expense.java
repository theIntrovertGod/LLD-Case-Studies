package src.splitWiseMain.entities;

import src.splitWiseMain.SplitStrategy.SplitStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String id;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final LocalDateTime paidDate;
    private final List<Split> splits;

//    public Expense(String description, double amount, User paidBy) {
//        this.description = description;
//        this.amount = amount;
//        this.paidBy = paidBy;
//        this.id = UUID.randomUUID().toString();
//        this.paidDate = LocalDateTime.now();
//        this.splits = new ArrayList<>();
//    }

    public Expense(ExpenseBuilder expenseBuilder) {
        this.description = expenseBuilder.description;
        this.amount = expenseBuilder.amount;
        this.paidBy = expenseBuilder.paidBy;
        this.id = UUID.randomUUID().toString();
        this.paidDate = LocalDateTime.now();
        this.splits = new ArrayList<>();
    }

    public User getPaidBY() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public static class ExpenseBuilder {
        private String id;
        private String description;
        private double amount;
        private User paidBy;
        private LocalDateTime paidDate;
//        private List<Split> splits;
        private List<User> participants;
        private SplitStrategy splitStrategy;
        private List<Double> splitValues;

        public ExpenseBuilder setId(String id) {
            this.id = id;
            return this;
        }
        public ExpenseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }
        public ExpenseBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }
        public ExpenseBuilder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }
        public ExpenseBuilder setPaidDate(LocalDateTime paidDate) {
            this.paidDate = paidDate;
            return this;
        }
//        public ExpenseBuilder setSplits(List<Split> splits) {
//            this.splits = splits;
//            return this;
//        }
        public ExpenseBuilder setParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }
        public ExpenseBuilder setSplitStrategy (SplitStrategy splitStrategy){
            this.splitStrategy = splitStrategy;
            return this;
        }
        public ExpenseBuilder setSplitValues(List<Double> splitValues) {
            this.splitValues = splitValues;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }





    }

}
