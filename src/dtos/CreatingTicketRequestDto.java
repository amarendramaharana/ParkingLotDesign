package dtos;

import model.Vehicle;

public class CreatingTicketRequestDto {
    private long gateId;
    private long parkingLotId;
    private Vehicle vehicle;

    public CreatingTicketRequestDto(long gateId, long parkingLotId, Vehicle vehicle) {
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
        this.vehicle = vehicle;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }

    public long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
