package model;

import model.enums.VehicleType;

public class Vehicle extends BaseModel{
    private String regdNo;
    private VehicleType type;

    public Vehicle(String regdNo, VehicleType type) {
        this.regdNo = regdNo;
        this.type = type;
    }

    public String getRegdNo() {
        return regdNo;
    }

    public void setRegdNo(String regdNo) {
        this.regdNo = regdNo;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
