package src.onlineAuctionSystem;

import src.onlineAuctionSystem.entities.Auction;
import src.onlineAuctionSystem.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuctionSystemDemo {
    public static void main(String[] args) {
        AuctionService auctionService = AuctionService.getInstance();

        // User creation
        User anand = auctionService.createUser("Anand");
        User nilesh = auctionService.createUser("Nilesh");


        User shaswat = auctionService.createUser("Shashwat");

        LocalDateTime endTime = LocalDateTime.now().plusSeconds(40);

        //Auction Creation
        Auction vintageAlcoholAuction = auctionService.createAuction(
                "Vintage JD",
                "1920's JD",
                new BigDecimal("1000.00"),
                endTime
        );

        //Bidding
        try{
            auctionService.placeBid(vintageAlcoholAuction.getid(), anand.getId(),  new BigDecimal("1100.00"));
            Thread.sleep(5000);

            auctionService.placeBid(vintageAlcoholAuction.getid(), nilesh.getId(),  new BigDecimal("1200.00"));
            Thread.sleep(5000);

            auctionService.placeBid(vintageAlcoholAuction.getid(), shaswat.getId(),  new BigDecimal("2200.00"));
            Thread.sleep(5000);


            auctionService.placeBid(vintageAlcoholAuction.getid(), anand.getId(),  new BigDecimal("4000.00"));
            Thread.sleep(5000);
            Thread.sleep(21000);

        }catch(Exception e){
            System.out.println("An error occurred while bidding: " + e.getMessage());
        }

//        Post Auction

        // Display WInner

        Auction endedAuction = auctionService.getAuction(vintageAlcoholAuction.getid());

        if(endedAuction.getWinningBid() != null) {
            System.out.println("Winner Winner CHicken DInner : " + endedAuction.getWinningBid().getBidder().getName());
            System.out.println("Winner Winner Winning AMount : " + endedAuction.getWinningBid().getAmount());
        }

        // Bid History Print

        System.out.println("Bid Hsitory");
        endedAuction.getBidHistory().forEach(System.out::println);

        // Try to place bid after after auction eneded

        try{
            auctionService.placeBid(vintageAlcoholAuction.getid(), anand.getId(),  new BigDecimal("10000.00"));
        }catch (Exception e) {
            System.out.println("caught Exception " + e.getMessage());
        }
    }

}
