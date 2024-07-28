package com.example.project.uber.uberApi.strategies.impl;

import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.strategies.RideFareCalculationStrategy;

public class RiderFareDefaultFareCalculationStrategy  implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
