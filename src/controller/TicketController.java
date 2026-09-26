package controller;

import validator.InputValidator;
import dtos.CreatingTicketRequestDto;
import dtos.TicketResponseDto;
import exception.InvalidParamException;
import exception.NoGateFoundException;
import exception.NoParkingLotFoundException;
import exception.NoParkingSpotFoundException;
import model.Vehicle;
import service.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponseDto generatingTicket(CreatingTicketRequestDto requestDto) throws NoGateFoundException, NoParkingLotFoundException, InvalidParamException, NoParkingSpotFoundException {
        validateTicketRequest(requestDto);
        String ticketNumber = ticketService.generateTicket(requestDto.getGateId(), requestDto.getParkingLotId(), requestDto.getVehicle());
        return new TicketResponseDto(ticketNumber);
    }

    private void validateTicketRequest(CreatingTicketRequestDto requestDto) throws InvalidParamException {
        if (requestDto == null) {
            throw new InvalidParamException("CreatingTicketRequestDto can't be null");
        }

        if (requestDto.getGateId() <= 0) {
            throw new InvalidParamException("Invalid Gate Id");
        }
        if (requestDto.getParkingLotId() <= 0) {
            throw new InvalidParamException("Invalid Gate Parking Lot Id");
        }
        if (requestDto.getVehicle() == null) {
            throw new InvalidParamException("Invalid Vehicle Details");
        }
        validateVehicle(requestDto.getVehicle());

    }

    private void validateVehicle(Vehicle vehicle) throws InvalidParamException {
        if (InputValidator.isNotValidInput(vehicle.getRegdNo())) {
            throw new InvalidParamException("Invalid Registration Number");
        }
        if (vehicle.getType() == null) {
            throw new InvalidParamException("Invalid Vehicle Type");
        }
    }


}
