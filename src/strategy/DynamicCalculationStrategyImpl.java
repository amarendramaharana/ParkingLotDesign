package strategy;

import java.util.Date;

public class DynamicCalculationStrategyImpl implements FeesCalculationStrategy{
    @Override
    public double calculate(Date entryTime,Date exitTime) {
        long durationMillis =
                exitTime.getTime() - entryTime.getTime();

        long hours = (long) Math.ceil(
                durationMillis / (1000.0 * 60 * 60)
        );

        if (hours <= 2) {
            return hours * 30;
        }

        //1 hour  → ₹30
        //2 hours → ₹60
        //3 hours → ₹110
        //4 hours → ₹160
        return (2 * 30) + ((hours - 2) * 50);
    }
}
