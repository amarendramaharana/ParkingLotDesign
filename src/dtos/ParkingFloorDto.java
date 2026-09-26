package dtos;

import model.ParkingSpot;

import java.util.List;

public class ParkingFloorDto {
    private List<ParkingSpotDto> spots;
    private int floorNo;

    public List<ParkingSpotDto> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpotDto> spots) {
        this.spots = spots;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
}
