import controller.ParkingLotController;
import controller.TicketController;
import dtos.*;
import exception.*;
import model.*;
import model.enums.*;
import repository.GateRepo;
import repository.ParkingFloorRepo;
import repository.ParkingLotRepo;
import repository.TicketRepo;
import service.ParkingLotService;
import service.ParkingLotServiceImpl;
import service.TicketService;
import service.TicketServiceImpl;
import strategy.DynamicCalculationStrategyImpl;
import strategy.FeesCalculationStrategy;
import strategy.HourlyCalculationStrategyImpl;
import transformer.ParkingLotTransformer;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        ParkingFloorRepo parkingFloorRepo = new ParkingFloorRepo(new HashMap<>());
        GateRepo gateRepo = new GateRepo(new HashMap<>());
        ParkingLotRepo parkingLotRepo = new ParkingLotRepo(new HashMap<>());

        ParkingLotDto parkingLot1;
        try {
            parkingLot1 = getParkingLot1(parkingFloorRepo, gateRepo, parkingLotRepo);
        } catch (InvalidParamException e) {
            System.out.println("Creating Parking Lot error - " + e.getCause());
            return;
        }


        TicketRepo ticketRepo = new TicketRepo(new HashMap<>());

        TicketService ticketService = new TicketServiceImpl(ticketRepo, gateRepo, parkingLotRepo);
        TicketController ticketController = new TicketController(ticketService);

        Vehicle vehicle = new Vehicle("SB0071", VehicleType.TWO_WHEELER);

        CreatingTicketRequestDto requestDto = getCreatingRequestDto(1, 1, vehicle);
        try {
            TicketResponseDto responseDto = ticketController.generatingTicket(requestDto);
            String ticketNo = responseDto.getTicketNumber();

/*            CreatingTicketRequestDto requestDto2 = getCreatingRequestDto(2, 2, vehicle);
            TicketResponseDto responseDto2 = ticketController.generatingTicket(requestDto2);
            String ticketNo2 = responseDto2.getTicketNumber();*/

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Optional<Ticket> ticket1 = ticketRepo.getTicketByNumber(ticketNo);
            if (ticket1.isEmpty()) {
                System.out.println("No ticket found");
            } else {
                Ticket ticket = ticket1.get();
                FeesCalculationStrategy feesCalculationStrategy = new HourlyCalculationStrategyImpl();
               double amount =  feesCalculationStrategy.calculate(ticket.getEntryTime(),new Date());
                System.out.println("fees "+ amount);
            }

        } catch (NoGateFoundException | NoParkingLotFoundException | InvalidParamException |
                 NoParkingSpotFoundException e) {
            System.out.println("exception" + e.getMessage());
        }
    }

    private static ParkingLotDto getParkingLot1(ParkingFloorRepo parkingFloorRepo, GateRepo gateRepo, ParkingLotRepo parkingLotRepo) throws InvalidParamException {
        ParkingLotService parkingLotService = new ParkingLotServiceImpl(parkingFloorRepo, gateRepo, parkingLotRepo);
        ParkingLotTransformer parkingLotTransformer = getParkingLotTransfer();
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService, parkingLotTransformer);
        ParkingLotDto parkingLotDto = getParkingLotDto();
        return parkingLotController.creatingParkingLot(parkingLotDto);

    }

    private static CreatingTicketRequestDto getCreatingRequestDto(long gateId, long parkingLotId, Vehicle vehicle) {
        CreatingTicketRequestDto requestDto = new CreatingTicketRequestDto(gateId, parkingLotId, vehicle);
        return requestDto;
    }

    private static ParkingLotDto getParkingLotDto() {
        ParkingLotDto parkingLotDto = new ParkingLotDto();
        parkingLotDto.setAddress("Sobha Bengaluru");
        parkingLotDto.setName("Amar PARK Enterprises");
        parkingLotDto.setFeesCalculationStrategy(FeesCalculationStrategyType.HOURLY);
        parkingLotDto.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.ASSIGN_FIRST_EMPTY);
        List<ParkingFloorDto> floors = getFloorListDto();
        parkingLotDto.setFloors(floors);
        List<GateDto> gateDtoList = getGateDtoList();
        parkingLotDto.setGates(gateDtoList);
        return parkingLotDto;
    }

    private static List<GateDto> getGateDtoList() {
        GateDto gateDto = new GateDto();
        gateDto.setGateNo(12);
        OperatorDto amar = getCurrentOperatorDto();
        gateDto.setCurrOperator(amar);

        gateDto.setGateType(GateType.FRONT);
        gateDto.setStatus(GateStatus.OPEN);

        List<GateDto> gateDtoList = new ArrayList<>();
        gateDtoList.add(gateDto);
        return gateDtoList;
    }

    private static OperatorDto getCurrentOperatorDto() {
        OperatorDto operatorDto = new OperatorDto();
        operatorDto.setEmpId("emp443");
        operatorDto.setName("Amarendra Moharana");
        return operatorDto;
    }

    private static List<ParkingFloorDto> getFloorListDto() {
        ParkingFloorDto floor1 = new ParkingFloorDto();
        floor1.setFloorNo(1);
        List<ParkingSpotDto> spotListFloor1 = getSpotListFloor1();
        floor1.setSpots(spotListFloor1);

        ParkingFloorDto floor2 = new ParkingFloorDto();
        floor2.setFloorNo(2);
        List<ParkingSpotDto> spotListFloor2 = getSpotListFloor2();
        floor2.setSpots(spotListFloor2);


        List<ParkingFloorDto> list = new ArrayList<>();
        list.add(floor1);
        list.add(floor2);

        return list;
    }

    private static List<ParkingSpotDto> getSpotListFloor2() {
        ParkingSpotDto floor2Spot = new ParkingSpotDto();
        floor2Spot.setSpotNumber(124);
        floor2Spot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        floor2Spot.setSupportVehicleTypes(Arrays.asList(VehicleType.FOUR_WHEELER));

        List<ParkingSpotDto> spotDtoList = new ArrayList<>();
        spotDtoList.add(floor2Spot);

        return spotDtoList;
    }

    private static List<ParkingSpotDto> getSpotListFloor1() {
        ParkingSpotDto floor1Spot = new ParkingSpotDto();
        floor1Spot.setSpotNumber(12);
        floor1Spot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        floor1Spot.setSupportVehicleTypes(Arrays.asList(VehicleType.TWO_WHEELER));

        List<ParkingSpotDto> spotDtoList = new ArrayList<>();
        spotDtoList.add(floor1Spot);

        return spotDtoList;
    }

    private static ParkingLotTransformer getParkingLotTransfer() {
        return new ParkingLotTransformer();
    }

}