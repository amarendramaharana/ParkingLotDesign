package dtos;

import model.Operator;
import model.enums.GateStatus;
import model.enums.GateType;

public class GateDto {
    private int gateNo;
    private GateType gateType;
    private OperatorDto currOperator;
    private GateStatus status;

    public int getGateNo() {
        return gateNo;
    }

    public void setGateNo(int gateNo) {
        this.gateNo = gateNo;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public OperatorDto getCurrOperator() {
        return currOperator;
    }

    public void setCurrOperator(OperatorDto currOperator) {
        this.currOperator = currOperator;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }
}
