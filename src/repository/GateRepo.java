package repository;

import exception.NoGateFoundException;
import model.Gate;
import model.ParkingFloor;

import java.util.Map;
import java.util.Optional;

public class GateRepo {
    private long lastSavedId;
    private Map<Long, Gate> gateMap;

    public GateRepo(Map<Long, Gate> parkingFloorMap) {
        this.gateMap = parkingFloorMap;
        this.lastSavedId = 0l;
    }

    public Gate save(Gate gate){
        lastSavedId++;
        gate.setId(lastSavedId);
        gateMap.put(lastSavedId,gate);
        return gate;
    }

    public Optional<Gate> getById(Long id) throws NoGateFoundException {
        if (!gateMap.containsKey(id)) {
            return Optional.empty();
        }
        return Optional.of(gateMap.get(id));
    }
}
