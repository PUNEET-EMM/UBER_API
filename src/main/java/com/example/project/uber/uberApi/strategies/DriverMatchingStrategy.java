package com.example.project.uber.uberApi.strategies;

import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);

}
