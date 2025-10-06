package src.onlineAuctionSystem;

import src.onlineAuctionSystem.entities.Auction;
import src.onlineAuctionSystem.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.*;

public class AuctionService {
    private static AuctionService INSTANCE;
    private final Map<String, Auction> auctions ;
    private final Map<String, User> users;
    private final ScheduledExecutorService scheduler;

    private AuctionService() {
        users = new ConcurrentHashMap<>();
        auctions = new ConcurrentHashMap<>();
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public static synchronized AuctionService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AuctionService();
        }
        return INSTANCE;
    }

    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public Auction createAuction(String itemName, String description, BigDecimal startingPrice, LocalDateTime endTIme) {
        Auction auction = new Auction(itemName, description, startingPrice, endTIme);
        auctions.put(auction.getid(), auction);

        long delay = java.time.Duration.between(LocalDateTime.now(), endTIme).toMillis();
        scheduler.schedule(()-> endAuction(auction.getid()), delay, TimeUnit.MILLISECONDS);
        return auction;
    }

    public List<Auction> viewLiveAuctions (){
        return auctions.values().stream().filter(Auction::isActive).toList();
    }

    public void placeBid(String auctionId, String bidderId, BigDecimal bidAmount) {
        Auction auction = auctions.get(auctionId);
        auction.placeBid(users.get(bidderId), bidAmount);
    }

    public void endAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        auction.endAuction();
    }

    public Auction getAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if(auction == null) {
            throw new NoSuchElementException(" Auction with id :" + auctionId + " not found ");
        }
        return auction;
    }

    public void shutdown() {
        scheduler.shutdown();
    }

}
