package factory;

import model.enums.SpotAssignmentStrategyType;
import strategy.AssignmentFirstEmptySpotAssignmentStrategyImpl;
import strategy.ManualSpotAssignmentStrategyImpl;
import strategy.SpotAssignmentStrategy;

public class ParkingSpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getParkingSpotStrategy(SpotAssignmentStrategyType type){
        switch (type){
            case MANUAL -> {
                return new ManualSpotAssignmentStrategyImpl();
            }
            case ASSIGN_FIRST_EMPTY -> {
                return new AssignmentFirstEmptySpotAssignmentStrategyImpl();
            }
            default -> {
                return new ManualSpotAssignmentStrategyImpl();
            }
        }
    }
}
