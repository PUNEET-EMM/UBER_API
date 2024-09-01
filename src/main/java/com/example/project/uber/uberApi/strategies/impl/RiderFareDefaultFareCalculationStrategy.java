package com.example.project.uber.uberApi.strategies.impl;

import com.example.project.uber.uberApi.entities.RideRequest;
import com.example.project.uber.uberApi.services.DistanceService;
import com.example.project.uber.uberApi.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance * RIDE_FARE_MULTIPLIER;
    }
}
