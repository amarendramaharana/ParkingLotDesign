# Requirement Gather

1. Parking lot will have multiple floors.
2. Each floor should have multiple parking spots.
3. There will be multiple entry/exit gates.
4. Parking will support some set of vehicles.
5. A parking spot will be associated to a vehicle type.
6. Vehicle types → 2W / 4W / 2W-EV / 4W-EV
7. Parking lot should support multiple types of fee calculation.
8. Payment can be done → Cash / UPI / FASTag 
9. Store details of each vehicle at the parking lot. 
10. Facility to charge EV at the parking lot. 
11. Meter is associated with EV parking. 
12. we should support both Mechanisms of spot assignment
    -> automatic 
    -> Manual(means user can park anywhere available)


# Class Digram

1. ParkingLot
  - id :Long
  - name : String
  - address : String
  - floors : List<ParkingFloor>
  - gates : List<Gate>

2. ParkingFloor
  - id : Long
  - parkingSpots : List<ParkingSpot>
  - floorNo : String

3. ParkingSpot
  - id : Long
  - spotId : Long
  - status : ParkingStatus
  - vehicleType : VehicleType

4. ParkingStatus(enum)
  - AVAILABLE
  - NOT_AVAILABLE
  - NOT_SERVICEABLE

5. VehicleType(enum)
  - TWO_WHEELER
  - FOUR_WHEELER
  - EV_TWO_WHEELER
  - EV_FOUR_WHEELER

6. Gate
  - id : Long
  - type : GateType
  - operator : Operator
  - status : GateStatus

7. GateType
  - FRONT
  - BACK

8. GateStatus
  - OPEN
  - CLOSED
  - NOT_OPERATIONAL

9. Operator
  - id : Long
  - name : String
  - empId : String

10. Vehicle
  - id : Long
  - regdNo : String
  - type : VehicleType

11. Ticket 
  - id : Long
  - entryTime : String
  - sportId : Long
  - gate : Gate

12. Bill
  - id : Long
  - billNo : String
  - exitTime : Date
  - payment : Payment
  - ticket : Ticket
  - amount : int
  - gate : Gate
  - generateBy : Operator
  - billStatus : BillStatus

13. Payment 
  - id : Long
  - externalRefNo : String (as we are using third party payment service like razorpay)
  - mode : PaymentMode
  - status : PaymentStatus
  - time : String
  - txnId : String
  - amount : int

14. PaymentMode(enum class)
  - UPI
  - CASH
  - FAST_TAG

15. PaymentStatus
  - SUCCESS
  - PENDING
  - FAILED
  - RECEIVED

16. BillStatus
  - 
17. Meter
  - consumption : Consumptions

18. Consumption
  - startTime : long
  - endTime : long

16. <<FeesCalculationStrategy>> (interface)
17. <<SpotAssignmentStrategy>> (interface)


