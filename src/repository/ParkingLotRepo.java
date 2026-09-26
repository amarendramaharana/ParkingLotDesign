package repository;

import exception.NoParkingLotFoundException;
import model.ParkingLot;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepo {
    private final Map<Long, ParkingLot> parkingLotMap;
    private Long lastSavedId;

    public ParkingLotRepo(Map<Long, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
        this.lastSavedId = 0L;
    }

    public ParkingLot save(ParkingLot parkingLot) {
        lastSavedId++;
        parkingLot.setId(lastSavedId);
        parkingLotMap.put(lastSavedId, parkingLot);
        return parkingLot;
    }

    public Optional<ParkingLot> getById(Long id) throws NoParkingLotFoundException {
        if (!parkingLotMap.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(parkingLotMap.get(id));
    }


}
