package strategy;

import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import model.enums.VehicleType;

import java.util.Optional;

public class ManualSpotAssignmentStrategyImpl implements SpotAssignmentStrategy{

    @Override
    public Optional<ParkingSpot> findingParkingSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        return Optional.empty();
    }
}
