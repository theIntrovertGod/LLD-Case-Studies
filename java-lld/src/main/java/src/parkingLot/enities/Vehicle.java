package src.parkingLot.enities;

import src.parkingLot.enums.VehicleSize;

abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleSize size;
    private final String ownerLicenseNumber;


    public Vehicle(String vehicleNumber, String ownerLicenseNumber, VehicleSize size) {
        this.vehicleNumber = vehicleNumber;
        this.size = size;
        this.ownerLicenseNumber = ownerLicenseNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleSize getSize() {
        return size;
    }

}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, String ownerLicenseNumber) {
        super(vehicleNumber, ownerLicenseNumber, VehicleSize.SMALL);
    }
}

class Car extends Vehicle {
    public Car(String vehicleNumber, String ownerLicenseNumber) {
        super(vehicleNumber, ownerLicenseNumber, VehicleSize.MEDIUM);
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, String ownerLicenseNumber) {
        super(vehicleNumber, ownerLicenseNumber, VehicleSize.LARGE);
    }
}

