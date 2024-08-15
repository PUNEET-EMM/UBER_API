package com.example.project.uber.uberApi.controllers;


import com.example.project.uber.uberApi.dto.RideDto;
import com.example.project.uber.uberApi.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;


    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDto> acceptRide(@RequestParam  Long rideRequestId){
        return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
    }

}
