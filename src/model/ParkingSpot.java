package model;

import model.enums.ParkingSpotStatus;
import model.enums.VehicleType;

import java.util.Arrays;
import java.util.List;

public class ParkingSpot extends BaseModel{
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> supportVehicleTypes;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        parkingSpotStatus = ParkingSpotStatus.EMPTY;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getSupportVehicleTypes() {
        return supportVehicleTypes;
    }

    public void setSupportVehicleTypes(List<VehicleType> supportVehicleTypes) {
        this.supportVehicleTypes = supportVehicleTypes;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}
