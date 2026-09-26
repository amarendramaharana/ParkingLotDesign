package repository;

import model.ParkingFloor;
import model.ParkingSpot;

import java.util.Map;

public class ParkingSpotRepo {
    private long lastSavedId;
    private final Map<Long, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepo(Map<Long, ParkingSpot> parkingSpotMap) {
        this.parkingSpotMap = parkingSpotMap;
        this.lastSavedId = 0L;
    }

    public ParkingSpot save(ParkingSpot parkingSpot) {
        lastSavedId++;
        parkingSpot.setId(lastSavedId);
        parkingSpotMap.put(lastSavedId, parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot getById(Long id) throws Exception {
        if (!parkingSpotMap.containsKey(id)) {
            throw new Exception();
        }
        return parkingSpotMap.get(id);
    }
}
