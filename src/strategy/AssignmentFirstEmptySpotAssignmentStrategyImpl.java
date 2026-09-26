package strategy;

import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.enums.ParkingSpotStatus;
import model.enums.VehicleType;

import java.util.Optional;

public class AssignmentFirstEmptySpotAssignmentStrategyImpl implements SpotAssignmentStrategy{

    @Override
    public Optional<ParkingSpot> findingParkingSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor parkingFloor : parkingLot.getFloors()){
            for(ParkingSpot parkingSpot : parkingFloor.getSpots()){
                if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.EMPTY && parkingSpot.getSupportVehicleTypes().contains(vehicleType)){
                  parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
