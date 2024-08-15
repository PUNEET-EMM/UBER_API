package com.example.project.uber.uberApi.services;

import com.example.project.uber.uberApi.entities.RideRequest;

public interface RideRequestService {
    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}