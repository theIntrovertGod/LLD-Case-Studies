package src.onlineAuctionSystem.entities;

import src.onlineAuctionSystem.enums.AuctionStatus;
import src.onlineAuctionSystem.observer.AuctionObserver;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Auction {
    private final String id;
    private final String itemName;
    private final String description;
    private final BigDecimal startingPrice;
    private final LocalDateTime endTIme;

    private final List<Bid> bids;
    private final Set<AuctionObserver> observers;
    private AuctionStatus state;
    private Bid winningBid;

    public Auction(String itemName, String description, BigDecimal startingPrice, LocalDateTime endTIme) {
        this.id = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startingPrice;
        this.endTIme = endTIme;
        this.bids = new ArrayList<>();
        this.observers = ConcurrentHashMap.newKeySet();
        this.state = AuctionStatus.ACTIVE;
    }

    public synchronized void placeBid (User bidder, BigDecimal amount){
        if(state != AuctionStatus.ACTIVE){
            throw new IllegalArgumentException("Auction is not Active.");
        }
        if(LocalDateTime.now().isAfter(endTIme)){
            endAuction();
            throw new IllegalStateException("Auction has already ended.");
        }
        Bid highestBid = getHighestBid();

        BigDecimal currentMaxAmount = highestBid== null ? startingPrice : highestBid.getAmount();

        if(amount.compareTo(currentMaxAmount)<=0) {
            throw new IllegalArgumentException("Bid must be higher than current highest bid");
        }

        User previousHighestBidder = (highestBid != null) ? highestBid.getBidder() : null;

        Bid newBid = new Bid(bidder, amount);
        bids.add(newBid);
        addObserver(bidder);

        // Notify the previous highest bidder that they have been outbid
        if (previousHighestBidder != null && !previousHighestBidder.equals(bidder)) {
            notifyObsrver(previousHighestBidder, String.format("You have been outbid, the current highest bid is :: "+ amount ));
        }

    }

    public Bid getHighestBid(){
        if (bids.isEmpty()){
            return null;
        }
        return Collections.max(bids);
    }

    public boolean isActive(){
        return state == AuctionStatus.ACTIVE;
    }

    public void endAuction(){
        if(state != AuctionStatus.ACTIVE) {
            return;
        }

        this.state =AuctionStatus.CLOSE;
        this.winningBid = getHighestBid();

        String endMessage;
        if(winningBid != null) {
            endMessage = " Auction for " + itemName + " has ended. Winner is " + getHighestBid().getBidder().getName() + " with bid amount : " + winningBid.getAmount();
        }else {
            endMessage = "Auction has ended. THere were no bids";
        }

        notifyAllobserver(endMessage);
    }

    public void addObserver (AuctionObserver observer) {
        observers.add(observer);
    }

    private void notifyAllobserver(String message) {
        for (AuctionObserver observer :observers) {
            observer.onUpdate(this, message);
        }
    }

    private void notifyObsrver(AuctionObserver observer, String message) {
        observer.onUpdate(this, message);
    }

    // Getters

    public String getid() {
        return id;
    }
    public String getItemName() {
        return itemName;
    }
    public List<Bid> getBidHistory() {
        return Collections.unmodifiableList(bids);
    }
    public AuctionStatus getState() {
        return state;
    }
    public Bid getWinningBid () {
        return winningBid;
    }
}

