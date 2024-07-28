package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.SignupDto;
import com.example.project.uber.uberApi.dto.UserDto;
import com.example.project.uber.uberApi.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userid) {
        return null;
    }
}
