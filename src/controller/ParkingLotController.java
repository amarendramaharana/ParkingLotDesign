package controller;

import validator.InputValidator;
import dtos.*;
import exception.InvalidParamException;
import model.ParkingLot;
import service.ParkingLotService;
import transformer.ParkingLotTransformer;

import java.util.List;

public class ParkingLotController {
    private final ParkingLotService parkingLotService;
    private final ParkingLotTransformer parkingLotTransformer;

    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotTransformer parkingLotTransformer) {
        this.parkingLotService = parkingLotService;
        this.parkingLotTransformer = parkingLotTransformer;
    }

    /**
     * Never do this in controller class,ParkingLot is our core model class means the table in database.
     * So we shouldn't expose them.there might be some sensitive information so we should not expose.
     * Instead of we have to create DTO class same as model class and what are the attributes we want to allow then we can add into DTO classes.
     * <p>
     * DTO LIKE A POJO CLASS , a class having only attributes without method is called pojo class.
     */
    public ParkingLotDto creatingParkingLot(ParkingLotDto parkingLotDto) throws InvalidParamException {
        validateParkingLot(parkingLotDto);
        ParkingLot parkingLotRequest = parkingLotTransformer.toParkingLot(parkingLotDto);
        ParkingLot parkingLotResponse = parkingLotService.createParkingLot(
                parkingLotRequest.getName(),
                parkingLotRequest.getAddress(),
                parkingLotRequest.getFloors(),
                parkingLotRequest.getGates(),
                parkingLotRequest.getFeesCalculationStrategy(),
                parkingLotRequest.getSpotAssignmentStrategyType());
        return parkingLotTransformer.toParkingLotDto(parkingLotResponse);
    }

    public void validateParkingLot(ParkingLotDto parkingLotDto) throws InvalidParamException {
        if (parkingLotDto == null) {
            throw new InvalidParamException("ParkingLot cannot be null");
        }
        if (InputValidator.isNotValidInput(parkingLotDto.getName())) {
            throw new InvalidParamException("Invalid ParkingLot name");
        }

        if (InputValidator.isNotValidInput(parkingLotDto.getAddress())) {
            throw new InvalidParamException("Invalid ParkingLot Address");
        }

        if (parkingLotDto.getSpotAssignmentStrategyType() == null) {
            throw new InvalidParamException("Invalid Spot Assignment StrategyType");
        }

        if (parkingLotDto.getFeesCalculationStrategy() == null) {
            throw new InvalidParamException("Invalid Fee Calculation Strategy Type");
        }

        if (parkingLotDto.getGates() == null || parkingLotDto.getGates().isEmpty()) {
            throw new InvalidParamException("Invalid gate list");
        }

        List<GateDto> gateList = parkingLotDto.getGates();
        validateGateList(gateList);

        if (parkingLotDto.getFloors() == null || parkingLotDto.getFloors().isEmpty()) {
            throw new InvalidParamException("Invalid Floor list");
        }

        List<ParkingFloorDto> floorDtoList = parkingLotDto.getFloors();
        validateFloorList(floorDtoList);
    }

    private void validateFloorList(List<ParkingFloorDto> floorDtoList) throws InvalidParamException {
        for (ParkingFloorDto parkingFloorDto : floorDtoList) {
            if (parkingFloorDto.getFloorNo() < 0) {
                throw new InvalidParamException("Invalid Floor Number");
            }

            if (parkingFloorDto.getSpots() == null || parkingFloorDto.getSpots().isEmpty()) {
                throw new InvalidParamException("Invalid Parking Spot List");
            }

            List<ParkingSpotDto> parkingSpotDtos = parkingFloorDto.getSpots();

            validateParkingSpot(parkingSpotDtos);
        }
    }

    private void validateParkingSpot(List<ParkingSpotDto> parkingSpotDtos) throws InvalidParamException {
        for (ParkingSpotDto parkingSpotDto : parkingSpotDtos) {
            if (parkingSpotDto.getParkingSpotStatus() == null) {
                throw new InvalidParamException("Invalid Parking Spot Status");
            }
            if (parkingSpotDto.getSpotNumber() <= 0) {
                throw new InvalidParamException("Invalid Spot number");
            }
            if (parkingSpotDto.getSupportVehicleTypes() == null || parkingSpotDto.getSupportVehicleTypes().isEmpty()) {
                throw new InvalidParamException("Invalid Vehicle Type");
            }
        }
    }

    private void validateGateList(List<GateDto> gateList) throws InvalidParamException {
        for (GateDto gateDto : gateList) {
            if (gateDto.getGateNo() <= 0) {
                throw new InvalidParamException("Invalid Gate Number");
            }
            if (gateDto.getCurrOperator() == null) {
                throw new InvalidParamException("Invalid Current Operator");
            }

            OperatorDto operatorDto = gateDto.getCurrOperator();
            if (InputValidator.isNotValidInput(operatorDto.getEmpId())) {
                throw new InvalidParamException("Invalid Operator Id");
            }
            if (InputValidator.isNotValidInput(operatorDto.getName())) {
                throw new InvalidParamException("Invalid Operator Name");
            }

            if (gateDto.getGateType() == null) {
                throw new InvalidParamException("Invalid Gate Type");
            }

            if (gateDto.getStatus() == null) {
                throw new InvalidParamException("Invalid Gate Status");
            }

        }
    }


}
