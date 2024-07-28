package com.example.project.uber.uberApi.strategies;

import com.example.project.uber.uberApi.dto.RideRequestDto;

public interface RideFareCalculationStrategy   {
    double calculateFare(RideRequestDto rideRequestDto);

}
