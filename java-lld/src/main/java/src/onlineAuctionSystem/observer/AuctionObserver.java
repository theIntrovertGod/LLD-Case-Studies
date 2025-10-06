package src.onlineAuctionSystem.observer;

import src.onlineAuctionSystem.entities.Auction;

public interface AuctionObserver {
    void onUpdate(Auction auction, String message);
}
