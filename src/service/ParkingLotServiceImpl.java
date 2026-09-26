package service;

import model.Gate;
import model.ParkingFloor;
import model.ParkingLot;
import model.enums.FeesCalculationStrategyType;
import model.enums.SpotAssignmentStrategyType;
import repository.GateRepo;
import repository.ParkingFloorRepo;
import repository.ParkingLotRepo;

import java.util.List;

public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingFloorRepo parkingFloorRepo;
    private GateRepo gateRepo;
    private ParkingLotRepo parkingLotRepo;

    public ParkingLotServiceImpl(ParkingFloorRepo parkingFloorRepo, GateRepo gateRepo, ParkingLotRepo parkingLotRepo) {
        this.parkingFloorRepo = parkingFloorRepo;
        this.gateRepo = gateRepo;
        this.parkingLotRepo = parkingLotRepo;
    }

    @Override
    public ParkingLot createParkingLot(String name, String address, List<ParkingFloor> floors, List<Gate> gates, FeesCalculationStrategyType feesCalculationStrategy, SpotAssignmentStrategyType spotAssignmentStrategyType) {
        // save parking floor
        for (ParkingFloor parkingFloor : floors) {
            parkingFloorRepo.save(parkingFloor);
        }

        //save the gates
        for (Gate gate : gates){
            gateRepo.save(gate);
        }

        ParkingLot parkingLot = new ParkingLot(name,address,floors,gates,feesCalculationStrategy,spotAssignmentStrategyType);
        return parkingLotRepo.save(parkingLot);
    }
}
