package model;

import model.enums.VehicleType;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private String billNo;
    private Date exitTime;
    private List<Payment> payments;
    private Ticket ticket;
    private int amount;
    private Gate gates;
    private Operator generatedBy;
    private VehicleType vehicleType;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Gate getGates() {
        return gates;
    }

    public void setGates(Gate gates) {
        this.gates = gates;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
