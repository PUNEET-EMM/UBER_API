package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.RideDto;
import com.example.project.uber.uberApi.dto.RiderDto;
import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.RideRequest;
import com.example.project.uber.uberApi.entities.enums.RideRequestStatus;
import com.example.project.uber.uberApi.entities.enums.RideStatus;
import com.example.project.uber.uberApi.exceptions.ResourceNotFoundException;
import com.example.project.uber.uberApi.repositories.DriverRepository;
import com.example.project.uber.uberApi.services.DriverService;
import com.example.project.uber.uberApi.services.RideRequestService;
import com.example.project.uber.uberApi.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl  implements DriverService {
    private final DriverRepository driverRepository;
    private  final RideRequestService rideRequestService;
    private final RideService rideService;
    private final ModelMapper modelMapper;



    @Override
    public RideDto acceptRide(Long rideId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideId);

        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("RideRequest cannot be accepted, status is "+ rideRequest.getRideRequestStatus());
        }
        Driver driver = getCurrentDriver();
        if(!driver.getAvailable()){
            throw new RuntimeException("Driver cannot accept ride due to unavailability");
        }
        driver.setAvailable(false);
        Driver savedDriver = driverRepository.save(driver);
        Ride ride = rideService.createNewRide(rideRequest, savedDriver);
        return modelMapper.map(ride, RideDto.class);


    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId, String otp) {
        Ride ride = rideService.getRideById(rideId);
        Driver driver = getCurrentDriver();


        if(!driver.equals(ride.getDriver())){
            throw new RuntimeException("Driver cannot start a ride as he has not accepted it earlier");

        }
        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)) {
            throw new RuntimeException("Ride status is not CONFIRMED hence cannot be started, status: "+ride.getRideStatus());
        }

        if(!otp.equals(ride.getOtp())) {
            throw new RuntimeException("Otp is not valid, otp: "+otp);
        }

        ride.setStartedAt(LocalDateTime.now());
        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);
        return modelMapper.map(savedRide, RideDto.class);

    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }


    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(() -> new ResourceNotFoundException("Driver not found with " +
                "id "+2));
    }
}
