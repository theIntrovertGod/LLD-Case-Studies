package src.onlineAuctionSystem.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bid implements Comparable<Bid> {
    private final User bidder;
    private final BigDecimal amount;
    private final LocalDateTime timestamp;

    public Bid(User bidder, BigDecimal amount) {
        this.bidder = bidder;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public User getBidder() {
        return bidder;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

//    BigDecimal.compareTo() returns:
//            -1 → if this.amount < other.amount
//
//            0 → if this.amount == other.amount
//
//            1 → if this.amount > other.amount
    @Override
    public int compareTo(Bid other) {
        int amountComparison = this.amount.compareTo(other.amount);
        if (amountComparison != 0) {
            return amountComparison;
        }
        return other.timestamp.compareTo(this.timestamp);
    }
}
