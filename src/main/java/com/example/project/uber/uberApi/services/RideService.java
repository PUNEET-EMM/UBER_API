package com.example.project.uber.uberApi.services;

import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.RideRequest;
import com.example.project.uber.uberApi.entities.Rider;
import com.example.project.uber.uberApi.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);


    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);

}
