package transformer;

import dtos.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTransformer {


    public ParkingLot toParkingLot(ParkingLotDto parkingLotDto) {
        List<ParkingFloor> parkingFloors = toParkingFloors(parkingLotDto.getFloors());
        List<Gate> gates = toGates(parkingLotDto.getGates());
        return new ParkingLot(parkingLotDto.getName(), parkingLotDto.getAddress(), parkingFloors, gates, parkingLotDto.getFeesCalculationStrategy(), parkingLotDto.getSpotAssignmentStrategyType());
    }

    private List<Gate> toGates(List<GateDto> gates) {
        List<Gate> list = new ArrayList<>();
        for (GateDto gateDto : gates) {
            Gate gate = toGate(gateDto);
            list.add(gate);
        }
        return list;
    }

    private Gate toGate(GateDto gateDto) {
        Operator operator = toOperator(gateDto.getCurrOperator());
        return new Gate(gateDto.getGateNo(), gateDto.getGateType(), operator, gateDto.getStatus());
    }

    private Operator toOperator(OperatorDto operatorDto) {
        Operator operator = new Operator();
        operator.setEmpId(operatorDto.getEmpId());
        operator.setName(operatorDto.getName());
        return operator;
    }

    private List<ParkingFloor> toParkingFloors(List<ParkingFloorDto> parkingFloorDtos) {
        List<ParkingFloor> list = new ArrayList<>();
        for (ParkingFloorDto floorDto : parkingFloorDtos) {
            ParkingFloor floor = toParkingFloor(floorDto);
            list.add(floor);
        }
        return list;
    }

    private ParkingFloor toParkingFloor(ParkingFloorDto parkingFloorDto) {
        List<ParkingSpot> parkingSpots = toParkingSpots(parkingFloorDto.getSpots());
        return new ParkingFloor(parkingSpots, parkingFloorDto.getFloorNo());

    }


    private List<ParkingSpot> toParkingSpots(List<ParkingSpotDto> parkingSpotDtos) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (ParkingSpotDto parkingSpotDto : parkingSpotDtos) {
            ParkingSpot spot = toParkingSpot(parkingSpotDto);
            parkingSpots.add(spot);
        }
        return parkingSpots;
    }

    private ParkingSpot toParkingSpot(ParkingSpotDto parkingSpotDto) {
        ParkingSpot parkingSpot = new ParkingSpot(parkingSpotDto.getSpotNumber());
        parkingSpot.setSupportVehicleTypes(parkingSpotDto.getSupportVehicleTypes());
        parkingSpot.setParkingSpotStatus(parkingSpotDto.getParkingSpotStatus());
        return  parkingSpot;
    }


    public ParkingLotDto toParkingLotDto(ParkingLot parkingLotResponse) {

        ParkingLotDto parkingLotDto = new ParkingLotDto();
        parkingLotDto.setName(parkingLotResponse.getName());
        parkingLotDto.setAddress(parkingLotResponse.getAddress());

        List<GateDto> gateDtoList = toGateDtoList(parkingLotResponse.getGates());
        parkingLotDto.setGates(gateDtoList);

        List<ParkingFloorDto> floors = toFloorDtoList(parkingLotResponse.getFloors());
        parkingLotDto.setFloors(floors);

        parkingLotDto.setSpotAssignmentStrategyType(parkingLotResponse.getSpotAssignmentStrategyType());
        parkingLotDto.setFeesCalculationStrategy(parkingLotResponse.getFeesCalculationStrategy());

        return parkingLotDto;

    }

    private List<ParkingFloorDto> toFloorDtoList(List<ParkingFloor> floors) {
        List<ParkingFloorDto> parkingFloorList = new ArrayList<>();
        for (ParkingFloor parkingFloor : floors){
            ParkingFloorDto parkingFloorDto = toParkingFloorDto(parkingFloor);
            parkingFloorList.add(parkingFloorDto);
        }
        return parkingFloorList;
    }

    private ParkingFloorDto toParkingFloorDto(ParkingFloor parkingFloor) {
        ParkingFloorDto parkingFloorDto = new ParkingFloorDto();
        parkingFloorDto.setFloorNo(parkingFloor.getFloorNo());
        List<ParkingSpotDto> parkingSpotDtoList = toParkindSpotList(parkingFloor.getSpots());
        parkingFloorDto.setSpots(parkingSpotDtoList);
        return parkingFloorDto;
    }

    private List<ParkingSpotDto> toParkindSpotList(List<ParkingSpot> spots) {
        List<ParkingSpotDto> parkingSpotDtoList = new ArrayList<>();
        for (ParkingSpot spot : spots){
            ParkingSpotDto spotDto = toSpotDto(spot);
            parkingSpotDtoList.add(spotDto);
        }
        return parkingSpotDtoList;
    }

    private ParkingSpotDto toSpotDto(ParkingSpot spot) {
        ParkingSpotDto parkingSpotDto = new ParkingSpotDto();
        parkingSpotDto.setSpotNumber(spot.getSpotNumber());
        parkingSpotDto.setParkingSpotStatus(spot.getParkingSpotStatus());
        parkingSpotDto.setSupportVehicleTypes(spot.getSupportVehicleTypes());
        return parkingSpotDto;
    }

    private List<GateDto> toGateDtoList(List<Gate> gates) {
        List<GateDto> gateDtoList = new ArrayList<>();
        for (Gate gate : gates){
            GateDto gateDto = toGateDto(gate);
            gateDtoList.add(gateDto);
        }
        return gateDtoList;
    }

    private GateDto toGateDto(Gate gate) {
        GateDto gateDto = new GateDto();
        gateDto.setStatus(gate.getStatus());
        gateDto.setGateType(gate.getGateType());

        OperatorDto operatorDto = toOperatorDto(gate.getCurrOperator());
        gateDto.setCurrOperator(operatorDto);

        gateDto.setGateNo(gate.getGateNo());
        return gateDto;
    }

    private OperatorDto toOperatorDto(Operator currOperator) {
        OperatorDto operatorDto = new OperatorDto();
        operatorDto.setName(currOperator.getName());
        operatorDto.setEmpId(currOperator.getName());
        return operatorDto;
    }
}
