package strategy;

import java.util.Date;

public class FlatCalculationStrategyImpl implements FeesCalculationStrategy{
    private static final double FLAT_FEE = 100.0;

    @Override
    public double calculate(Date entryTime,Date exitTime) {
        return FLAT_FEE;
    }
}
