package src.parkingLot.enities;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<String, ParkingSpot> spots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getSpotId(), spot);
    }

//    ***IMportant
    public synchronized Optional<ParkingSpot> findAvailability(Vehicle vehicle) {
        return spots.values().stream()
                .filter(spot -> !spot.isOccupied() && spot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotSize))
                .findFirst();

    }

    public void displayAvailability() {

    }
}
