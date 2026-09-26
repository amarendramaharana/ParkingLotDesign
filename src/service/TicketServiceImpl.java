package service;

import exception.NoGateFoundException;
import exception.NoParkingLotFoundException;
import exception.NoParkingSpotFoundException;
import factory.ParkingSpotAssignmentStrategyFactory;
import model.*;
import model.enums.SpotAssignmentStrategyType;
import repository.GateRepo;
import repository.ParkingLotRepo;
import repository.TicketRepo;
import strategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class TicketServiceImpl implements TicketService {
    private TicketRepo ticketRepo;
    private GateRepo gateRepo;
    private ParkingLotRepo parkingLotRepo;

    public TicketServiceImpl(TicketRepo ticketRepo, GateRepo gateRepo, ParkingLotRepo parkingLotRepo) {
        this.ticketRepo = ticketRepo;
        this.gateRepo = gateRepo;
        this.parkingLotRepo = parkingLotRepo;
    }

    @Override
    public String generateTicket(long gateId, long parkingLotId, Vehicle vehicle) throws NoGateFoundException, NoParkingLotFoundException,NoParkingSpotFoundException {
        // 1. get the parking gate using gateId
        // 2.validate gate
        // 3.get parking lot using parkinglotid
        // 4.validate parking lot
        // 5.get the spot assignment type from parking lot
        // 6. get the object of SpotAssignmentStrategy from the using the type - Factory
        // 7. assign the spot
        // 8. crate the ticket

        Optional<Gate> gateOptional = gateRepo.getById(gateId);
        if (gateOptional.isEmpty()) {
            throw new NoGateFoundException("No gate Found");
        }
        Gate gate = gateOptional.get();

        Optional<ParkingLot> parkingLotOptional = parkingLotRepo.getById(parkingLotId);
        if (parkingLotOptional.isEmpty()){
            throw new NoParkingLotFoundException("No parking Lot found");
        }

        ParkingLot parkingLot = parkingLotOptional.get();

        SpotAssignmentStrategyType type = parkingLot.getSpotAssignmentStrategyType();
        SpotAssignmentStrategy spotAssignmentStrategy = ParkingSpotAssignmentStrategyFactory.getParkingSpotStrategy(type);
        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategy.findingParkingSpot(parkingLot,vehicle.getType());

        if (parkingSpotOptional.isEmpty()){
            throw new NoParkingSpotFoundException("No parking spot found");
        }
        ParkingSpot parkingSpot = parkingSpotOptional.get();

        Date entryTime = new Date();
        String ticketNumber = UUID.randomUUID().toString();
        Operator generatedBy = gate.getCurrOperator();

        Ticket ticket = new Ticket(entryTime, ticketNumber, gate, vehicle, generatedBy, parkingSpot);
        Ticket response = ticketRepo.save(ticket);
        return response.getTicketNumber();
    }
}
