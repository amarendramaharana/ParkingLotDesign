package factory;

import model.enums.FeesCalculationStrategyType;
import strategy.DynamicCalculationStrategyImpl;
import strategy.FeesCalculationStrategy;
import strategy.FlatCalculationStrategyImpl;
import strategy.HourlyCalculationStrategyImpl;

public class FeesCalculationStrategyFactory {
    public static FeesCalculationStrategy getType(FeesCalculationStrategyType type){
        switch (type){
            case HOURLY -> {
                return new HourlyCalculationStrategyImpl();
            }
            case DYNAMICALLY -> {
                return  new DynamicCalculationStrategyImpl();
            }
            default -> {
                return new FlatCalculationStrategyImpl();
            }
        }
    }
}
