package model;

import model.enums.FeesCalculationStrategyType;
import model.enums.SpotAssignmentStrategyType;
import strategy.FeesCalculationStrategy;
import strategy.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLot extends  BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private FeesCalculationStrategyType feesCalculationStrategy;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;


    public ParkingLot(String name, String address, List<ParkingFloor> floors, List<Gate> gates, FeesCalculationStrategyType feesCalculationStrategy, SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.gates = gates;
        this.feesCalculationStrategy = feesCalculationStrategy;
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }

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

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
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
