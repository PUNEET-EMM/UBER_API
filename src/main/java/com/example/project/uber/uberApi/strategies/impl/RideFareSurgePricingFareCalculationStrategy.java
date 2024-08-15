package com.example.project.uber.uberApi.strategies.impl;

import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.entities.RideRequest;
import com.example.project.uber.uberApi.services.DistanceService;
import com.example.project.uber.uberApi.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    private static final  Double SURGE_FACTOR = 2.0;
    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_MULTIPLIER*SURGE_FACTOR;
    }
}
