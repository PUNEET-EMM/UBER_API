package com.example.project.uber.uberApi.strategies;

import com.example.project.uber.uberApi.entities.RideRequest;

public interface RideFareCalculationStrategy {
    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}
