package src.parkingLot.strategies.fee;

import src.parkingLot.enities.ParkingTicket;
import src.parkingLot.enums.VehicleSize;

import java.util.Map;

interface FeeStategy {
    double calculateFee(ParkingTicket parkingTicket);
}

class FlatRateFeeStategy implements FeeStategy {

    private static final double RATE_PER_HOUR = 100.0;
    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getEndTime() -parkingTicket.getStartTime();
        long hours = (duration  / (1000 *60*60)) + 1;
        return hours * RATE_PER_HOUR;
    }
}

class VehicleRateFeeStategy implements FeeStategy {
    private static final Map<VehicleSize, Double> HOURLY_RATES = Map.of(
            VehicleSize.SMALL, 100.0,
            VehicleSize.MEDIUM, 200.0,
            VehicleSize.LARGE, 300.0)

    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getEndTime() -parkingTicket.getStartTime();
        long hours = (duration  / (1000 *60*60)) + 1;
        return hours * HOURLY_RATES.get(parkingTicket.getVehicle().getSize());
    }
}