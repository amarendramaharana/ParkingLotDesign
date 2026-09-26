package strategy;

import java.util.Date;

public interface FeesCalculationStrategy {
    public double calculate(Date entryTime,Date exitTime);

}
