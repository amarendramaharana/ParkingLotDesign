package dtos;

import model.Gate;
import model.ParkingFloor;
import model.enums.FeesCalculationStrategyType;
import model.enums.SpotAssignmentStrategyType;

import java.util.List;

public class ParkingLotDto {
    private String name;
    private String address;
    private List<ParkingFloorDto> floors;
    private List<GateDto> gates;
    private FeesCalculationStrategyType feesCalculationStrategy;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloorDto> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloorDto> floors) {
        this.floors = floors;
    }

    public List<GateDto> getGates() {
        return gates;
    }

    public void setGates(List<GateDto> gates) {
        this.gates = gates;
    }

    public FeesCalculationStrategyType getFeesCalculationStrategy() {
        return feesCalculationStrategy;
    }

    public void setFeesCalculationStrategy(FeesCalculationStrategyType feesCalculationStrategy) {
        this.feesCalculationStrategy = feesCalculationStrategy;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }
}
