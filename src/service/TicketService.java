package service;

import exception.NoGateFoundException;
import exception.NoParkingLotFoundException;
import exception.NoParkingSpotFoundException;
import model.Vehicle;

public interface TicketService {
    public String generateTicket(long gateId, long parkingLotId, Vehicle vehicle) throws NoGateFoundException, NoParkingLotFoundException, NoParkingSpotFoundException;
}
