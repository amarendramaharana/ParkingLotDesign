package strategy;

import java.util.Date;

public class HourlyCalculationStrategyImpl implements FeesCalculationStrategy{
    private static final double HOURLY_FEE = 30.0;
    @Override
    public double calculate(Date entryTime,Date exitTime) {
        long durationMillis  =  exitTime.getTime() - entryTime.getTime();

        long durationHours = (long) Math.ceil(durationMillis / (1000.0 * 60 * 60));

        // minimum charge for 1 hour
        if (durationHours == 0){
            durationHours = 1;
        }
        return durationHours * HOURLY_FEE;
    }
}
