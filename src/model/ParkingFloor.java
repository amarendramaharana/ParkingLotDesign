package model;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> spots;
    private int floorNo;

    public ParkingFloor(List<ParkingSpot> spots, int floorNo) {
        this.spots = spots;
        this.floorNo = floorNo;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
}
