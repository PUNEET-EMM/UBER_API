package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.RideDto;
import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.dto.RiderDto;
import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.RideRequest;
import com.example.project.uber.uberApi.entities.Rider;
import com.example.project.uber.uberApi.entities.User;
import com.example.project.uber.uberApi.entities.enums.RideRequestStatus;
import com.example.project.uber.uberApi.exceptions.ResourceNotFoundException;
import com.example.project.uber.uberApi.repositories.RideRequestRepository;
import com.example.project.uber.uberApi.repositories.RiderRepository;
import com.example.project.uber.uberApi.services.RiderService;
import com.example.project.uber.uberApi.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {


    private final ModelMapper modelMapper;
    private final RideRequestRepository rideRequestRepository;
    private  final  RiderRepository riderRepository;
    private  final RideStrategyManager rideStrategyManager;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        List<Driver> drivers = rideStrategyManager
                .driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);

//        TODO : Send notification to all the drivers about this ride request

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }




//    @Override
//    @Transactional
//    public RideRequestDto rideRequest(RideRequestDto rideRequestDto) {
//        Rider rider = getCurrentRider();
//        RideRequest rideRequest = modelMapper.map(rideRequestDto,RideRequest.class);
//        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
//        rideRequest.setRider(rider);
//
//        Double fare =  rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
//        rideRequest.setFare(fare);
//
//
//        RideRequest savedRideRequest =rideRequestRepository.save(rideRequest);
//
//
//        List<Driver> drivers = rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);
////         ALL driver get notification of ride to accept ride;
//
//
//      return modelMapper.map(savedRideRequest,RideRequestDto.class);
//
//    }


    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                 .builder()
                 .user(user)
                 .rating(0.0)
                 .build();
        System.out.println(rider);

        return riderRepository.save(rider);
    }


    @Override
    public Rider getCurrentRider(){
        // Spring security to get current user
        return  riderRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException(
                "Rider not found with id: "+1
        ));

    }

}
