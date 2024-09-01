package com.example.project.uber.uberApi.services;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.RideDto;
import com.example.project.uber.uberApi.dto.RiderDto;
import com.example.project.uber.uberApi.entities.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId, String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Driver getCurrentDriver();

    Driver updateDriverAvailability(Driver driver, boolean available);

    Driver createNewDriver(Driver driver);

}
