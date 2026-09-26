package model;

import model.enums.VehicleType;

import java.util.List;

public class EvParkingSpot extends ParkingSpot{
    private Meter meter;

    public EvParkingSpot(int spotNumber) {
        super(spotNumber);
    }

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }
}
