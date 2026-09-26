package model;

import java.util.Date;

public class Ticket extends BaseModel{
    private Date entryTime;
    private String ticketNumber;
    private Gate generatedAt;
    private Vehicle vehicle;
    private Operator generatedBy;
    private ParkingSpot parkingSpot;

    public Ticket(Date entryTime, String  ticketNumber, Gate generatedAt, Vehicle vehicle, Operator generatedBy, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.ticketNumber = ticketNumber;
        this.generatedAt = generatedAt;
        this.vehicle = vehicle;
        this.generatedBy = generatedBy;
        this.parkingSpot = parkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
