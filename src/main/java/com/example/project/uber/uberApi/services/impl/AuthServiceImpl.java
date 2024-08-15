package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.dto.DriverDto;
import com.example.project.uber.uberApi.dto.SignupDto;
import com.example.project.uber.uberApi.dto.UserDto;
import com.example.project.uber.uberApi.entities.Rider;
import com.example.project.uber.uberApi.entities.User;
import com.example.project.uber.uberApi.entities.enums.Role;
import com.example.project.uber.uberApi.exceptions.RuntimeConflictException;
import com.example.project.uber.uberApi.repositories.UserRepository;
import com.example.project.uber.uberApi.services.AuthService;
import com.example.project.uber.uberApi.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

     private  final UserRepository userRepository;
     private  final ModelMapper modelMapper;
     private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null) ;
        if(user!=null){
            throw  new RuntimeConflictException("Cannot signup, User already exists with email "+signupDto.getEmail());
        }
        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        riderService.createNewRider(savedUser);

         UserDto userDto= modelMapper.map(savedUser,UserDto.class);
         return userDto;
    }

    @Override
    public DriverDto onboardNewDriver(Long userid) {
        return null;
    }
}
