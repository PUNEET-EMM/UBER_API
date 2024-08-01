package com.example.project.uber.uberApi.services.impl;


import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.RideDto;
import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.dto.RiderDto;
import com.example.project.uber.uberApi.entities.RideRequest;
import com.example.project.uber.uberApi.entities.enums.RideRequestStatus;
import com.example.project.uber.uberApi.repositories.RideRequestRepository;
import com.example.project.uber.uberApi.repositories.RiderRepository;
import com.example.project.uber.uberApi.services.RiderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class RiderServiceImpl implements RiderService {


    private final ModelMapper modelMapper;
    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        return null;
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

    @Override
    public RideRequestDto rideRequest(RideRequestDto rideRequestDto) {
        RideRequest rideRequest =modelMapper.map(rideRequestDto,RideRequest.class);
        log.info(rideRequest.toString());
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
//        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
//        return modelMapper.map(savedRideRequest,RideRequestDto.class);

                return modelMapper.map(rideRequest,RideRequestDto.class);

    }
}
