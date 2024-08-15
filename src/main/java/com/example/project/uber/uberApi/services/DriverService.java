package com.example.project.uber.uberApi.services;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.RideDto;
import com.example.project.uber.uberApi.dto.RiderDto;
import com.example.project.uber.uberApi.entities.Driver;

import java.util.List;

public interface DriverService {
    RideDto acceptRide(Long rideId);

    RideDto cancelRide(Long rideId);


    RideDto startRide(Long rideId, String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    List<RideDto> getAllMyRides();

    Driver getCurrentDriver();
}
