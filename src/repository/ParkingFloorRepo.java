package repository;

import model.ParkingFloor;
import model.ParkingLot;

import java.util.Map;
import java.util.logging.Logger;

public class ParkingFloorRepo {
    private long lastSavedId;
    private final Map<Long, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepo(Map<Long, ParkingFloor> parkingFloorMap) {
        this.parkingFloorMap = parkingFloorMap;
        this.lastSavedId = 0L;
    }

    public ParkingFloor save(ParkingFloor parkingFloor) {
        System.out.println();
        lastSavedId++;
        parkingFloor.setId(lastSavedId);
        parkingFloorMap.put(lastSavedId, parkingFloor);
        return parkingFloor;
    }

    public ParkingFloor getById(Long id) throws Exception {
        if (!parkingFloorMap.containsKey(id)) {
            throw new Exception();
        }
        return parkingFloorMap.get(id);
    }
}
