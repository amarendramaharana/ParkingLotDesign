package strategy;

import model.ParkingLot;
import model.ParkingSpot;
import model.enums.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    public Optional<ParkingSpot> findingParkingSpot(ParkingLot parkingLot, VehicleType vehicleType);
}
