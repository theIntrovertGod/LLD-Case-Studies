package src.onlineAuctionSystem.entities;

import src.onlineAuctionSystem.observer.AuctionObserver;

import java.util.UUID;

public class User implements AuctionObserver {
    private final String id;
    private final String name;

    public User(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public void onUpdate(Auction auction, String message) {
        System.out.println("--- Notification for --- " + "Auction " + auction.getItemName());
        System.out.println(message);
    }
}
