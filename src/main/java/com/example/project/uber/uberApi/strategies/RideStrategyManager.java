package com.example.project.uber.uberApi.strategies;


import com.example.project.uber.uberApi.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.example.project.uber.uberApi.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.example.project.uber.uberApi.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import com.example.project.uber.uberApi.strategies.impl.RiderFareDefaultFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        if (riderRating >= 4.8) {
            return highestRatedDriverStrategy;
        }
        return nearestDriverStrategy;
    }

    //        6PM to 9PM is SURGE TIME
    public RideFareCalculationStrategy rideFareCalculationStrategy() {
        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);
        LocalTime currentTime = LocalTime.now();
        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
        if (isSurgeTime) return surgePricingFareCalculationStrategy;
        return defaultFareCalculationStrategy;


    }
}
