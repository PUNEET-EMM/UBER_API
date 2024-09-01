package com.example.project.uber.uberApi.services;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.SignupDto;
import com.example.project.uber.uberApi.dto.UserDto;

public interface AuthService {
    String login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userid, String vehicleId);
}
