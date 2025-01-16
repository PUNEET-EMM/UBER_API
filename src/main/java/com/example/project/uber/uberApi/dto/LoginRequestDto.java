package com.example.project.uber.uberApi.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}