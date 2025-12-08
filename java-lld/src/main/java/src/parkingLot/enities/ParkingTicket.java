package src.parkingLot.enities;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long startTime;
    private long endTime;


    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.startTime = new Date().getTime();
    }

    public String getTicketId() {
        return ticketId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public ParkingSpot getSpot() {
        return spot;
    }
    public long getStartTime() {
        return startTime;
    }
    public Long getEndTime() {
        return endTime;
    }
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
