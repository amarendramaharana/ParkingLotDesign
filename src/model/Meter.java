package model;

public class Meter extends  BaseModel{
    private Consumption consumption;

    public Consumption getConsumption() {
        return consumption;
    }

    public void setConsumption(Consumption consumption) {
        this.consumption = consumption;
    }
}
