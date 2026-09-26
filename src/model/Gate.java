package model;

import model.enums.GateStatus;
import model.enums.GateType;

public class Gate extends BaseModel{
    private int gateNo;
    private GateType gateType;
    private Operator currOperator;
    private GateStatus status;

    public Gate(int gateNo, GateType gateType, Operator currOperator, GateStatus status) {
        this.gateNo = gateNo;
        this.gateType = gateType;
        this.currOperator = currOperator;
        this.status = status;
    }


    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public Operator getCurrOperator() {
        return currOperator;
    }

    public void setCurrOperator(Operator currOperator) {
        this.currOperator = currOperator;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
