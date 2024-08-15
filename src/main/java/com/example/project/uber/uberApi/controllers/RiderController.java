package com.example.project.uber.uberApi.controllers;


import com.example.project.uber.uberApi.dto.RideRequestDto;
import com.example.project.uber.uberApi.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

    @PostMapping("/rideRequest")
    public RideRequestDto  rideRequest(@RequestBody RideRequestDto rideRequestDto){
         return riderService.requestRide(rideRequestDto);
    }
}
