package src.parkingLot.strategies.parking;

import src.parkingLot.enities.ParkingFloor;
import src.parkingLot.enities.ParkingSpot;
import src.parkingLot.enities.Vehicle;
import src.parkingLot.enums.VehicleSize;

import java.util.List;
import java.util.Optional;

interface ParkingStrategy{
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
public class NearestFirstStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
//        return Optional.empty();
        Optional<ParkingSpot> bestSpot = Optional.empty();
        for (ParkingFloor floor: floors) {
            Optional<ParkingSpot> spot = floor.findAvailability(vehicle);
            if (bestSpot.isEmpty()) {
            bestSpot = spot;
            }
        }
        return bestSpot;
    }
}
public class BestFitStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        Optional<ParkingSpot> bestSpot = Optional.empty();

        for (ParkingFloor floor: floors) {
            Optional<ParkingSpot> spotOnThisFloor = floor.findAvailability(vehicle);
            if (bestSpot.isEmpty()) {
                bestSpot = spotOnThisFloor;
            }else {
                if(spotOnThisFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()) {
                    bestSpot = spotOnThisFloor;
                }
            }
        }
        return bestSpot;
    }
}
