package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.SignupDto;
import com.example.project.uber.uberApi.dto.UserDto;
import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.User;
import com.example.project.uber.uberApi.entities.enums.Role;
import com.example.project.uber.uberApi.exceptions.ResourceNotFoundException;
import com.example.project.uber.uberApi.exceptions.RuntimeConflictException;
import com.example.project.uber.uberApi.repositories.UserRepository;
import com.example.project.uber.uberApi.services.AuthService;
import com.example.project.uber.uberApi.services.DriverService;
import com.example.project.uber.uberApi.services.RiderService;
import com.example.project.uber.uberApi.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.project.uber.uberApi.entities.enums.Role.DRIVER;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if (user != null) {
            throw new RuntimeConflictException("Cannot signup, User already exists with email " + signupDto.getEmail());
        }
        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        riderService.createNewRider(savedUser);
        walletService.createNewWallet(savedUser);


        return modelMapper.map(savedUser, UserDto.class);

    }

    @Override
    public DriverDto onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        if (user.getRoles().contains(DRIVER)) {
            throw new RuntimeConflictException("User with id " + userId + " is already a Driver");
        }

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDto.class);


    }
}
