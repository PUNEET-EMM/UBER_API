package com.example.project.uber.uberApi.strategies.impl;

import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.RideRequest;
import com.example.project.uber.uberApi.repositories.DriverRepository;
import com.example.project.uber.uberApi.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional()
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    private  final DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());

    }
}
