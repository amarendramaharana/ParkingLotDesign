package service;

import model.Gate;
import model.ParkingFloor;
import model.ParkingLot;
import model.enums.FeesCalculationStrategyType;
import model.enums.SpotAssignmentStrategyType;

import java.util.List;

public interface ParkingLotService {
     ParkingLot createParkingLot(String name, String address, List<ParkingFloor> floors, List<Gate> gates, FeesCalculationStrategyType feesCalculationStrategy, SpotAssignmentStrategyType spotAssignmentStrategyType);
}
